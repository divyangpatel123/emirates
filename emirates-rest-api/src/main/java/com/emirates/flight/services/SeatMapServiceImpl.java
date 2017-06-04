package com.emirates.flight.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emirates.flight.domain.SeatMap;
import com.emirates.flight.repositories.SeatMapRepository;

/**
 * @author divyang.patel
 * The Class SeatServiceImpl.
 */
@Service("seatMapService")
public class SeatMapServiceImpl implements SeatMapService {
    
    @Autowired
    private SeatMapRepository seatMapRepository;

	/* (non-Javadoc)
	 * @see com.emirates.flight.services.SeatMapService#getSeatList()
	 */
	@Override
	public List<SeatMap> getSeatList() {
		return seatMapRepository.getSeatList();
	}

	/* (non-Javadoc)
	 * @see com.emirates.flight.services.SeatMapService#find(java.lang.Long)
	 */
	@Override
	public SeatMap find(Long seatId) {
		return seatMapRepository.find(seatId);
	}

    
}
