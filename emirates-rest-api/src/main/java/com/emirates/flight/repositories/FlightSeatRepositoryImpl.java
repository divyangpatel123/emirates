package com.emirates.flight.repositories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emirates.flight.domain.FlightSeat;
import com.emirates.flight.domain.SeatMap;
import com.emirates.flight.services.SeatMapService;

/**
 * @author divyang.patel
 * The Class FlightSeatRepositoryImpl that holds method related to db operation.
 */
@Repository
public class FlightSeatRepositoryImpl implements FlightSeatRepository {
    
 	private SessionFactory sessionFactory;
 	private final Logger logger = LoggerFactory.getLogger(this.getClass());
 	
	 /** The seat map service. */
 	@Autowired
	private SeatMapService seatMapService;
	 
	 /**
 	 * Instantiates a new flight seat repository impl.
 	 *
 	 * @param factory the factory
 	 */
 	@Autowired
	 public FlightSeatRepositoryImpl(EntityManagerFactory factory) {
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
	 * @see com.emirates.flight.repositories.FlightSeatRepository#getAvailableSeatList(java.util.Date)
	 */
	@Override
	public List<String> getAvailableSeatList(Date date) {
		Session session = getSession();
		Date startDate = getStartOfDay(date);
		Date endDate = getEndOfDay(date);
		logger.info(">>> startDate :::" + startDate);
		logger.info(">>> endDate :::" + endDate);
		Criteria criteria = session.createCriteria(FlightSeat.class);
		criteria.setProjection(Projections.property("seatId"));
		criteria.add(Restrictions.between("departureDate", startDate , endDate ));
		List<Long> bookedSeatIdList = criteria.list();
		List<String> availableSeatList = availableSeats(bookedSeatIdList);
		return availableSeatList;
	}
	
	/* (non-Javadoc)
	 * @see com.emirates.flight.repositories.FlightSeatRepository#getBookedSeatList(java.util.Date)
	 */
	@Override
	public List<String> getBookedSeatList(Date date) {
		Session session = getSession();
		Date startDate = getStartOfDay(date);
		Date endDate = getEndOfDay(date);
		logger.info(">>> startDate :::" + startDate);
		logger.info(">>> endDate :::" + endDate);
		Criteria criteria = session.createCriteria(FlightSeat.class);
		criteria.setProjection(Projections.property("seatId"));
		criteria.add(Restrictions.between("departureDate", startDate , endDate ));
		List<Long> bookedSeatIdList = criteria.list();
		List<String> availableSeatList = bookedSeats(bookedSeatIdList);
		return availableSeatList;
	}

	/* (non-Javadoc)
	 * @see com.emirates.flight.repositories.FlightSeatRepository#getSeatByPassengerId(java.lang.String)
	 */
	@Override
	public FlightSeat getSeatByPassengerId(String passengerId) {
		Session session = getSession();
		Query query = session.createQuery("from FlightSeat where passengerId = :passengerId");
		query.setParameter("passengerId", passengerId);
		query.setMaxResults(1);
		FlightSeat flightSeat = (FlightSeat) query.uniqueResult();
		return flightSeat;
	}

	/* (non-Javadoc)
	 * @see com.emirates.flight.repositories.FlightSeatRepository#saveSeat(com.emirates.flight.domain.Flight)
	 */
	@Override
	public Integer saveSeat(FlightSeat flightSeat) {
		Session session = getSession();
		try{
			if(flightSeat != null){
				Date startDate = getStartOfDay(flightSeat.getDepartureDate());
				Date endDate = getEndOfDay(flightSeat.getDepartureDate());
				logger.info(">>> startDate :::" + startDate);
				logger.info(">>> endDate :::" + endDate);
				Criteria criteria = session.createCriteria(FlightSeat.class);
				criteria.add(Restrictions.between("departureDate", startDate , endDate ));
				criteria.add(Restrictions.eq("seatId", flightSeat.getSeatId()));
				List<FlightSeat> flightList = criteria.list();
				if(flightList.size() > 0){
					logger.error("Error while creating seat for passengerId ::" + flightSeat.getPassengerId());
					return -1;
				}
				flightSeat.setCreatedDate(new Date());
				flightSeat.setModifiedDate(new Date());
		    	logger.info("Created seat for passengerId ::" + flightSeat.getPassengerId());
		    	return (Integer) session.save(flightSeat);
			}
		}catch(Exception e){
			logger.error("Error while creating seat for passengerId ::" + flightSeat.getPassengerId());
		}
		return -1;
	}

	/* (non-Javadoc)
	 * @see com.emirates.flight.repositories.FlightSeatRepository#updateSeat(com.emirates.flight.domain.FlightSeat)
	 */
	@Override
	public Integer updateSeat(FlightSeat flightSeat) {
		Session session = getSession();
		try{
			if(flightSeat != null){
				Date startDate = getStartOfDay(flightSeat.getDepartureDate());
				Date endDate = getEndOfDay(flightSeat.getDepartureDate());
				logger.info(">>> startDate :::" + startDate);
				logger.info(">>> endDate :::" + endDate);
				Criteria criteria = session.createCriteria(FlightSeat.class);
				criteria.add(Restrictions.between("departureDate", startDate , endDate ));
				criteria.add(Restrictions.eq("seatId", flightSeat.getSeatId()));
				List<FlightSeat> flightList = criteria.list();
				if(flightList.size() > 0){
					logger.error("Error while creating seat for passengerId ::" + flightSeat.getPassengerId());
					return -1;
				}
				session.saveOrUpdate(flightSeat);
				session.flush();
				logger.info("Updated seat for passengerId ::" + flightSeat.getPassengerId());
				return 1;
			}
		}catch(Exception e){
			logger.error("Error while updating seat for passengerId ::" + flightSeat.getPassengerId());
		}
		return -1;
	}
	
	/* (non-Javadoc)
	 * @see com.emirates.flight.repositories.FlightSeat#find(java.lang.Integer)
	 */
	@Override
	public FlightSeat find(Integer id) {
		Session session = getSession();
		return session.get(FlightSeat.class, id);
	}
	
	/**
	 * available seats.
	 *
	 * @param seatIdList the seat id list
	 * @return the list
	 */
	private List<String> availableSeats(List<Long> seatIdList) {
		List<SeatMap> seatList = seatMapService.getSeatList();
		List<String> newSeatList = new ArrayList<>();
		for (SeatMap seat : seatList) {
			if(!seatIdList.contains(seat.getId())){
				newSeatList.add(seat.getName());
			}
		}
		return newSeatList;
	}
	
	/**
	 * booked seats.
	 *
	 * @param seatIdList the seat id list
	 * @return the list
	 */
	private List<String> bookedSeats(List<Long> seatIdList) {
		List<SeatMap> seatList = seatMapService.getSeatList();
		List<String> newSeatList = new ArrayList<>();
		for (SeatMap seat : seatList) {
			if(seatIdList.contains(seat.getId())){
				newSeatList.add(seat.getName());
			}
		}
		return newSeatList;
		
	}
	
	
	/**
	 * Gets the end of day.
	 *
	 * @param date the date
	 * @return the end of day
	 */
	public Date getEndOfDay(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 23);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.SECOND, 59);
	    calendar.set(Calendar.MILLISECOND, 999);
	    return calendar.getTime();
	}

	/**
	 * Gets the start of day.
	 *
	 * @param date the date
	 * @return the start of day
	 */
	public Date getStartOfDay(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	}
}
