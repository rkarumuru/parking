package com.parking.street.dataaccess.vehicles;

import java.util.List;

import com.parking.street.data.UserDetails;
import com.parking.street.data.Vehicle;

public interface VehiclesDAO {

	public UserDetails getVehicleDetailsByTagId(String tagId);
	

	public List<Vehicle> getActiveBeaconsListByUserId(String userId);
	

	public List<UserDetails> getBeaconsListByUserId(String userId);
	
	public List<Vehicle> getAllVehicles(String locationId);
	
	
}
