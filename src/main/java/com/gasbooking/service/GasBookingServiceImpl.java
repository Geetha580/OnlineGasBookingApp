package com.gasbooking.service;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasbooking.dto.BookingDto;
import com.gasbooking.entity.Customer;
import com.gasbooking.entity.GasBooking;
import com.gasbooking.exception.GasBookingNotFoundException;
import com.gasbooking.repository.ICustomerRepository;
import com.gasbooking.repository.IGasBookingRepository;

@Service
public class GasBookingServiceImpl implements IGasBookingService{
	@Autowired
	IGasBookingRepository gasBookingRepo;
	@Autowired
	ICustomerRepository customerRepo;
	private Logger logger=LoggerFactory.getLogger (GasBookingServiceImpl.class);
	@Override
	public GasBooking insertGasBooking(BookingDto gasBooking) {
		
		Customer customer = customerRepo.findById(gasBooking.getCustomerId()).get();
		logger.info(""+customer);
		GasBooking gasBooking1=new GasBooking();
		gasBooking1.setCustomer(customer);
		gasBooking1.setBill(950.0);
		gasBooking1.setStatus("booked");
		gasBooking1.setLocalDate(LocalDate.now());
		logger.info("********Inserting GasBooking Details*********");
		return gasBookingRepo.save(gasBooking1);
	}

	@Override
	public GasBooking updateGasBooking(int gasBookingId, BookingDto gasBooking) throws GasBookingNotFoundException {
		
		logger.info("********Updating GasBooking Details*********");
		Customer customer = customerRepo.findById(gasBooking.getCustomerId()).get();
		GasBooking gasBooking1=new GasBooking();
		Optional<GasBooking> optional = gasBookingRepo.findById(gasBookingId);
		if(optional.isPresent()) {
			GasBooking g1=optional.get();
			g1.setCustomer(customer);
			g1.setLocalDate(LocalDate.now());
			//g1.setStatus(gasBooking.getStatus());
			g1.setBill(gasBooking.getBill());
			GasBooking updatedGasBooking=gasBookingRepo.save(g1);
			return updatedGasBooking;
		}
		else {
			throw new GasBookingNotFoundException("Gas Booking details not found");
		}
	}

	@Override
	public GasBooking deleteGasBooking(int gasBookingId) throws GasBookingNotFoundException {
		logger.info("********Deleting GasBooking Details*********");
		Integer id=Integer.valueOf(gasBookingId);
		if(id instanceof Integer)
		{
			Optional<GasBooking> optional=gasBookingRepo.findById(gasBookingId);
			if(optional.isPresent()) {
				GasBooking deletedgasBooking=optional.get();
				gasBookingRepo.deleteById(gasBookingId);
				return deletedgasBooking;
			}
			else {
				throw new GasBookingNotFoundException("Gas Booking details not found");
			}
		}
		else {
			throw new InputMismatchException("The given id should be integer type");
		}
			
	}

	@Override
	public GasBooking getBill(int customerId) throws GasBookingNotFoundException {
		
		logger.info("********Get GasBooking Bill Details by CustomerId*********");
		Customer optional = gasBookingRepo.findBycustomerId(customerId);
		List<GasBooking> list =  optional.getGasBooking();
		
		GasBooking gotDetails = null;
		
		for(int i=0; i<list.size(); i++) {
			gotDetails = list.get(i);
		}
		
		return gotDetails;
	}

	@Override
	public List<GasBooking> getAllGasBookings() throws GasBookingNotFoundException {
		logger.info("*********Get All GasBookings*********");
		List<GasBooking> list = gasBookingRepo.findAll();
		if (list.isEmpty()) {
			throw new GasBookingNotFoundException("There are no such gasbookings present in the database.");
		}
		return list;
	}

	@Override
	public GasBooking viewGasBookingById(int gasBookingId) throws GasBookingNotFoundException,NumberFormatException {
		logger.info("********View gasbooking Details By gasbooking ID *********");
		Integer getId = Integer.valueOf(gasBookingId);

		if (getId instanceof Integer) {
			Optional<GasBooking> optional =gasBookingRepo.findById(gasBookingId);

			if (optional.isPresent()) {
				GasBooking gotGasBooking = optional.get();
				return gotGasBooking;
			} else {
				throw new GasBookingNotFoundException("There are no such gasbooking is present in the database.");
			}
		} else {
			throw new NumberFormatException("ID should be a number type.");
		}
		
	}
}
