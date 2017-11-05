package com.parking.street.service;

import com.parking.street.data.RateDetails;
import com.parking.street.data.Vehicle;

public class RateCalculator {

	public static double calculateRate(Vehicle vehicle, RateDetails rates){
		long endTimeMillisecs = System.currentTimeMillis();
		long diffInTimes = 0L;
		if(vehicle.getEndTime() != null){
			endTimeMillisecs = vehicle.getEndTime().getTime();
		}
		// calculate in hours for now
		diffInTimes = endTimeMillisecs - vehicle.getStartTime().getTime();
		
		double diffInHours = diffInTimes/(1000 * 60* 60);
		
		long roundedHours = Math.round(diffInHours);
		if(diffInHours == 0 || (roundedHours - diffInHours) < 0){
			roundedHours++;
		}
		if(rates != null && rates.getCharge() != 0){
			 return (roundedHours * rates.getCharge());
		}else{
			return roundedHours;
		}
		
		//check for free days
		/*
		 * Calendar startTime = Calendar.getInstance();
		startTime.setTime(vehicle.getStartTime());
		int currentDay = startTime.get(Calendar.DAY_OF_WEEK);
		 * 
		 * if(rates.getFreeDays())
		 */
		
	}
	
}
