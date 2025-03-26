package himedia.slivermate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import software.amazon.awssdk.services.s3.S3Client;

@SpringBootTest
class SlivermateApplicationTests {

	@Mock
	private S3Client s3Client;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void contextLoads() {
	}
}
