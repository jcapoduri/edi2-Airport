package org.edi.controllers;

import java.util.List;

import org.edi.business.contract.IPassengerManager;
import org.edi.entities.Passenger;
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
public class PassengerController {
	@Autowired
	protected IPassengerManager passengerRepo;
	
	@RequestMapping(value = "/passenger", method=RequestMethod.GET)
    public @ResponseBody List<Passenger> get() {
        try {
			return this.passengerRepo.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	@RequestMapping(value = "/passenger/{passengerId}", method=RequestMethod.GET)
    public @ResponseBody Passenger getById(@PathVariable int passengerId) {
        try {
			return this.passengerRepo.getById(passengerId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	@RequestMapping(value = "/passenger", method=RequestMethod.POST)
    public @ResponseBody void create(@RequestBody Passenger passenger) {
        try {
			this.passengerRepo.save(passenger);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
    }
	
	@RequestMapping(value = "/passenger/{passengerId}", method=RequestMethod.POST)
    public @ResponseBody void update(@PathVariable int passengerId, @RequestBody Passenger passenger) {
        try {
        	passenger.setId(passengerId);
			this.passengerRepo.update(passenger);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
    }
	
	@RequestMapping(value = "/passenger/{passengerId}", method=RequestMethod.DELETE)
    public @ResponseBody void erase(@PathVariable int passengerId) {
        try {
			this.passengerRepo.remove(passengerId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
    }
}
