package com.stayndine.hotels.infrastructure.out.persistence.jpa.mapper;

import com.stayndine.hotels.domain.model.*;
import com.stayndine.hotels.infrastructure.out.persistence.jpa.entity.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface JpaMapper {
    Hotel toDomain(HotelEntity e);

    HotelEntity toEntity(Hotel d);

    RoomType toDomain(RoomTypeEntity e);

    RoomTypeEntity toEntity(RoomType d);
}