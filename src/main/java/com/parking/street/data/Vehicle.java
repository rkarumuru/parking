package com.parking.street.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * 
      sessionid, location id, tagid,start time, endtime, status(active/inactive),total charge
 *
 */
@Entity
@Table(name="PARKED_VEHICLES")
public class Vehicle implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id  @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sessionId")
	private String sessionId;
	
	private String tagId;
	
	private String locationId;
	
	private String userId;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="transId")
	private String transId;
	
	private Date startTime;
	
	private Date endTime;
	
	private String status;
	
	private double totalcharge;
	
	private float displayLongitude;
	
	private float displayLatitude;
	
	private float actualLongitude;
	
	private float actualLatitude;

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

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
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

	public void setTotalCharge(double totalcharge) {
		this.totalcharge = totalcharge;
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
