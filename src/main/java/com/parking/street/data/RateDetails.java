package com.parking.street.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="RATE_DETAILS")

public class RateDetails implements Serializable {
	
	@Id
	@Column(name="locationId")
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
