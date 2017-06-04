package com.emirates.flight.services;
import java.util.Date;
import java.util.List;
import com.emirates.flight.domain.FlightSeat;

/**
 * @author divyang.patel
 * The Interface FlightService.
 */
public interface FlightSeatService {
	
	/**
	 * Gets the available seat list.
	 *
	 * @param date the date
	 * @return the available seat list
	 */
	List<String> getAvailableSeatList(Date date);
	
	/**
	 * Gets the booked seat list.
	 *
	 * @param date the date
	 * @return the booked seat list
	 */
	List<String> getBookedSeatList(Date date);

    /**
     * Gets the seat by passenger id.
     *
     * @param passengerId the passenger id
     * @return the seat by passenger id
     */
    FlightSeat getSeatByPassengerId(String passengerId);

    /**
     * Save seat.
     *
     * @param flightSeat the flight seat
     * @return the integer
     */
    Integer saveSeat(FlightSeat flightSeat);

	/**
	 * Update seat.
	 *
	 * @param flight the flight
	 * @return the integer
	 */
	public Integer updateSeat(FlightSeat flightSeat);
}
