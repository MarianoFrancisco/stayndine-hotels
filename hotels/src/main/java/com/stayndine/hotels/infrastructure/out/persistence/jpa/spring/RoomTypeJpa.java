package com.stayndine.hotels.infrastructure.out.persistence.jpa.spring;

import com.stayndine.hotels.infrastructure.out.persistence.jpa.entity.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RoomTypeJpa extends JpaRepository<RoomTypeEntity, UUID> {
    List<RoomTypeEntity> findByHotelId(UUID hotelId);
}