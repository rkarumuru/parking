package com.parking.street.dataaccess.parking;

import com.parking.street.data.RateDetails;
import com.parking.street.data.Vehicle;

public interface ParkingDAO {
	
	public Vehicle addParkingDetails(Vehicle vehicle);
	
	public Vehicle updateParkingStatus(Vehicle vehicle);
	
	public Vehicle getReciept(String sessionId);
	
	public Vehicle getParkingStatusInfo(String sessionId);
	
	public RateDetails getChargesByLocationId(String rateId);
	
	

}
