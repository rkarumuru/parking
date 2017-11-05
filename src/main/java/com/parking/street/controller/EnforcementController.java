package com.parking.street.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.parking.street.data.Vehicle;
import com.parking.street.service.VehicleService;

@Controller
public class EnforcementController {
	
	private static Logger LOG = Logger.getLogger(EnforcementController.class.getName()); 
	private VehicleService vehicleService;
	
	@Autowired(required=true)
	@Qualifier(value="vehicleService")
	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	
	@GET
	@Produces("application/json")
	@RequestMapping("/getAllVehicles/{locationId}")
	@ResponseStatus(value = org.springframework.http.HttpStatus.CREATED)
	@ResponseBody public ModelAndView getVehiclesByLocationId(@PathVariable("locationId") String locationId) {
		LOG.info("Received request for Vehicle list");
		
		List<Vehicle> vehiclesList = (List<Vehicle>) vehicleService
				.getAllVehicles(locationId);

		
		return new ModelAndView("vehiclesList", "vehiclesList", vehiclesList);
		
	}

}
