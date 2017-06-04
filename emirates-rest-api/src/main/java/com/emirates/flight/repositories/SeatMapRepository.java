package com.emirates.flight.repositories;

import java.util.List;

import com.emirates.flight.domain.SeatMap;

/**
 * @author divyang.patel
 * The Interface SeatMapRepository.
 */
public interface SeatMapRepository{

	/**
	 * Gets the seat list.
	 *
	 * @return the seat list
	 */
	public List<SeatMap> getSeatList();

	/**
	 * Find.
	 *
	 * @param seatId the seat id
	 * @return the seat
	 */
	public SeatMap find(Long seatId);

	
	
}
