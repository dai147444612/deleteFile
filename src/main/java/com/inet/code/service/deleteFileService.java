package com.inet.code.service;

import com.inet.code.entity.deleteFile;

import java.io.Serializable;
import java.util.List;

public interface deleteFileService {
    List<String> showFile(String directoryPath,List<String> list);

    void deleteFile(List<String> list);

}
