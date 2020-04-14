package club.banyuan.demo.oss.service;


import java.io.IOException;
import java.io.InputStream;
public interface OssFileService {
    String save(String objectName, InputStream stream, String contentType) throws IOException;
    String delete(String objrectName) throws IOException;
}
