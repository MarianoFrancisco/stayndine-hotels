package com.stayndine.hotels.infrastructure.in.rest.dto;

import jakarta.validation.constraints.*;

public record HotelCreateRequest(
        @NotBlank String code,
        @NotBlank String name,
        @NotBlank String country,
        @NotBlank String city,
        @NotBlank String addressLine1,
        String addressLine2,
        @NotBlank String timezone,
        @Min(1) @Max(5) Integer starRating
) {
}