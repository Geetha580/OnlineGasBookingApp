package com.gasbooking.service;

import com.gasbooking.entity.GasBooking;
import com.gasbooking.exception.GasBookingNotFoundException;

public interface IGasBookingService {

	GasBooking insertGasBooking(GasBooking gasBooking);

	GasBooking updateGasBooking(int gasBookingId, GasBooking gasBooking) throws GasBookingNotFoundException;

	GasBooking deleteGasBooking(int gasBookingId) throws GasBookingNotFoundException;

	GasBooking getBill(int customerId) throws GasBookingNotFoundException;

}
