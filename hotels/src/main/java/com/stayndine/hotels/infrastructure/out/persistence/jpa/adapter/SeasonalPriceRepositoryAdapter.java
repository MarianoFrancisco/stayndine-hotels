package com.stayndine.hotels.infrastructure.out.persistence.jpa.adapter;

import com.stayndine.hotels.application.port.out.SeasonalPriceRepository;
import com.stayndine.hotels.domain.model.SeasonalPrice;
import com.stayndine.hotels.infrastructure.out.persistence.jpa.entity.SeasonalPriceEntity;
import com.stayndine.hotels.infrastructure.out.persistence.jpa.spring.SeasonalPriceJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SeasonalPriceRepositoryAdapter implements SeasonalPriceRepository {

    private final SeasonalPriceJpa jpa;

    @Override
    public Optional<SeasonalPrice> findForDate(UUID roomTypeId, LocalDate date) {
        return jpa.findFirstByRoomTypeIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(roomTypeId, date, date)
                .map(this::toDomain);
    }

    private SeasonalPrice toDomain(SeasonalPriceEntity e) {
        return new SeasonalPrice(e.getId(), e.getRoomTypeId(), e.getStartDate(), e.getEndDate(), e.getPrice());
    }
}