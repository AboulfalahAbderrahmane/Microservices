package com.formationSpring.accounts.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
@Data
@ToString
/*en ajoute EntityListeners pour savoir qui a creer ce enregistrement , avec l'anottation CreatedBy et une class AuditAwareImpl and add
@EnableJpaAuditing(auditorAwareRef = "auditAwareComponent") in AccountsApplication
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity {
    @CreatedDate
    @Column(name = "created_at",updatable = false)
    private LocalDateTime createAt;
    @CreatedBy
    @Column(name = "created_by",updatable = false)
    private String createdBy;
    @LastModifiedDate
    @Column(name = "updated_at",updatable = false)
    private LocalDateTime updatedAt;
    @LastModifiedBy
    @Column(name = "updated_by",updatable = false)
    private String updatedBy;
}
