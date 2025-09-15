package com.stayndine.hotels.application.service;

import com.stayndine.hotels.application.port.in.command.CreateRoomTypeUseCase;
import com.stayndine.hotels.application.port.out.RoomTypeRepository;
import com.stayndine.hotels.domain.model.RoomType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateRoomTypeService implements CreateRoomTypeUseCase {

    private final RoomTypeRepository roomTypes;

    @Override
    public UUID handle(Command cmd) {
        var id = UUID.randomUUID();
        var rt = new RoomType(
                id,
                cmd.hotelId(),
                cmd.code(),
                cmd.name(),
                cmd.capacityAdults(),
                cmd.capacityChildren(),
                cmd.totalUnits(),
                cmd.basePrice()
        );
        return roomTypes.create(rt);
    }
}