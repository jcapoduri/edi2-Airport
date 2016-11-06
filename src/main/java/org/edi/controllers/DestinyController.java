package org.edi.controllers;

import java.util.List;

import org.edi.business.contract.IDestinyManager;
import org.edi.entities.Destiny;
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
public class DestinyController {
	@Autowired
	protected IDestinyManager destinyRepo;
	
	@RequestMapping(value = "/destiny", method=RequestMethod.GET)
    public @ResponseBody List<Destiny> get() {
        try {
			return this.destinyRepo.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	@RequestMapping(value = "/destiny/{destinyId}", method=RequestMethod.GET)
    public @ResponseBody Destiny getById(@PathVariable int destinyId) {
        try {
			return this.destinyRepo.getById(destinyId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	
	@RequestMapping(value = "/destiny", method=RequestMethod.POST)
    public @ResponseBody void create(@RequestBody Destiny destiny) {
        try {
			this.destinyRepo.save(destiny);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
    }
	
	@RequestMapping(value = "/destiny/{destinyId}", method=RequestMethod.POST)
    public @ResponseBody void update(@PathVariable int destinyId, @RequestBody Destiny destiny) {
        try {
        	destiny.setId(destinyId);
			this.destinyRepo.update(destiny);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
    }
	
	@RequestMapping(value = "/destiny/{destinyId}", method=RequestMethod.DELETE)
    public @ResponseBody  void erase(@PathVariable int destinyId) {
        try {
			this.destinyRepo.remove(destinyId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
    }
}
