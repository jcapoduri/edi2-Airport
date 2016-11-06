package org.edi.controllers;

import java.util.List;

import org.edi.business.contract.IReservationManager;
import org.edi.entities.Reservation;
import org.edi.io.contract.ReservationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableAutoConfiguration
@Controller
@RequestMapping(value="/api")
public class ReservationController {
	@Autowired
	protected IReservationManager reservationRepo;
	
	@RequestMapping(value = "/reservation", method=RequestMethod.GET)
    public @ResponseBody List<Reservation> get() {
        try {
			return this.reservationRepo.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	@RequestMapping(value = "/reservation/{reservationId}", method=RequestMethod.GET)
    public @ResponseBody Reservation getById(@PathVariable int reservationId) {
        try {
			return this.reservationRepo.getById(reservationId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	@RequestMapping(value = "/reservation", method=RequestMethod.POST)
    public @ResponseBody void create(@RequestBody Reservation reservation) {
        try {
			this.reservationRepo.save(reservation);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
    }
	
	@RequestMapping(value = "/reservation/{reservationId}", method=RequestMethod.POST)
    public @ResponseBody void update(@PathVariable int reservationId, @RequestBody Reservation reservation) {
        try {
        	reservation.setId(reservationId);
			this.reservationRepo.update(reservation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
    }
	
	@RequestMapping(value = "/reservation/{reservationId}", method=RequestMethod.DELETE)
    public @ResponseBody void erase(@PathVariable int reservationId) {
        try {
			this.reservationRepo.remove(reservationId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
    }
}
