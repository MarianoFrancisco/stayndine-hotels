package com.stayndine.hotels.application.service;

import com.stayndine.hotels.application.port.in.query.QuoteRoomTypePriceQuery;
import com.stayndine.hotels.application.port.out.RoomTypeRepository;
import com.stayndine.hotels.application.port.out.SeasonalPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QuoteRoomTypePriceService implements QuoteRoomTypePriceQuery {

    private final RoomTypeRepository roomTypes;
    private final SeasonalPriceRepository seasonalPrices;

    @Override
    public Result handle(UUID roomTypeId, LocalDate checkIn, LocalDate checkOut) {
        var rt = roomTypes.findById(roomTypeId)
                .orElseThrow(() -> new IllegalArgumentException("Room type not found"));

        var seasonal = seasonalPrices.findForDate(roomTypeId, checkIn);
        BigDecimal nightly = seasonal.map(s -> s.price()).orElse(rt.basePrice());
        return new Result(nightly);
    }
}