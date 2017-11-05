package com.parking.street.controller;

import java.lang.reflect.InvocationTargetException;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.parking.street.data.RateDetails;
import com.parking.street.data.Vehicle;
import com.parking.street.service.ParkingService;
import com.parking.street.view.ParkingForm;
import com.parking.street.view.RateDetailsView;
import com.parking.street.view.VehicleView;

@Controller
public class ParkingController {

	public static final String BIND_ATTR = "parkingForm";

	public static final String content_type = "application/json; charset=UTF-8";

	private ParkingService parkingService;

	private static Logger LOG = Logger.getLogger(ParkingController.class);

	@Autowired(required = true)
	@Qualifier(value = "parkingService")
	public void setParkingService(ParkingService parkingService) {
		this.parkingService = parkingService;
	}

	@Produces("application/json")
	@ResponseStatus(value = org.springframework.http.HttpStatus.CREATED)
	@RequestMapping(value = "/parkVehicle", method = RequestMethod.POST, consumes = content_type)
	@ResponseBody
	public ModelAndView addParkingVehicle(@RequestBody ParkingForm parkingForm) {

		BindingResult bindingResult = new BeanPropertyBindingResult(
				parkingForm, BIND_ATTR);

		// createParkingForm(parkingForm);
		LOG.info("request received for start parking for vehicle: "
				+ parkingForm);

		Vehicle vehicle = this.parkingService.addParkingDetails(parkingForm);

		VehicleView vehicleView = new VehicleView();

		try {
			BeanUtils.copyProperties(vehicleView, vehicle);
		} catch (IllegalAccessException | InvocationTargetException e) {
			LOG.error("Error in copying properties: " + parkingForm.getTagId(),
					e);
		}

		LOG.info("request processed for start parking for vehicle: "
				+ parkingForm.getTagId());
		return new ModelAndView("vehicleView", "vehicleView", vehicleView);
	}

	/*
	 * private void createParkingForm(ParkingForm parkingForm) {
	 * 
	 * parkingForm.setSessionId("116"); parkingForm.setTagId("11114");
	 * parkingForm.setLocationId("11113"); parkingForm.setTransId("11113");
	 * parkingForm.setStartTime(new Date()); parkingForm.setEndTime(new Date());
	 * parkingForm.setStatus("Active"); parkingForm.setTotalCharge(0.0);
	 * parkingForm.setDisplayLatitude((float)47.608941);
	 * parkingForm.setDisplayLongitude((float)-122.340141);
	 * parkingForm.setActualLatitude((float)47.608941);
	 * parkingForm.setActualLongitude((float)-122.340141);
	 * 
	 * 
	 * }
	 */

	@Produces("application/json")
	@ResponseStatus(value = org.springframework.http.HttpStatus.CREATED)
	@RequestMapping(value = "/endParking", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView updateParkingVehicle(
			@RequestBody ParkingForm parkingForm) {

		LOG.info("request received for end parking for vehicle: "
				+ parkingForm.getTagId());
		// createParkingForm(parkingForm);

		Vehicle vehicle = this.parkingService.updateParkingStatus(parkingForm);

		VehicleView vehicleView = new VehicleView();

		try {
			BeanUtils.copyProperties(vehicleView, vehicle);
		} catch (IllegalAccessException | InvocationTargetException e) {
			LOG.error("Error in copying properties: " + parkingForm.getTagId(),
					e);
		}

		LOG.info("request processed for end parking for vehicle: "
				+ parkingForm.getTagId());
		return new ModelAndView("vehicleView", "vehicleView", vehicleView);

	}

	@GET
	@Produces("application/json")
	@RequestMapping("/getReciept/{sessionId}")
	@ResponseStatus(value = org.springframework.http.HttpStatus.CREATED)
	@ResponseBody
	public ModelAndView getReciept(@PathVariable("sessionId") String sessionId) {

		LOG.info("request received for getReceipt for session: " + sessionId);
		Vehicle vehicle = this.parkingService.getReciept(sessionId);
		VehicleView vehicleView = new VehicleView();

		try {
			BeanUtils.copyProperties(vehicleView, vehicle);
		} catch (IllegalAccessException | InvocationTargetException e) {
			LOG.error("Error in copying properties: " + sessionId, e);
		}
		LOG.info("request processed for getReceipt for session: " + sessionId);
		return new ModelAndView("vehicleView", "vehicleView", vehicleView);

	}

	@GET
	@Produces("application/json")
	@RequestMapping("/parkingDetails/{sessionId}")
	@ResponseStatus(value = org.springframework.http.HttpStatus.CREATED)
	@ResponseBody
	public ModelAndView getParkingStatusInfo(
			@PathVariable("sessionId") String sessionId) {

		LOG.info("request received for parkingDetails for session: "
				+ sessionId);
		Vehicle vehicle = this.parkingService.getParkingStatusInfo(sessionId);

		VehicleView vehicleView = new VehicleView();

		try {
			BeanUtils.copyProperties(vehicleView, vehicle);
		} catch (IllegalAccessException | InvocationTargetException e) {
			LOG.error("Error in copying properties: " + sessionId, e);
		}
		LOG.info("request processed for parkingDetails for session: "
				+ sessionId);
		return new ModelAndView("vehicleView", "vehicleView", vehicleView);

	}

	@GET
	@Produces("application/json")
	@RequestMapping("/acceptLocation")
	@ResponseStatus(value = org.springframework.http.HttpStatus.CREATED)
	@ResponseBody
	public ModelAndView acceptLocation(@RequestBody ParkingForm parkingForm) {

		BindingResult bindingResult = new BeanPropertyBindingResult(
				parkingForm, BIND_ATTR);
		LOG.info("Accept location request received for vehicle: " + parkingForm);
		// createParkingForm(parkingForm);
		
		RateDetails rateDetails = this.parkingService.getParkingTermsInfo(parkingForm.getLocationId());

		RateDetailsView rateDetailsView = new RateDetailsView();

		try {
			BeanUtils.copyProperties(rateDetailsView, rateDetails);
		} catch (IllegalAccessException | InvocationTargetException e) {
			LOG.error("Error in copying properties: " + parkingForm.getTagId(),
					e);
		}
		LOG.info("Accept location request processed for vehicle: "
				+ parkingForm);
		return new ModelAndView("rateDetailsView", "rateDetailsView", rateDetailsView);

	}

}
