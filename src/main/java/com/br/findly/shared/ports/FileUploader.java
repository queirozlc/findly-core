package com.br.findly.shared.ports;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploader {

    String upload(String fileName, MultipartFile file);
}
