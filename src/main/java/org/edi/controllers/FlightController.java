package org.edi.controllers;

import java.util.List;

import org.edi.business.contract.IFlightManager;
import org.edi.controllers.exceptions.AirportBasicException;
import org.edi.entities.Flight;
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
public class FlightController {
	@Autowired
	protected IFlightManager flightRepo;
	
	@RequestMapping(value = "/flight", method=RequestMethod.GET)
    public @ResponseBody List<Flight> get() {
        try {
			return this.flightRepo.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AirportBasicException(e.getMessage());
		}
    }
	
	@RequestMapping(value = "/flight/{flightId}", method=RequestMethod.GET)
    public @ResponseBody Flight getById(@PathVariable int flightId) {
        try {
			return this.flightRepo.getById(flightId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	@RequestMapping(value = "/flight", method=RequestMethod.POST)
    public @ResponseBody void create(@RequestBody Flight flight) {
        try {
			this.flightRepo.save(flight);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			throw new AirportBasicException(e.getMessage());
		}
    }
	
	@RequestMapping(value = "/flight/{flightId}", method=RequestMethod.POST)
    public @ResponseBody void update(@PathVariable int flightId, @RequestBody Flight flight) {
        try {
        	flight.setId(flightId);
			this.flightRepo.update(flight);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			throw new AirportBasicException(e.getMessage());
		}
    }
	
	@RequestMapping(value = "/flight/{flightId}", method=RequestMethod.DELETE)
    public @ResponseBody void erase(@PathVariable int flightId) {
        try {
			this.flightRepo.remove(flightId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AirportBasicException(e.getMessage());
		}
    }
}
