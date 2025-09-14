package com.stayndine.hotels.infrastructure.in.rest.controller;

import com.stayndine.hotels.application.port.in.command.CreateHotelUseCase;
import com.stayndine.hotels.application.port.in.query.GetHotelByIdQuery;
import com.stayndine.hotels.application.port.in.query.ListHotelsQuery;
import com.stayndine.hotels.infrastructure.in.rest.dto.HotelCreateRequest;
import com.stayndine.hotels.infrastructure.in.rest.dto.HotelResponse;
import com.stayndine.hotels.infrastructure.in.rest.mapper.HttpMapper;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/hotels")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer-jwt")
public class HotelController {

    private final CreateHotelUseCase createHotel;
    private final GetHotelByIdQuery getHotel;
    private final ListHotelsQuery listHotels;
    private final HttpMapper mapper;

    @PostMapping
    @PreAuthorize("hasAnyRole('MANAGER','EMPLOYEE')")
    public ResponseEntity<UUID> create(@Valid @RequestBody HotelCreateRequest req) {
        var id = createHotel.handle(new CreateHotelUseCase.Command(
                req.code(), req.name(), req.country(), req.city(), req.addressLine1(),
                req.addressLine2(), req.timezone(), req.starRating()
        ));
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponse> byId(@PathVariable UUID id) {
        return ResponseEntity.ok(mapper.toResponse(getHotel.handle(id)));
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(listHotels.handle().stream().map(mapper::toResponse).toList());
    }
}