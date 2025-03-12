package himedia.slivermate.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapTypeHandler extends BaseTypeHandler<Map<Long, String>> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Map<Long, String> parameter, JdbcType jdbcType) throws SQLException {
        try {
            // Map을 JSON 문자열로 변환하여 저장
            ps.setString(i, objectMapper.writeValueAsString(parameter));
        } catch (Exception e) {
            throw new SQLException("Error converting Map to JSON", e);
        }
    }

    @Override
    public Map<Long, String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return convertMap(rs.getString(columnName));
    }

    @Override
    public Map<Long, String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return convertMap(rs.getString(columnIndex));
    }

    @Override
    public Map<Long, String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return convertMap(cs.getString(columnIndex));
    }

    private Map<Long, String> convertMap(String json) throws SQLException {
        if (json == null || json.isEmpty()) {
            return null;
        }
        try {
            // String, String 형태의 Map으로 먼저 변환 후 Long으로 키 변환
            Map<String, String> tempMap = objectMapper.readValue(json, new TypeReference<Map<String, String>>() {});
            return tempMap.entrySet().stream()
                    .collect(Collectors.toMap(e -> Long.parseLong(e.getKey()), Map.Entry::getValue));
        } catch (Exception e) {
            throw new SQLException("Error converting JSON to Map<Long, String>", e);
        }
    }
}
