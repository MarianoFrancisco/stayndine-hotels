package com.stayndine.hotels.application.service;

import com.stayndine.hotels.application.port.in.query.ListHotelsQuery;
import com.stayndine.hotels.application.port.out.HotelRepository;
import com.stayndine.hotels.domain.model.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListHotelsService implements ListHotelsQuery {
    private final HotelRepository hotels;

    @Override
    public List<Hotel> handle() {
        return hotels.findAll();
    }
}