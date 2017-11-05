package com.parking.street.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.parking.street.data.UserDetails;
import com.parking.street.data.Vehicle;
import com.parking.street.dataaccess.vehicles.VehiclesDAO;

public class VehicleServiceImpl implements VehicleService {

	@Autowired(required=true)
	private VehiclesDAO vehiclesDAO;
	
	
	public void setVehiclesDAO(VehiclesDAO vehiclesDAO) {
		this.vehiclesDAO = vehiclesDAO;
	}

	
	@Override
	@Transactional
	public UserDetails getVehicleByTagId(String tagId) {
		
		return (UserDetails)vehiclesDAO.getVehicleDetailsByTagId(tagId);
	}

	@Override
	@Transactional
	public List<Vehicle> getActiveBeaconsListByUserId(String userId) {
	
		return (List<Vehicle>)vehiclesDAO.getActiveBeaconsListByUserId(userId);
	}


	@Override
	@Transactional
	public List<UserDetails> getBeaconsListByUserId(String userId) {
		return (List<UserDetails>)vehiclesDAO.getBeaconsListByUserId(userId);
	}


	@Override
	@Transactional
	public List<Vehicle> getAllVehicles(String locationId) {
		
		return (List<Vehicle>)vehiclesDAO.getAllVehicles(locationId);
	}

}
