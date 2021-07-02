package com.inet.code.controller;

import com.inet.code.entity.deleteFile;
import com.inet.code.service.deleteFileService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName deleteController
 * @Description
 * @Author drh
 * @Data 8:42 上午
 * @Version 1.0
 **/
@CrossOrigin
@RestController
public class deleteController {
    @Resource
    private deleteFileService deleteFileService;
    @GetMapping("/showFile")
    public List<String> showFile(String directoryPath){
        return deleteFileService.showFile(directoryPath,new ArrayList<>());
    }

    @PostMapping("/deleteFile")
    public void deleteFile(@RequestBody deleteFile deleteFile){
        System.out.println(deleteFile);
        deleteFileService.deleteFile(deleteFile.getFileName());
    }

    @PostMapping("/test")
    public void test(@RequestBody List<String> list){
        System.out.println(list);
    }

}

