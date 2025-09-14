package com.stayndine.hotels.application.port.in.query;

import com.stayndine.hotels.domain.model.Hotel;

import java.util.UUID;

public interface GetHotelByIdQuery {
    Hotel handle(UUID id);
}