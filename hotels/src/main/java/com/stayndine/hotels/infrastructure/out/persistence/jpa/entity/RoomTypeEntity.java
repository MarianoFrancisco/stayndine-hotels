package com.stayndine.hotels.infrastructure.out.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "room_type",
        uniqueConstraints = @UniqueConstraint(name = "uk_rt_hotel_code", columnNames = {"hotel_id", "code"}))
@Getter
@Setter
public class RoomTypeEntity {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(name = "hotel_id", columnDefinition = "BINARY(16)", nullable = false)
    private UUID hotelId;
    @Column(nullable = false, length = 40)
    private String code;
    @Column(nullable = false, length = 120)
    private String name;
    @Column(name = "capacity_adults", nullable = false)
    private Integer capacityAdults;
    @Column(name = "capacity_children", nullable = false)
    private Integer capacityChildren;
    @Column(name = "total_units", nullable = false)
    private Integer totalUnits;
    @Column(name = "base_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal basePrice;
    @Column(name = "created_at", updatable = false, insertable = false)
    private Instant createdAt;
    @Column(name = "updated_at", updatable = false, insertable = false)
    private Instant updatedAt;
}