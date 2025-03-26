package himedia.slivermate.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
@RequiredArgsConstructor
public class S3UploadService {

    private final S3Client s3Client;

    @Value("${s3.bucket.name}")
    private String bucketName;

    public String saveFile(MultipartFile multipartFile) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();
        String uniqueFileName = UUID.randomUUID() + "_" + originalFilename;

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(uniqueFileName)
                .contentType(multipartFile.getContentType())
                .contentLength(multipartFile.getSize())
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromByteBuffer(ByteBuffer.wrap(multipartFile.getBytes())));

        return s3Client.utilities().getUrl(GetUrlRequest.builder().bucket(bucketName).key(uniqueFileName).build()).toString();
    }

    public ResponseEntity<UrlResource> downloadImage(String originalFilename) throws URISyntaxException {
        try {
            URI fileUri = new URI(s3Client.utilities().getUrl(GetUrlRequest.builder()
                    .bucket(bucketName)
                    .key(originalFilename)
                    .build()).toString());

            UrlResource urlResource = new UrlResource(fileUri.toURL());

            String contentDisposition = "attachment; filename=\"" + originalFilename + "\"";

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                    .body(urlResource);

        } catch (Exception e) {
            throw new RuntimeException("파일 다운로드 중 오류 발생: " + e.getMessage(), e);
        }
    }

    public void deleteImage(String originalFilename) {
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key(originalFilename)
                .build();

        s3Client.deleteObject(deleteObjectRequest);
    }
}
