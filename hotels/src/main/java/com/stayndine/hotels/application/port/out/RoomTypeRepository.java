package com.stayndine.hotels.application.port.out;

import com.stayndine.hotels.domain.model.RoomType;

import java.util.*;

public interface RoomTypeRepository {
    UUID create(RoomType rt);

    Optional<RoomType> findById(UUID id);

    List<RoomType> findByHotel(UUID hotelId);
}