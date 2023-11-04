package com.driver.Service;

import com.driver.Repository.BookingRepository;
import com.driver.Repository.HotelRepository;
import com.driver.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    BookingRepository bookingRepository = new BookingRepository();

    HotelRepository hotelRepository = new HotelRepository();

    public int bookARoom(Booking booking){

        int noOfRoomsToBook = booking.getNoOfRooms();
        String hotelName = booking.getHotelName();
        int availableRoomsInGivenHotel = hotelRepository.getAvailableRooms(hotelName);
        if(noOfRoomsToBook <= availableRoomsInGivenHotel){
            bookingRepository.bookARoom(booking);
            hotelRepository.setAvailableRooms(hotelName, noOfRoomsToBook);
            return booking.getAmountToBePaid();
        }

        return -1;

    }

    public int getBookings(int aadharCard){
        return bookingRepository.getBookings(aadharCard);
    }

}
