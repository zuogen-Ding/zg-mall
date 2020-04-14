package club.banyuan.demo.oss.controller;

import club.banyuan.demo.oss.service.OssFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private OssFileService ossFileService;
    @RequestMapping(value = "/image/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file")MultipartFile file){
        String filename=file.getOriginalFilename();
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMdd");
        String objectName=simpleDateFormat.format(new Date())+"/"+filename;
        try {
            return ossFileService.save(objectName, file.getInputStream(),file.getContentType());

        }catch (IOException e){
            e.printStackTrace();
        }

        return "fail";
    }

    @RequestMapping(value = "/image/delete",method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("objectName")String objectName){
        try {
            return ossFileService.delete(objectName);

        }catch (IOException e){
            e.printStackTrace();
        }

        return "fail";
    }
}
