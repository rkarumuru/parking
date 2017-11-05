package com.parking.street.view;

import java.util.Date;

public class VehicleView {

    private String sessionId;
	
	private String tagId;
	
	private String locationId;
	
	private Date startTime;
	
	private Date endTime;
	
	private String status;
	
	private double totalcharge;
	
    private float displayLongitude;
	
	private float displayLatitude;
	
	private float actualLongitude;
	
	private float actualLatitude;
	
	private String userId;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalCharge() {
		return totalcharge;
	}

	public void setTotalCharge(double totalCharge) {
		this.totalcharge = totalCharge;
	}

	public float getDisplayLongitude() {
		return displayLongitude;
	}

	public void setDisplayLongitude(float displayLongitude) {
		this.displayLongitude = displayLongitude;
	}

	public float getDisplayLatitude() {
		return displayLatitude;
	}

	public void setDisplayLatitude(float displayLatitude) {
		this.displayLatitude = displayLatitude;
	}

	public float getActualLongitude() {
		return actualLongitude;
	}

	public void setActualLongitude(float actualLongitude) {
		this.actualLongitude = actualLongitude;
	}

	public float getActualLatitude() {
		return actualLatitude;
	}

	public void setActualLatitude(float actualLatitude) {
		this.actualLatitude = actualLatitude;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
