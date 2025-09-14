package com.stayndine.hotels.domain.model;

import java.util.UUID;

public record Hotel(
        UUID id,
        String code,
        String name,
        String country,
        String city,
        String addressLine1,
        String addressLine2,
        String timezone,
        Integer starRating
) {
}