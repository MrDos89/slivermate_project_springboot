package himedia.slivermate;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.ConnectionFactoryBuilder;

@Configuration
public class MemcachedConfig {

    private final Dotenv dotenv = Dotenv.load();

    String memcachedHost = dotenv.get("AWS_MEMCACHED_ENDPOINT");
    int memcachedPort = Integer.parseInt(dotenv.get("AWS_MEMCACHED_PORT"));

    @Bean
    MemcachedClient memcachedClient() throws IOException {
        return new MemcachedClient(
            new ConnectionFactoryBuilder()
                .setOpTimeout(10000) // 요청 타임아웃을 5초로 설정
                .setDaemon(true)
                .setFailureMode(net.spy.memcached.FailureMode.Redistribute) // 실패 시 분산 재시도
                .build(),
            Collections.singletonList(new InetSocketAddress(memcachedHost, memcachedPort))
        );
    }
}