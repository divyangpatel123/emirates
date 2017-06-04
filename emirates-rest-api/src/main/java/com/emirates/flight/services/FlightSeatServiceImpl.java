package com.emirates.flight.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emirates.flight.domain.FlightSeat;
import com.emirates.flight.repositories.FlightSeatRepository;

/**
 * @author divyang.patel
 * The Class FlightServiceImpl.
 */
@Service("flightSeatService")
public class FlightSeatServiceImpl implements FlightSeatService {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private FlightSeatRepository flightSeatRepository;

    @Autowired
    public void setFlightSeatRepository(FlightSeatRepository flightSeatRepository) {
        this.flightSeatRepository = flightSeatRepository;
    }

    /* (non-Javadoc)
     * @see com.emirates.flight.services.FlightSeatService#getAvailableSeatList(java.util.Date)
     */
    @Override
    public List<String> getAvailableSeatList(Date date) {
        logger.debug("::: getAvailableSeatList called :::");
        return flightSeatRepository.getAvailableSeatList(date);
    }
    
    /* (non-Javadoc)
     * @see com.emirates.flight.services.FlightSeatService#getBookedSeatList(java.util.Date)
     */
    @Override
    public List<String> getBookedSeatList(Date date) {
        logger.debug("::: getBookedSeatList called :::");
        return flightSeatRepository.getBookedSeatList(date);
    }

    /* (non-Javadoc)
     * @see com.emirates.flight.services.FlightSeatService#getSeatByPassengerId(java.lang.String)
     */
    @Override
    public FlightSeat getSeatByPassengerId(String passengerId) {
        logger.debug("::: getSeatByPassengerId called :::");
        return flightSeatRepository.getSeatByPassengerId(passengerId);
    }

    /* (non-Javadoc)
     * @see com.emirates.flight.services.FlightSeatService#saveSeat(com.emirates.flight.domain.FlightSeat)
     */
    @Override
    @Transactional
    public Integer saveSeat(FlightSeat flightSeat) {
        logger.debug("::: saveSeat called :::");
        return flightSeatRepository.saveSeat(flightSeat);
    }

	/* (non-Javadoc)
	 * @see com.emirates.flight.services.FlightSeatService#updateSeat(com.emirates.flight.domain.FlightSeat)
	 */
	@Override
	@Transactional
	public Integer updateSeat(FlightSeat flightSeat) {
		logger.debug("::: updateSeat called :::");
		 return flightSeatRepository.updateSeat(flightSeat);
	}
}
