package com.driver.Repository;

import com.driver.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class BookingRepository {

    HotelRepository hotelRepository = new HotelRepository();
    private HashMap<String, Booking> bookingDatabase = new HashMap<>();

    public void bookARoom(Booking booking){

        UUID uuid = UUID.randomUUID();
        String bookID = uuid.toString();

        booking.setBookingId(bookID);

        bookingDatabase.put(bookID, booking);

        int totalAmount = 0;
        int numberOfRoomsBooked = booking.getNoOfRooms();
        String bookedHotelName = booking.getHotelName();
        int hotelPricePerNight = hotelRepository.getPricePerNight(bookedHotelName);
        totalAmount = numberOfRoomsBooked * hotelPricePerNight;
        booking.setAmountToBePaid(totalAmount);

    }

    public int getBookings(int aadharCard){

        int count = 0;
        for(String booking : bookingDatabase.keySet()){
            Booking obj = bookingDatabase.get(booking);
            if( obj != null && obj.getBookingAadharCard() == aadharCard){
                count++;
            }
        }
        return count;
    }



}
