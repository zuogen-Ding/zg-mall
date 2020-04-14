package club.banyuan.demo.oss.service.impl;

import club.banyuan.demo.oss.service.OssFileService;
import io.minio.MinioClient;
import io.minio.policy.PolicyType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
@Service
public class MinioOssFileServiceImpl implements OssFileService {

    @Value("${minio.endpoint}")
    private String ENDPOINT;
    @Value("${minio.bucketName}")
    private String BUCKET_NAME;
    @Value("${minio.accessKey}")
    private String ACCESS_KEY;
    @Value("${minio.secretKey}")
    private String SECRET_KEY;

    @Override
    public String save(String objectName, InputStream stream, String contentType) throws IOException {
        try {
            MinioClient minioClient = new MinioClient(ENDPOINT, ACCESS_KEY, SECRET_KEY);
            if (!minioClient.bucketExists(BUCKET_NAME)) {
                minioClient.makeBucket(BUCKET_NAME);
                minioClient.setBucketPolicy(BUCKET_NAME, "*.*", PolicyType.READ_WRITE);
            }
                minioClient.putObject(BUCKET_NAME, objectName, stream, contentType);
                return ENDPOINT + "/" + BUCKET_NAME + "/" + objectName;


        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException(e);
        }

    }

    @Override
    public String delete(String objectName) throws IOException {
        try {
            MinioClient minioClient = new MinioClient(ENDPOINT, ACCESS_KEY, SECRET_KEY);
            if (!minioClient.bucketExists(BUCKET_NAME)) {
                return "文件不存在";
            }
            minioClient.removeObject(BUCKET_NAME, objectName);
            return "success";


        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException(e);
        }
    }

}
