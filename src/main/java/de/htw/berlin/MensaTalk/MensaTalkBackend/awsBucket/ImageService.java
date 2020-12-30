package de.htw.berlin.MensaTalk.MensaTalkBackend.awsBucket;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageService {

    private AmazonS3 s3client;

    @Value("${amazonProperties.bucketName}")
    private String bucketName;
    @Value("${amazonProperties.accessKey}")
    private String accessKey;
    @Value("${amazonProperties.secretKey}")
    private String secretKey;
    @Value("${amazonProperties.region}")
    private String region;


    public ImageService() {
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);

        this.s3client = AmazonS3Client.builder()
                .withRegion(this.region)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

    }

    public void uploadTos3bucket(String fileName, InputStream inputStream) throws IOException {
        byte[] contents = IOUtils.toByteArray(inputStream);
        InputStream stream = new ByteArrayInputStream(contents);

        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentLength(contents.length);
        meta.setContentType("image/png");

        s3client.putObject(new PutObjectRequest(
                bucketName, fileName, stream, meta)
                .withCannedAcl(CannedAccessControlList.Private));

        inputStream.close();
    }
}

