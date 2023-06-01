package com.bookcode.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@Controller
public class FileUploadController {

    @RequestMapping("/file")
    public String file() {
        return "/file";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // 将上传的文件写出到应用指定的文件目录下
                BufferedOutputStream out = new BufferedOutputStream(Files.newOutputStream(new File(Objects.requireNonNull(file.getOriginalFilename())).toPath()));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败" + e.getMessage();
            }
            return "上传成功";
        } else {
            return "文件为空,上传失败.";
        }
    }


    @RequestMapping("/multifile")
    public String multifile() {
        return "/multifile";
    }

    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");

        MultipartFile file = null;

        BufferedOutputStream out = null;
        for (int i = 0; i < files.size(); i++) {
            file = files.get(i);

            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();

                    out = new BufferedOutputStream(Files.newOutputStream(Paths.get(Objects.requireNonNull(file.getOriginalFilename()))));
                    out.write(bytes);
                    out.close();

                } catch (IOException e) {
                    out = null;
                    return "You failed to upload file " + file.getName() + "=>" + e.getMessage();
                }
            } else {
                return "You failed to upload file" + file.getName() + " because the file is empty";
            }
        }
        return "upload successful!";
    }

}
