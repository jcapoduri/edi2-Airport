package org.edi.controllers;

import java.util.List;

import org.edi.business.contract.AirlineDAO;
import org.edi.entities.Airline;
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
	
	@RequestMapping(value = "/airline", method=RequestMethod.POST)
    public @ResponseBody void create(@RequestBody Airline airline) {
        try {
			this.airlineRepo.save(airline);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
    }
	
	@RequestMapping(value = "/airline/{airlineId}", method=RequestMethod.PUT)
    public @ResponseBody void update(@PathVariable int airlineId, @RequestBody Airline airline) {
        try {
        	airline.setId(airlineId);
			this.airlineRepo.update(airline);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
    }
	
	@RequestMapping(value = "/airline/{airlineId}", method=RequestMethod.DELETE)
    public void erase(@PathVariable int airlineId) {
        try {
			this.airlineRepo.remove(airlineId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
    }
}
