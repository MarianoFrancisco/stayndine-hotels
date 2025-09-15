package com.stayndine.hotels.infrastructure.out.persistence.jpa.adapter;

import com.stayndine.hotels.application.port.out.HotelRepository;
import com.stayndine.hotels.domain.model.Hotel;
import com.stayndine.hotels.infrastructure.out.persistence.jpa.mapper.JpaMapper;
import com.stayndine.hotels.infrastructure.out.persistence.jpa.spring.HotelJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class HotelRepositoryAdapter implements HotelRepository {
    private final HotelJpa jpa;
    private final JpaMapper mapper;

    @Override
    public UUID create(Hotel h) {
        var saved = jpa.save(mapper.toEntity(h));
        return saved.getId();
    }

    @Override
    public Optional<Hotel> findById(UUID id) {
        return jpa.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Hotel> findAll() {
        return jpa.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }
}