package com.stayndine.hotels.infrastructure.in.rest.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.UUID;

public record RoomTypeCreateRequest(
        @NotNull UUID hotelId,
        @NotBlank String code,
        @NotBlank String name,
        @Min(1) Integer capacityAdults,
        @Min(0) Integer capacityChildren,
        @Min(1) Integer totalUnits,
        @DecimalMin("0.00") BigDecimal basePrice
) {
}