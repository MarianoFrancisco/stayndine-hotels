package com.stayndine.hotels.application.service;

import com.stayndine.hotels.application.port.in.command.CreateHotelUseCase;
import com.stayndine.hotels.application.port.out.HotelRepository;
import com.stayndine.hotels.domain.model.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateHotelService implements CreateHotelUseCase {
    private final HotelRepository hotels;

    @Override
    public UUID handle(Command cmd) {
        var id = UUID.randomUUID();
        var hotel = new Hotel(id, cmd.code(), cmd.name(), cmd.country(), cmd.city(),
                cmd.addressLine1(), cmd.addressLine2(), cmd.timezone(), cmd.starRating());
        return hotels.create(hotel);
    }
}