package himedia.slivermate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AwsConfig {

    private final Dotenv dotenv = Dotenv.load();

    @Bean
    public S3Client s3Client() {
        String accessKey = dotenv.get("AWS_ACCESS_KEY");
        String secretKey = dotenv.get("AWS_SECRET_KEY");
        String region = dotenv.get("AWS_REGION");  // AWS_REGION을 환경변수에서 읽어옴

        if (region == null || region.isEmpty()) {
            throw new IllegalArgumentException("AWS_REGION is not specified in the environment variables.");
        }

        return S3Client.builder()
                .region(Region.of(region))  // 리전 명시적으로 설정
                .credentialsProvider(
                        StaticCredentialsProvider.create(
                                AwsBasicCredentials.create(accessKey, secretKey)
                        )
                )
                .build();
    }
}
