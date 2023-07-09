package com.br.findly.modules.service_provider.infra.dto.requests;

import com.br.findly.modules.service_provider.domain.entities.Service;
import com.br.findly.shared.ports.FileUploader;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Getter
public class CreateServiceRequest {

    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Description is required")
    @Min(value = 20, message = "Description must have at least 20 characters")
    private String description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private BigDecimal price;

    @NotNull(message = "Thumbnail is required")
    private MultipartFile thumbnail;


    public CreateServiceRequest(String title, String description, BigDecimal price, MultipartFile thumbnail) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    public Service toEntity(FileUploader uploader) {
        var thumbnailUrl = uploader.upload(thumbnail.getOriginalFilename(), thumbnail);
        return new Service(title, description, price, thumbnailUrl);
    }
}
