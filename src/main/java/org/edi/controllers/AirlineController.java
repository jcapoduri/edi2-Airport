package org.edi.controllers;

import java.util.List;

import org.edi.business.contract.AirlineDAO;
import org.edi.entities.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AirlineController {
	@Autowired
	protected AirlineDAO airlineRepo;
	
	@RequestMapping(value = "/airline", method=RequestMethod.GET)
    public @ResponseBody List<Airline> get() {
        try {
			return this.airlineRepo.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	@RequestMapping(value = "/airline/{airlineId}", method=RequestMethod.GET)
    public @ResponseBody Airline getById(@PathVariable int airlineId) {
        try {
			return this.airlineRepo.getById(airlineId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	@RequestMapping(value = "/airline/{airportId}", method=RequestMethod.POST)
    public void create(@PathVariable int airportId, @RequestBody Airline airline) {
        try {
			//return this.airportRepo.getById(airportId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
    }
	
	@RequestMapping(value = "/airline/{airlineId}", method=RequestMethod.PUT)
    public void update(@PathVariable int airlineId, @RequestBody Airline airline) {
        try {
			//return this.airportRepo.getById(airportId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
    }
	
	@RequestMapping(value = "/airline/{airlineId}", method=RequestMethod.DELETE)
    public void erase(@PathVariable int airlineId) {
        try {
			//return this.airportRepo.getById(airportId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
    }
}
