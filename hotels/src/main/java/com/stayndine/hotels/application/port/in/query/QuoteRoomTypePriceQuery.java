package com.stayndine.hotels.application.port.in.query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public interface QuoteRoomTypePriceQuery {
    record Result(BigDecimal nightlyPrice) {
    }

    Result handle(UUID roomTypeId, LocalDate checkIn, LocalDate checkOut);
}