package himedia.slivermate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

@Configuration
public class AwsConfig {
	   private final Dotenv dotenv = Dotenv.load();

       String accessKey = dotenv.get("AWS_ACCESS_KEY");
       String secretKey = dotenv.get("AWS_SECRET_KEY");
       String region = dotenv.get("AWS_REGION");  // AWS_REGION을 환경변수에서 읽어옴
	   
	    @Bean
	    S3Client s3Client() {
	        return S3Client.builder()
	                .region(Region.of(region))
	                .credentialsProvider(
	                        StaticCredentialsProvider.create(
	                                AwsBasicCredentials.create(accessKey, secretKey)
	                        )
	                )
	                .build();
	    }

	    @Bean
	    S3Presigner s3Presigner() {
	        return S3Presigner.builder()
	                .region(Region.of(region))
	                .credentialsProvider(
	                        StaticCredentialsProvider.create(
	                                AwsBasicCredentials.create(accessKey, secretKey)
	                        )
	                )
	                .build();
	    }
}
