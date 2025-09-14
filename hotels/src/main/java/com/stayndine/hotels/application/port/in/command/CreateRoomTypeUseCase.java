package com.stayndine.hotels.application.port.in.command;

import java.math.BigDecimal;
import java.util.UUID;

public interface CreateRoomTypeUseCase {
    record Command(
            UUID hotelId,
            String code,
            String name,
            Integer capacityAdults,
            Integer capacityChildren,
            Integer totalUnits,
            BigDecimal basePrice
    ) {
    }

    UUID handle(Command cmd);
}