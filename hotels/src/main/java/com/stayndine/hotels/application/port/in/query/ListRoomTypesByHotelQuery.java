package com.stayndine.hotels.application.port.in.query;

import com.stayndine.hotels.domain.model.RoomType;

import java.util.List;
import java.util.UUID;

public interface ListRoomTypesByHotelQuery {
    List<RoomType> handle(UUID hotelId);
}