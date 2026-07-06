package com.lostfound.lostfound.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

    private final Path uploadRoot;
    private final String publicBaseUrl;

    public FileStorageService(
            @Value("${app.upload.dir:${user.dir}/uploads}") String uploadDir,
            @Value("${app.upload.base-url:/uploads}") String publicBaseUrl) throws IOException {
        this.uploadRoot = Paths.get(uploadDir).toAbsolutePath().normalize();
        Files.createDirectories(this.uploadRoot);
        this.publicBaseUrl = publicBaseUrl.endsWith("/") ? publicBaseUrl : publicBaseUrl + "/";
    }

    public List<String> storeFiles(List<MultipartFile> files) throws IOException {
        if (files == null || files.isEmpty()) {
            throw new IllegalArgumentException("At least one photo file is required");
        }

        List<String> urls = new ArrayList<>();
        for (MultipartFile file : files) {
            if (file == null || file.isEmpty()) {
                continue;
            }
            urls.add(storeFile(file));
        }

        if (urls.isEmpty()) {
            throw new IllegalArgumentException("At least one photo file is required");
        }

        return urls;
    }

    public String storeFile(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        String originalName = file.getOriginalFilename();
        String extension = "";
        if (originalName != null && originalName.contains(".")) {
            extension = originalName.substring(originalName.lastIndexOf('.'));
        }

        String fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))
                + "-"
                + UUID.randomUUID().toString().substring(0, 8)
                + extension;

        Path target = uploadRoot.resolve(fileName).normalize();
        if (!target.startsWith(uploadRoot)) {
            throw new IOException("Invalid file path");
        }

        Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
        return publicBaseUrl + fileName;
    }
}
