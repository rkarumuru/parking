package com.parking.street.dataaccess.vehicles;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.parking.street.data.UserDetails;
import com.parking.street.data.Vehicle;

public class VehicleDAOImpl implements VehiclesDAO {

	  private static final Logger logger = Logger.getLogger(VehicleDAOImpl.class);
	
	  @Autowired
	private SessionFactory sessionFactory;
	  
		    
	  public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	  
	
	@SuppressWarnings("unchecked")
	@Override
	public UserDetails getVehicleDetailsByTagId(String tagId) {
		
		Session session = this.sessionFactory.getCurrentSession();      
		UserDetails p = (UserDetails) session.get(UserDetails.class, tagId);
	
		return p;
	}
	
	@Override
	public List<Vehicle> getActiveBeaconsListByUserId(String userId) {
		
		String hql = "FROM Vehicle E WHERE (E.userId =:userId AND E.status='ACTIVE')";
		
		Session session = this.sessionFactory.getCurrentSession();  
		
		Query query = session.createQuery(hql);
		
		query.setParameter("userId",userId);
		
		List <Vehicle> beaconsList  = (List <Vehicle>)query.list();
		
		return beaconsList;
	}


	@Override
	public List<UserDetails> getBeaconsListByUserId(String userId) {
		
		String hql = "FROM UserDetails E WHERE E.userId =:userId";
		
		Session session = this.sessionFactory.getCurrentSession();  
		
		Query query = session.createQuery(hql);
		
		query.setParameter("userId",userId);
		
		List <UserDetails> beaconsList  = (List <UserDetails>)query.list();
		
		return beaconsList;
		
	}


	@Override
	public List<Vehicle> getAllVehicles(String locationId) {
		
		String hql = "FROM Vehicle V WHERE (V.locationId=:locationId AND V.status <> 'INACTIVE')"
				+ " ORDER BY sessionId ASC";
		
		Session session = this.sessionFactory.getCurrentSession();  
		
		Query query = session.createQuery(hql);
		
		query.setParameter("locationId",locationId);
		
		List <Vehicle> vehiclesList  = (List <Vehicle>)query.list();
		
		return vehiclesList;
	}


}
