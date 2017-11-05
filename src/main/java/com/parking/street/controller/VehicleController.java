package com.parking.street.controller;



import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.parking.street.data.UserDetails;
import com.parking.street.data.Vehicle;
import com.parking.street.service.VehicleService;
import com.parking.street.view.BeaconDetailsView;
import com.parking.street.view.BeaconView;
import com.parking.street.view.VehicleView;

@Controller
public class VehicleController {
	private static Logger LOG = Logger.getLogger(VehicleController.class.getName()); 
	private VehicleService vehicleService;
	
	@Autowired(required=true)
	@Qualifier(value="vehicleService")
	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

		
	@GET
	@Produces("application/json")
	@RequestMapping("/getBeaconsList/{userId}")
	@ResponseStatus(value = org.springframework.http.HttpStatus.CREATED)
	@ResponseBody public ModelAndView getBeaconsListByUserId(@PathVariable("userId") String userId) {
		LOG.info("Received request for userId: " + userId);
		List<UserDetails> userDetailsList = (List<UserDetails>)vehicleService.getBeaconsListByUserId(userId);
		
		return new ModelAndView("userDetails", "userDetails", userDetailsList);
		
	}
	
	@GET
	@Produces("application/json")
	@RequestMapping("/getVehicleById/{beaconId}")
	@ResponseStatus(value = org.springframework.http.HttpStatus.CREATED)
	@ResponseBody public ModelAndView getVehicleByTagId(@PathVariable("beaconId") String beaconId) {
		LOG.info("Received request for beaconId: " + beaconId);
		UserDetails userDetails = (UserDetails)vehicleService.getVehicleByTagId(beaconId);
		
		return new ModelAndView("userDetails", "userDetails", userDetails);
		
	}
	
	@GET
	@Produces("application/json")
	@RequestMapping("/getActiveSessionsList/{userId}")
	@ResponseStatus(value = org.springframework.http.HttpStatus.CREATED)
	@ResponseBody public ModelAndView getActiveSessionsListByUserId(@PathVariable("userId") String userId) {
		
		LOG.info("Received request for UserID: " + userId);
		List<Vehicle> vehiclesList = (List<Vehicle>)vehicleService.getActiveBeaconsListByUserId(userId);
		
		BeaconView beaconView = new BeaconView();
		
		if (!CollectionUtils.isEmpty(vehiclesList)) {
			
			beaconView.setActiveSessions(true);
			
		}
		
		
		List<BeaconDetailsView> beaconDetailsList = new ArrayList<BeaconDetailsView>();
		
		if (beaconView.isActiveSessions()) {

			if (!CollectionUtils.isEmpty(vehiclesList)) {

				for(Vehicle vehicle: vehiclesList) {
					
					BeaconDetailsView beaconDetailsView = new BeaconDetailsView();
					
					beaconDetailsView.setSessionId(vehicle.getSessionId());
					beaconDetailsView.setBeaconId(vehicle.getTagId());
					beaconDetailsView.setStatus(vehicle.getStatus());
				
				
					beaconDetailsList.add(beaconDetailsView);
						
					}

			}

		}  else {
			List<UserDetails> userDetailsList = (List<UserDetails>)vehicleService.getBeaconsListByUserId(userId);
				
			 
				
			if (!CollectionUtils.isEmpty(userDetailsList)) {

				for (UserDetails userDetails : userDetailsList) {

						BeaconDetailsView beaconDetailsView = new BeaconDetailsView();
						beaconDetailsView.setBeaconId(userDetails.getBeaconId());
						beaconDetailsView.setUserId(userDetails.getUserId());
						beaconDetailsView.setUserName(userDetails.getUserName());
						beaconDetailsView.setVehicleId(userDetails.getVehicleId());
						
						beaconDetailsList.add(beaconDetailsView);
				
					}
					
				}
		 }
		
		beaconView.setBeaconsView(beaconDetailsList);
		
		return new ModelAndView("beaconView", "beaconView", beaconView);
		
	}
	
}
