package com.stayndine.hotels.application.port.out;

import com.stayndine.hotels.domain.model.Hotel;

import java.util.*;

public interface HotelRepository {
    UUID create(Hotel h);

    Optional<Hotel> findById(UUID id);

    List<Hotel> findAll();
}