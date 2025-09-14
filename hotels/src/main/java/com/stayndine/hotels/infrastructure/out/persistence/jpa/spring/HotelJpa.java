package com.stayndine.hotels.infrastructure.out.persistence.jpa.spring;

import com.stayndine.hotels.infrastructure.out.persistence.jpa.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface HotelJpa extends JpaRepository<HotelEntity, UUID> {
    Optional<HotelEntity> findByCode(String code);
}