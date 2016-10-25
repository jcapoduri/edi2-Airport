package org.edi.controllers;

import org.edi.business.*;
import org.edi.entities.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class AirportController {
	@Autowired
	protected AirportRepository airportRepo;
	
	@RequestMapping(value = "/airport", method=RequestMethod.GET)
    public @ResponseBody Airport get() {
        try {
			return new Airport();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	@RequestMapping(value = "/airport/{airportId}", method=RequestMethod.GET)
    public @ResponseBody Airport getById(@PathVariable int airportId) {
        try {
			return this.airportRepo.getById(airportId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
}
