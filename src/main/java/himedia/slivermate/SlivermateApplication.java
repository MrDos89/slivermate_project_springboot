package himedia.slivermate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.awspring.cloud.autoconfigure.s3.S3AutoConfiguration;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication(exclude = {S3AutoConfiguration.class})
public class SlivermateApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load(); // .env 파일 로드
		SpringApplication.run(SlivermateApplication.class, args);
	}

}
