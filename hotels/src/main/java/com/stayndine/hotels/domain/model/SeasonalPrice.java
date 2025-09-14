package com.stayndine.hotels.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record SeasonalPrice(
        UUID id,
        UUID roomTypeId,
        LocalDate startDate,
        LocalDate endDate,
        BigDecimal price
) {
}
