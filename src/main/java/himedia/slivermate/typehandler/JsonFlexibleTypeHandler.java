package himedia.slivermate.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFlexibleTypeHandler extends BaseTypeHandler<Object> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        try {
            ps.setString(i, objectMapper.writeValueAsString(parameter));
        } catch (Exception e) {
            throw new SQLException("Error converting object to JSON string", e);
        }
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return parseJson(rs.getString(columnName));
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return parseJson(rs.getString(columnIndex));
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return parseJson(cs.getString(columnIndex));
    }

    private Object parseJson(String json) throws SQLException {
        if (json == null || json.isEmpty()) {
            return null;
        }
        try {
            JsonNode node = objectMapper.readTree(json);
            if (node.isArray()) {
                // List<Long> 또는 List<Object>로 판별
                if (node.size() > 0 && node.get(0).isIntegralNumber()) {
                    return objectMapper.convertValue(node, new TypeReference<List<Long>>() {});
                } else {
                    return objectMapper.convertValue(node, new TypeReference<List<Object>>() {});
                }
            } else if (node.isObject()) {
                // Map<Long, String>으로 처리
                Map<String, String> tempMap = objectMapper.convertValue(node, new TypeReference<Map<String, String>>() {});
                return tempMap.entrySet().stream()
                        .collect(Collectors.toMap(e -> Long.parseLong(e.getKey()), Map.Entry::getValue));
            } else {
                // 단순 값 (예외적으로 처리)
                return objectMapper.convertValue(node, Object.class);
            }
        } catch (Exception e) {
            throw new SQLException("Error parsing JSON string", e);
        }
    }
}
