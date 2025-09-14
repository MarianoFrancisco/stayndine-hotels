package com.stayndine.hotels.application.port.in.command;

import java.util.UUID;

public interface CreateHotelUseCase {
    record Command(String code, String name, String country, String city, String addressLine1, String addressLine2,
                   String timezone, Integer starRating) {
    }

    UUID handle(Command cmd);
}