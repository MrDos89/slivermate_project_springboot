package himedia.slivermate;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDBConfiguration {
	private final Dotenv dotenv = Dotenv.load();
	
    String accessKey = dotenv.get("AWS_ACCESS_KEY");
    String secretKey = dotenv.get("AWS_SECRET_KEY");
    String region = dotenv.get("AWS_REGION");  // AWS_REGION을 환경변수에서 읽어옴
    
    @Bean
	public DynamoDbClient dynamoDbClient(){
    	return DynamoDbClient.builder()
    			.region(Region.of(region))
    			.credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey)))
    			.build();
	}

	@Bean
	public DynamoDbEnhancedClient dynamoDbEnhancedClient(@Qualifier("dynamoDbClient") DynamoDbClient dynamoDbClient){
		return DynamoDbEnhancedClient.builder()
				.dynamoDbClient(dynamoDbClient)
				.build();
	}
}