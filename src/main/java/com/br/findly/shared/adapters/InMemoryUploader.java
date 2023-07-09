package com.br.findly.shared.adapters;

import com.br.findly.shared.ports.FileUploader;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUploader implements FileUploader {
    private static final List<MultipartFile> files = new ArrayList<>();

    @Override
    public String upload(String fileName, MultipartFile file) {
        files.add(file);
        return fileName;
    }
}
