package com.br.findly.modules.service_provider.domain.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String description;
    private BigDecimal price;
    private String thumbnail;

    @ManyToOne
    private ServiceProvider serviceProvider;

    @Deprecated
    /**
     * @deprecated hibernate only **do not use**
     */
    public Service() {
        // hibernate only - do not use !!!
    }

    public Service(String title, String description, BigDecimal price, String thumbnail) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.thumbnail = thumbnail;
    }
}
