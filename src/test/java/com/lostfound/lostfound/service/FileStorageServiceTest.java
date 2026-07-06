package com.lostfound.lostfound.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.mock.web.MockMultipartFile;

class FileStorageServiceTest {

    @TempDir
    Path tempDir;

    @Test
    void shouldStoreFileAndReturnPublicUrl() throws Exception {
        FileStorageService service = new FileStorageService(tempDir.toString(), "/uploads");

        MockMultipartFile file = new MockMultipartFile(
                "files",
                "photo.png",
                "image/png",
                "image-bytes".getBytes(StandardCharsets.UTF_8)
        );

        String url = service.storeFile(file);

        assertThat(url).startsWith("/uploads/");
        assertThat(Files.exists(tempDir.resolve(url.substring(url.lastIndexOf('/') + 1)))).isTrue();
    }
}
