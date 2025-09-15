package com.stayndine.hotels.application.port.in.query;

import com.stayndine.hotels.domain.model.Hotel;

import java.util.List;

public interface ListHotelsQuery {
    List<Hotel> handle();
}