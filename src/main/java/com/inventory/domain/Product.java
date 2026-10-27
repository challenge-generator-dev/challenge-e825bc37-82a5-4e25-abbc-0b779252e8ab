package com.inventory.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 50)
    @NotBlank(message = "El código del producto no puede estar vacío")
    @Size(max = 50, message = "El código del producto no puede exceder 50 caracteres")
    private String code;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "El nombre del producto no puede estar vacío")
    @Size(max = 100, message = "El nombre del producto no puede exceder 100 caracteres")
    private String name;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(max = 255, message = "La descripción no puede exceder 255 caracteres")
    private String description;

    @Column(nullable = false)
    @NotNull(message = "El precio no puede ser nulo")
    @Positive(message = "El precio debe ser positivo")
    private BigDecimal price;

    @Column(nullable = false)
    @NotNull(message = "La cantidad en stock no puede ser nula")
    @PositiveOrZero(message = "La cantidad en stock no puede ser negativa")
    private Integer stock;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "La categoría no puede estar vacía")
    @Size(max = 50, message = "La categoría no puede exceder 50 caracteres")
    private String category;

    @Column(name = "created_at", nullable = false, updatable = false)
    @NotNull(message = "La fecha de creación no puede ser nula")
    private LocalDate createdAt;

    @Column(name = "updated_at", nullable = false)
    @NotNull(message = "La fecha de actualización no puede ser nula")
    private LocalDate updatedAt;

    @Version
    private Integer version;

    public Product() {
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    public Product(String code, String name, String description, BigDecimal price, Integer stock, String category) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    // Getters y setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDate.now();
    }
}