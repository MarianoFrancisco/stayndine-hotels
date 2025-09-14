package com.stayndine.hotels.infrastructure.in.rest.controller;

import com.stayndine.hotels.application.port.in.command.CreateRoomTypeUseCase;
import com.stayndine.hotels.application.port.in.query.ListRoomTypesByHotelQuery;
import com.stayndine.hotels.application.port.in.query.QuoteRoomTypePriceQuery;
import com.stayndine.hotels.infrastructure.in.rest.dto.*;
import com.stayndine.hotels.infrastructure.in.rest.mapper.HttpMapper;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/room-types")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer-jwt")
public class RoomTypeController {

    private final CreateRoomTypeUseCase createRt;
    private final ListRoomTypesByHotelQuery listByHotel;
    private final QuoteRoomTypePriceQuery quote;
    private final HttpMapper mapper;

    @PostMapping
    @PreAuthorize("hasAnyRole('MANAGER','EMPLOYEE')")
    public ResponseEntity<UUID> create(@Valid @RequestBody RoomTypeCreateRequest req) {
        var id = createRt.handle(new CreateRoomTypeUseCase.Command(
                req.hotelId(), req.code(), req.name(), req.capacityAdults(),
                req.capacityChildren(), req.totalUnits(), req.basePrice()
        ));
        return ResponseEntity.ok(id);
    }

    @GetMapping("/by-hotel/{hotelId}")
    public ResponseEntity<?> byHotel(@PathVariable UUID hotelId) {
        return ResponseEntity.ok(listByHotel.handle(hotelId).stream().map(mapper::toResponse).toList());
    }

    @GetMapping("/{roomTypeId}/quote")
    public ResponseEntity<QuoteResponse> quote(
            @PathVariable UUID roomTypeId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut
    ) {
        var res = quote.handle(roomTypeId, checkIn, checkOut);
        return ResponseEntity.ok(new QuoteResponse(res.nightlyPrice()));
    }
}