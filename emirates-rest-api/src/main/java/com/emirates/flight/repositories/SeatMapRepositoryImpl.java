package com.emirates.flight.repositories;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emirates.flight.domain.SeatMap;

/**
 * @author divyang.patel
 * The Class SeatMapRepositoryImpl.
 */
@Repository
public class SeatMapRepositoryImpl implements SeatMapRepository {
    
	 private SessionFactory sessionFactory;

	 /**
 	 * Instantiates a new seat repository impl.
 	 *
 	 * @param factory the factory
 	 */
 	@Autowired
	 public SeatMapRepositoryImpl(EntityManagerFactory factory) {
		 if(factory.unwrap(SessionFactory.class) == null){
			 throw new NullPointerException("factory is not a hibernate factory");
		 }
		 this.sessionFactory = factory.unwrap(SessionFactory.class);
	 }
	 
	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	private Session getSession(){
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
		}catch(Exception e){
			session = sessionFactory.openSession();
		}
		return session;
		
	}

	/* (non-Javadoc)
	 * @see com.emirates.flight.repositories.SeatMapRepository#getSeatList()
	 */
	@Override
	public List<SeatMap> getSeatList() {
		Criteria criteria = getSession().createCriteria(SeatMap.class);
		List<SeatMap> seatList = criteria.list();
		return seatList;
	}

	/* (non-Javadoc)
	 * @see com.emirates.flight.repositories.SeatMapRepository#find(java.lang.Long)
	 */
	@Override
	public SeatMap find(Long seatId) {
		Session session = getSession();
		return (SeatMap) session.get(SeatMap.class, seatId);
	} 
	 
	
}
