package com.stayndine.hotels.infrastructure.out.persistence.jpa.adapter;

import com.stayndine.hotels.application.port.out.RoomTypeRepository;
import com.stayndine.hotels.domain.model.RoomType;
import com.stayndine.hotels.infrastructure.out.persistence.jpa.mapper.JpaMapper;
import com.stayndine.hotels.infrastructure.out.persistence.jpa.spring.RoomTypeJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoomTypeRepositoryAdapter implements RoomTypeRepository {

    private final RoomTypeJpa jpa;
    private final JpaMapper mapper;

    @Override
    public UUID create(RoomType rt) {
        var saved = jpa.save(mapper.toEntity(rt));
        return saved.getId();
    }

    @Override
    public Optional<RoomType> findById(UUID id) {
        return jpa.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<RoomType> findByHotel(UUID hotelId) {
        return jpa.findByHotelId(hotelId).stream().map(mapper::toDomain).collect(Collectors.toList());
    }
}