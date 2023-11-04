package com.driver.Repository;

import com.driver.model.Facility;
import com.driver.model.Hotel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class HotelRepository {

    private HashMap<String, Hotel> hotelDatabase = new HashMap<>();

    public String addHotel(Hotel hotel){
        if(hotelDatabase.containsKey(hotel.getHotelName())){
            return "FAILURE";
        }
        hotelDatabase.put(hotel.getHotelName(), hotel);
        return "SUCCESS";
    }

    public String getHotelWithMostFacilities(){
        String hotel_name = "";
        int max = Integer.MIN_VALUE;
        for(String name : hotelDatabase.keySet()){
            Hotel hotel = hotelDatabase.get(name);
            List<Facility> facilityList = hotel.getFacilities();
            int facility = facilityList.size();
            if(max < facility){
                max = facility;
                hotel_name = name;
            }else if(max == facility){
                if(name.compareTo(hotel_name) < 0){
                    hotel_name = name;
                }
            }
        }
        return hotel_name;

    }

    public int getPricePerNight(String bookedHotelName){
        Hotel hotelName =  hotelDatabase.get(bookedHotelName);
        return hotelName.getPricePerNight();
    }

    public int getAvailableRooms(String bookingHotel){
        Hotel hotelName = hotelDatabase.get(bookingHotel);
        return hotelName.getAvailableRooms();
    }

    public void setAvailableRooms(String bookedHotel, int noOfRoomsBooked){
        Hotel hotelName = hotelDatabase.get(bookedHotel);
        int remainingRooms = hotelName.getAvailableRooms() - noOfRoomsBooked;
        hotelName.setAvailableRooms(remainingRooms);
    }

    public Hotel updateFacilities(List<Facility> newFacilities, String hotelName){
        Hotel hotel = hotelDatabase.get(hotelName);
        List<Facility> facilityList = hotel.getFacilities();
        for(Facility facility : newFacilities){
            if(!facilityList.contains(facility)){
                facilityList.add(facility);
            }
        }

        hotel.setFacilities(facilityList);
        return hotel;

    }



}
