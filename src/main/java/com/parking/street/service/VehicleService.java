package com.parking.street.service;

import java.util.List;

import com.parking.street.data.UserDetails;
import com.parking.street.data.Vehicle;

public interface VehicleService {

	public UserDetails getVehicleByTagId(String tagId);
	
	public List<Vehicle> getActiveBeaconsListByUserId(String userId);


	public List<UserDetails> getBeaconsListByUserId(String userId);
	
	public List<Vehicle> getAllVehicles(String locationId);

	
}
