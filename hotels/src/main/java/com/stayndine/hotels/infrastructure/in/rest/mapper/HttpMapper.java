package com.stayndine.hotels.infrastructure.in.rest.mapper;

import com.stayndine.hotels.domain.model.Hotel;
import com.stayndine.hotels.domain.model.RoomType;
import com.stayndine.hotels.infrastructure.in.rest.dto.HotelResponse;
import com.stayndine.hotels.infrastructure.in.rest.dto.RoomTypeResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HttpMapper {
    HotelResponse toResponse(Hotel h);

    RoomTypeResponse toResponse(RoomType rt);
}