package com.klef.fsad.end.controller;


import com.klef.fsad.end.entity.Hotel;
import com.klef.fsad.end.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService service;

    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return service.saveHotel(hotel);
    }

    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        return service.updateHotel(id, hotel);
    }
}