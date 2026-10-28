package com.universidad.tests.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "test_type")
public class TestTypeJpaEntity {
    @Id
    private UUID id;

    @Column(nullable = false, unique = true, length = 40)
    private String code;

    @Column(nullable = false, length = 160)
    private String name;

    @Column(name = "display_order", nullable = false, unique = true)
    private int displayOrder;

    @Column(nullable = false)
    private boolean enabled;

    protected TestTypeJpaEntity() {
    }

    public UUID getId() { return id; }
    public String getCode() { return code; }
    public String getName() { return name; }
    public int getDisplayOrder() { return displayOrder; }
    public boolean isEnabled() { return enabled; }
}
