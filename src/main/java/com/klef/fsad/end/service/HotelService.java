package com.klef.fsad.end.service;


import com.klef.fsad.end.entity.Hotel;
import com.klef.fsad.end.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository repository;

    public Hotel saveHotel(Hotel hotel) {
        return repository.save(hotel);
    }

    public Hotel updateHotel(Long id, Hotel hotelDetails) {
        Optional<Hotel> optionalHotel = repository.findById(id);

        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();
            hotel.setName(hotelDetails.getName());
            hotel.setDate(hotelDetails.getDate());
            hotel.setStatus(hotelDetails.getStatus());
            return repository.save(hotel);
        } else {
            throw new RuntimeException("Hotel not found with id " + id);
        }
    }
}