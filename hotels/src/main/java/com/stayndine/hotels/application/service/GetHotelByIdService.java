package com.stayndine.hotels.application.service;

import com.stayndine.hotels.application.port.in.query.GetHotelByIdQuery;
import com.stayndine.hotels.application.port.out.HotelRepository;
import com.stayndine.hotels.domain.model.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetHotelByIdService implements GetHotelByIdQuery {
    private final HotelRepository hotels;

    @Override
    public Hotel handle(UUID id) {
        return hotels.findById(id).orElseThrow(() -> new IllegalArgumentException("Hotel not found"));
    }
}