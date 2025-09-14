package com.stayndine.hotels.infrastructure.out.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "seasonal_price")
@Getter
@Setter
public class SeasonalPriceEntity {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(name = "room_type_id", columnDefinition = "BINARY(16)", nullable = false)
    private UUID roomTypeId;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
}