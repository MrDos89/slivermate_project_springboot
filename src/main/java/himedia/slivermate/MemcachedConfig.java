package himedia.slivermate;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;
import net.spy.memcached.MemcachedClient;

@Configuration
public class MemcachedConfig {

	private final Dotenv dotenv = Dotenv.load();
	
    String memcachedHost = dotenv.get("AWS_MEMCACHED_ENDPOINT");
    int memcachedPort = Integer.parseInt(dotenv.get("AWS_MEMCACHED_PORT"));

    @Bean
    public MemcachedClient memcachedClient() throws IOException {
        return new MemcachedClient(
            new InetSocketAddress(memcachedHost, memcachedPort)
        );
    }
}
