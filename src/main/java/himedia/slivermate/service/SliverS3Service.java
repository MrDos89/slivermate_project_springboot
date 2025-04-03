package himedia.slivermate.service;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

@Service
@RequiredArgsConstructor
public class SliverS3Service {
    private final S3Client s3Client;
    private final S3Presigner s3Presigner;

    @Value("${s3.bucket.name}")
    private String bucketName;
    
    /**
     * S3에 파일을 업로드하는 메서드 (Pre-Signed URL 방식이 아닌 직접 업로드)
     */
    public void uploadFile(String fileName, byte[] fileData) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .build();

        PutObjectResponse response = s3Client.putObject(putObjectRequest, software.amazon.awssdk.core.sync.RequestBody.fromBytes(fileData));

        if (!response.sdkHttpResponse().isSuccessful()) {
            throw new RuntimeException("S3 업로드 실패");
        }
    }

    /**
     * Pre-Signed URL을 생성하는 메서드
     */
    public String generatePreSignedUrl(String fileName) {
        PutObjectRequest objectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .build();

        PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                .signatureDuration(Duration.ofMinutes(10)) // 10분 후 만료
                .putObjectRequest(objectRequest)
                .build();

        PresignedPutObjectRequest presignedRequest = s3Presigner.presignPutObject(presignRequest);
        return presignedRequest.url().toString();
    }
}
