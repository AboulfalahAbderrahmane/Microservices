package com.formationSpring.accounts.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDateTime;
@Data
@ToString
@MappedSuperclass
public class BaseEntity {
    @Column(name = "created_at",updatable = false)
    private LocalDateTime createAt;
    @Column(name = "created_by",updatable = false)
    private String createdBy;
    @Column(name = "updated_at",updatable = false)
    private LocalDateTime updatedAt;
    @Column(name = "updated_by",updatable = false)
    private String updatedBy;
}
