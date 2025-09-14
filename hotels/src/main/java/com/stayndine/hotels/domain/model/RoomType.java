package com.stayndine.hotels.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public record RoomType(
        UUID id,
        UUID hotelId,
        String code,
        String name,
        Integer capacityAdults,
        Integer capacityChildren,
        Integer totalUnits,
        BigDecimal basePrice
) {
}