package com.parking.street.view;

public class RateDetailsView {
	
	private String locationId;
	
	private String rateId;
	
	private double charge;
	
	private double maxTime;
	
	private String freeDays;
	
	private String freeTime;

	public String getRateId() {
		return rateId;
	}

	public void setRateId(String rateId) {
		this.rateId = rateId;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public double getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(double maxTime) {
		this.maxTime = maxTime;
	}

	public String getFreeDays() {
		return freeDays;
	}

	public void setFreeDays(String freeDays) {
		this.freeDays = freeDays;
	}

	public String getFreeTime() {
		return freeTime;
	}

	public void setFreeTime(String freeTime) {
		this.freeTime = freeTime;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	
	

}
