package com.parking.street.dataaccess.parking;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.parking.street.data.RateDetails;
import com.parking.street.data.Vehicle;

public class ParkingDAOImpl implements ParkingDAO {

	 private static final Logger logger = Logger.getLogger(ParkingDAOImpl.class);
		
	  @Autowired
	private SessionFactory sessionFactory;
	  
		    
	  public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }

	@Override
	public Vehicle addParkingDetails(Vehicle vehicle) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(vehicle);
		return vehicle;
	}

	@Override
	public Vehicle updateParkingStatus(Vehicle vehicle) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("update Vehicle  set endTime= :endTime," +
				  
				" totalcharge=:totalcharge,status=:status where sessionId= :sessionId");
		
		query.setParameter("endTime", vehicle.getEndTime());
		query.setParameter("totalcharge", vehicle.getTotalCharge());
		query.setParameter("status", vehicle.getStatus());
		query.setParameter("sessionId", vehicle.getSessionId());

		int result = query.executeUpdate();
		
		return vehicle;
	}

	@Override
	public Vehicle getReciept(String sessionId) {
		Session session = this.sessionFactory.getCurrentSession();      
		Vehicle p = (Vehicle) session.get(Vehicle.class, sessionId);
	
		return p;
	}

	@Override
	public Vehicle getParkingStatusInfo(String sessionId) {
		
		Session session = this.sessionFactory.getCurrentSession();      
		Vehicle p = (Vehicle) session.get(Vehicle.class, sessionId);
	
		return p;
	}

	@Override
	public RateDetails getChargesByLocationId(String locationId) {
		
		Session session = this.sessionFactory.getCurrentSession();      
		RateDetails rateDetails = (RateDetails) session.get(RateDetails.class, locationId);
	
		return rateDetails;
	}

	
}
