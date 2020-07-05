package com.changgou.controller;

import com.changgou.file.FastDFSFile;
import com.changgou.util.FastDFSClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@CrossOrigin
public class FileController {

    @PostMapping("/uploadfile")
    public Result<String> upload(@RequestParam("file") MultipartFile file) {
        String path = "";
        try {
            path = saveFile(file);
            System.out.println(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result<String>(true, StatusCode.OK, "上传文件成功", path);
    }

    /**
     * 上传文件
     *
     * @param multipartFile
     * @return
     * @throws IOException
     */
    private String saveFile(MultipartFile multipartFile) throws Exception {
        //1. 获取文件名
        String fileName = multipartFile.getOriginalFilename();
        //2. 获取文件内容
        byte[] content = multipartFile.getBytes();
        //3. 获取文件扩展名
        String ext = "";
        if (fileName != null && !"".equals(fileName)) {
            ext = fileName.substring(fileName.lastIndexOf("."));
        }
        //4. 创建文件实体类对象
        FastDFSFile fastDFSFile = new FastDFSFile(fileName, content, ext);
        //5. 上传
        String[] uploadResults = FastDFSClient.upload(fastDFSFile);
        //6. 拼接上传后的文件的完整路径和名字, uploadResults[0]为组名, uploadResults[1]为文件名称和路径
        //String path = FastDFSClient.getTrackerUrl() + uploadResults[0] + "/" + uploadResults[1];
        String path = "http://192.168.200.128:8080/" + uploadResults[0] + "/" + uploadResults[1];
        //7. 返回
        return path;
    }

    @GetMapping("/delfile/{groupName}/{remoteFileName}")
    public Result delFile(@PathVariable String groupName,@PathVariable String remoteFileName) throws Exception {
        FastDFSClient.deleteFile(groupName, remoteFileName);
        return new Result(true, StatusCode.OK, "删除文件成功");
    }

    @GetMapping("/downfile/{groupName}/{remoteFileName}")
    public Result<InputStream> downFile(@PathVariable String groupName,@PathVariable String remoteFileName) throws Exception {
        InputStream inputStream = FastDFSClient.downFile(groupName, remoteFileName);
        return new Result<InputStream> (true, StatusCode.OK, "下载文件成功",inputStream);
    }

}