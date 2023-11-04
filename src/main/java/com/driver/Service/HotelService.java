package com.driver.Service;

import com.driver.Repository.HotelRepository;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    HotelRepository hotelRepository = new HotelRepository();

    public String addHotel(Hotel hotel){
        if(hotel == null){
            return "FAILURE";
        }
        if(hotel.getHotelName() == null){
            return "FAILURE";
        }

        String str = hotelRepository.addHotel(hotel);
        return str;

    }

    public String getHotelWithMostFacilities(){
        return hotelRepository.getHotelWithMostFacilities();
    }

    public Hotel updateFacilities(List<Facility> newFacilities, String hotelName){
        return hotelRepository.updateFacilities(newFacilities, hotelName);
    }



}
