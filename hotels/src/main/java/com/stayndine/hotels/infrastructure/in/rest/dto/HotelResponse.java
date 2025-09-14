package com.stayndine.hotels.infrastructure.in.rest.dto;

import java.util.UUID;

public record HotelResponse(
        UUID id, String code, String name, String country, String city,
        String addressLine1, String addressLine2, String timezone, Integer starRating
) {
}