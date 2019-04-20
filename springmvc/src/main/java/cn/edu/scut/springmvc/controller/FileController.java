package cn.edu.scut.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author: rain
 * @date: 2019-4-15 21:45
 * @description: springmvc
 */
@Controller
public class FileController {
    @RequestMapping("/fileUpload/page")
    public String fileUploadPage() {
        return "file/upload";
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam CommonsMultipartFile file) throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("fileName：" + file.getOriginalFilename());
        String path = "E:/files/" + file.getOriginalFilename();

        File newFile = new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);
        long endTime = System.currentTimeMillis();
        System.out.println("方法二的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        return "/hello";
    }
}
