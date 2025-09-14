package com.stayndine.hotels.infrastructure.out.persistence.jpa.spring;

import com.stayndine.hotels.infrastructure.out.persistence.jpa.entity.SeasonalPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface SeasonalPriceJpa extends JpaRepository<SeasonalPriceEntity, UUID> {
    Optional<SeasonalPriceEntity> findFirstByRoomTypeIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            UUID roomTypeId, LocalDate startDate, LocalDate endDate
    );
}