package com.stayndine.hotels.application.port.out;

import com.stayndine.hotels.domain.model.SeasonalPrice;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface SeasonalPriceRepository {
    Optional<SeasonalPrice> findForDate(UUID roomTypeId, LocalDate date);
}