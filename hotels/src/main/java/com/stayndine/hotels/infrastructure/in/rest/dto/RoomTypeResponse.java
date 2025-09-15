package com.stayndine.hotels.infrastructure.in.rest.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record RoomTypeResponse(
        UUID id, UUID hotelId, String code, String name,
        Integer capacityAdults, Integer capacityChildren, Integer totalUnits,
        BigDecimal basePrice
) {}