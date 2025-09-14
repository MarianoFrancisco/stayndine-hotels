package com.stayndine.hotels.infrastructure.out.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "hotel")
@Getter
@Setter
public class HotelEntity {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(nullable = false, unique = true, length = 40)
    private String code;
    @Column(nullable = false, length = 180)
    private String name;
    @Column(nullable = false, length = 60)
    private String country;
    @Column(nullable = false, length = 80)
    private String city;
    @Column(name = "address_line1", nullable = false, length = 160)
    private String addressLine1;
    @Column(name = "address_line2", length = 160)
    private String addressLine2;
    @Column(nullable = false, length = 60)
    private String timezone;
    @Column(name = "star_rating")
    private Integer starRating;
    @Column(name = "created_at", updatable = false, insertable = false)
    private Instant createdAt;
    @Column(name = "updated_at", updatable = false, insertable = false)
    private Instant updatedAt;
}