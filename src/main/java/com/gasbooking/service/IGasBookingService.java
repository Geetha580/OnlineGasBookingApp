package com.gasbooking.service;

import java.util.List;

import com.gasbooking.dto.BookingDto;
import com.gasbooking.entity.GasBooking;
import com.gasbooking.exception.GasBookingNotFoundException;

public interface IGasBookingService {

	GasBooking insertGasBooking(BookingDto gasBooking);

	GasBooking updateGasBooking(int gasBookingId, BookingDto gasBooking) throws GasBookingNotFoundException;

	GasBooking deleteGasBooking(int gasBookingId) throws GasBookingNotFoundException;

	GasBooking getBill(int customerId) throws GasBookingNotFoundException;
	
	List<GasBooking> getAllGasBookings() throws GasBookingNotFoundException;
	public GasBooking viewGasBookingById(int gasBookingId) throws GasBookingNotFoundException,NumberFormatException;
}
