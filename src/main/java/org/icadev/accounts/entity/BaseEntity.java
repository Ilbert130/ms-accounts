package org.icadev.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@MappedSuperclass //It will act as a base class for all the entities
public class BaseEntity {

    @Column(updatable = false)
    private LocalDate createdAt;

    @Column(updatable = false)
    private String createdBy;

    @Column(insertable = false)
    private LocalDate updatedAt;

    @Column(insertable = false)
    private String updatedBy;
}
