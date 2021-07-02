package com.inet.code.service.Impl;

import com.inet.code.entity.deleteFile;
import com.inet.code.service.deleteFileService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName deleteFileServiceImpl
 * @Description
 * @Author drh
 * @Data 8:44 上午
 * @Version 1.0
 **/
@Service
public class deleteFileServiceImpl implements deleteFileService {

//    private static   List<String> list=new ArrayList();

    public List<String> showFile(String directoryPath, List<String> list) {
        File file=new File(directoryPath);
        File[] files = file.listFiles();
        for (File file1:files){
            if (file1.isDirectory()){
                showFile(String.valueOf(file1),list);
            }
            if (file1.isFile() && (new Date().getTime()-file1.lastModified())/1000/60/24>30){
                list.add(String.valueOf(file1));
            }
        }
        System.out.println(list);
        return list;
    }

    //    @Override
//    public List<String> showFile(String directoryPath) {
//        list.clear();
//        return showFile1(directoryPath);
//    }
//
//    public List<String> showFile1(String directoryPath){
//        File file = new File(directoryPath);
//        File[] files = file.listFiles();
//        for (File file1:files){
//            if (file1.isDirectory()){
//                System.out.println("folderName------"+file1);
//                showFile1(String.valueOf(file1));
//            }
//            if(file1.isFile() && (new Date().getTime()- file1.lastModified())/1000/60/60/24>0) {
//                list.add(String.valueOf(file1));
//            }
//        }
//        System.out.println(list);
//        return list;
//    }
    @Override
    public void deleteFile(List<String> list) {
        for (int i=0;i<list.size();i++){
            File file=new File(list.get(i));
            file.delete();
        }
    }


}
