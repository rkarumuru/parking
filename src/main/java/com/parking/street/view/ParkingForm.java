package com.parking.street.view;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="parkingForm")
public class ParkingForm implements Serializable {
	
private String sessionId;
	
	private String tagId;
	
	private String locationId;
	
	private String transId;
	
	private Date startTime;
	
	private Date endTime;
	
	private String status;
	
	private double totalCharge;
	
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
		return totalCharge;
	}

	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
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

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}
	
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("transId=").append(transId);
			builder.append("actualLatitude=").append(actualLatitude);
			builder.append("actualLongitude=").append(actualLongitude);
			builder.append("displayLatitude=").append(displayLatitude);
			builder.append("displayLongitude=").append(displayLongitude);
			builder.append("totalCharge=").append(totalCharge);
			builder.append("status=").append(status);
			builder.append("endTime=").append(endTime);
			builder.append("startTime=").append(startTime);
			builder.append("locationId=").append(locationId);
			builder.append("tagId=").append(tagId);
			builder.append("sessionId=").append(sessionId);
			return builder.toString();
		}

	

}
