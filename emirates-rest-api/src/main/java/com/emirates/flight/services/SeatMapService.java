package com.emirates.flight.services;

import java.util.List;
import com.emirates.flight.domain.SeatMap;

/**
 * @author divyang.patel
 * The Interface SeatMapService.
 */
public interface SeatMapService {
	
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
