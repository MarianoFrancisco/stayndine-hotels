package com.stayndine.hotels.application.service;

import com.stayndine.hotels.application.port.in.query.ListRoomTypesByHotelQuery;
import com.stayndine.hotels.application.port.out.RoomTypeRepository;
import com.stayndine.hotels.domain.model.RoomType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ListRoomTypesByHotelService implements ListRoomTypesByHotelQuery {
    private final RoomTypeRepository roomTypes;

    @Override
    public List<RoomType> handle(UUID hotelId) {
        return roomTypes.findByHotel(hotelId);
    }
}