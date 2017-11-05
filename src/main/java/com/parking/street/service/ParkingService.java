package com.parking.street.service;

import com.parking.street.data.RateDetails;
import com.parking.street.data.Vehicle;
import com.parking.street.view.ParkingForm;

public interface ParkingService {

	public Vehicle addParkingDetails(ParkingForm parkingForm);
	
	public Vehicle updateParkingStatus(ParkingForm parkingForm);
	
	public Vehicle getReciept(String sessionId);
	
	public Vehicle getParkingStatusInfo(String sessionId);
	
	public RateDetails getParkingTermsInfo(String locationId);
	
}
