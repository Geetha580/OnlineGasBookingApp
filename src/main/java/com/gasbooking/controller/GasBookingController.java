package com.gasbooking.controller;
import java.util.InputMismatchException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gasbooking.dto.BookingDto;
import com.gasbooking.entity.Customer;
import com.gasbooking.entity.GasBooking;
import com.gasbooking.exception.CustomerNotFoundException;
import com.gasbooking.exception.GasBookingNotFoundException;
import com.gasbooking.service.IGasBookingService;
@RestController
@CrossOrigin
@RequestMapping(path="/gasbooking")
public class GasBookingController {

	
		@Autowired
		private IGasBookingService iGasBookingService;
		@PostMapping("/insertGasBooking")
		public ResponseEntity<GasBooking> insertGasBooking(@RequestBody BookingDto gasBooking){
			GasBooking g=iGasBookingService.insertGasBooking(gasBooking);
			ResponseEntity<GasBooking> re=new ResponseEntity<GasBooking>(g,HttpStatus.CREATED);
			return re;
		}
		@PutMapping("/updatebooking/{gasBookingId}")
		public ResponseEntity<?> updateGasBooking(@PathVariable int gasBookingId, @Valid @RequestBody BookingDto gasBooking) throws GasBookingNotFoundException{
			GasBooking g1=iGasBookingService.updateGasBooking(gasBookingId,gasBooking);
			ResponseEntity<GasBooking> re=new ResponseEntity<GasBooking>(g1,HttpStatus.OK);
			return re;
		}
		@DeleteMapping("/deletebooking/{gasBookingId}")
		public ResponseEntity<GasBooking> deleteGasBooking(@PathVariable int gasBookingId) throws GasBookingNotFoundException{
			GasBooking g1=iGasBookingService.deleteGasBooking(gasBookingId);
			ResponseEntity<GasBooking> re=new ResponseEntity<GasBooking>(g1,HttpStatus.OK);
			return re;
			
		}
		@GetMapping("/getbill/{customerId}")
		public ResponseEntity<GasBooking> getBill(@PathVariable int customerId) throws GasBookingNotFoundException{
			GasBooking g=iGasBookingService.getBill(customerId);
			ResponseEntity<GasBooking> re=new ResponseEntity<GasBooking>(g,HttpStatus.OK);
			return re;
			
		}
		
		@GetMapping("/getAllGasBookings")
		public ResponseEntity<?> getAllGasBookings() throws GasBookingNotFoundException {
			List<GasBooking> getAllGasBookings = iGasBookingService.getAllGasBookings();
			return new ResponseEntity<List<GasBooking>>(getAllGasBookings, HttpStatus.OK);
		}
		@GetMapping("/getGasBookingById/{gasBookingId}")
		public ResponseEntity<?> viewGasBookingById(@PathVariable int gasBookingId) throws GasBookingNotFoundException,NumberFormatException {
			GasBooking getSingleGasBooking= iGasBookingService.viewGasBookingById(gasBookingId);
			return new ResponseEntity<GasBooking>(getSingleGasBooking, HttpStatus.OK);
		}
	

}
