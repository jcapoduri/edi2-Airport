package org.edi.controllers;

import java.util.List;

import org.edi.entities.FlightRoute;
import org.edi.io.contract.FlightRouteDAO;
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
public class FlightRouteController {
	@Autowired
	protected IFlightRouteManager flightrouteRepo;
	
	@RequestMapping(value = "/flightroute", method=RequestMethod.GET)
    public @ResponseBody List<FlightRoute> get() {
        try {
			return this.flightrouteRepo.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	@RequestMapping(value = "/flightroute/{flightrouteId}", method=RequestMethod.GET)
    public @ResponseBody FlightRoute getById(@PathVariable int flightrouteId) {
        try {
			return this.flightrouteRepo.getById(flightrouteId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	@RequestMapping(value = "/flightroute", method=RequestMethod.POST)
    public @ResponseBody void create(@RequestBody FlightRoute flightroute) {
        try {
			this.flightrouteRepo.save(flightroute);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
    }
	
	@RequestMapping(value = "/flightroute/{flightrouteId}", method=RequestMethod.POST)
    public @ResponseBody void update(@PathVariable int flightrouteId, @RequestBody FlightRoute flightroute) {
        try {
        	flightroute.setId(flightrouteId);
			this.flightrouteRepo.update(flightroute);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
    }
	
	@RequestMapping(value = "/flightroute/{flightrouteId}", method=RequestMethod.DELETE)
    public @ResponseBody void erase(@PathVariable int flightrouteId) {
        try {
			this.flightrouteRepo.remove(flightrouteId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
    }
}
