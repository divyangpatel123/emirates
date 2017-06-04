package com.emirates.flight.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.emirates.flight.configuration.RepositoryConfiguration;
import com.emirates.flight.domain.FlightSeat;

/**
 * @author divyang.patel
 * The Class FlightSeatRepositoryTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class FlightSeatRepositoryTest {
	
	private FlightSeatRepository flightSeatRepository;
    
	/**
	 * Sets the flight repository.
	 *
	 * @param flightSeatRepository the new flight repository
	 */
	@Autowired
    public void setFlightRepository(FlightSeatRepository flightSeatRepository) {
        this.flightSeatRepository = flightSeatRepository;
    }
    
    /**
     * Test save flight seat.
     */
    @Test
    public void testSaveFlightSeat(){
        
    	//setup flight seat
        FlightSeat flightSeat = new FlightSeat();
        Calendar departureDate = Calendar.getInstance();
        departureDate.set(Calendar.DATE, 25);
        flightSeat.setPassengerId("EMIPASS80");
        flightSeat.setPassengerName("Divyang Patel");
        flightSeat.setPassengerEmail("divyangpatel74@gmail.com");
        flightSeat.setPassengerMobile("+91 7698221862");
        flightSeat.setSeatId(getRandomSeatId());
        flightSeat.setDepartureDate(departureDate.getTime());
        flightSeat.setCreatedDate(new Date());
        flightSeat.setModifiedDate(new Date());
        
        //save flight, verify has ID value after save
        assertNull(flightSeat.getId()); //null before save
        Integer id = flightSeatRepository.saveSeat(flightSeat);
        
        //should not be null
        assertNotNull(id); //not null after save
        
        //fetch from DB
        FlightSeat fetchedFlightSeat = flightSeatRepository.getSeatByPassengerId(flightSeat.getPassengerId());
        
        //should not be null
        assertNotNull(fetchedFlightSeat);
        
        //should equal
        assertEquals(flightSeat.getPassengerId(), fetchedFlightSeat.getPassengerId());
        assertEquals(flightSeat.getPassengerName(), fetchedFlightSeat.getPassengerName());
        
        //update description and save
        fetchedFlightSeat.setSeatId(getRandomSeatId());
        flightSeatRepository.updateSeat(fetchedFlightSeat);
        
        //get from DB, should be updated
        FlightSeat fetchedUpdatedFlightSeat = flightSeatRepository.getSeatByPassengerId(fetchedFlightSeat.getPassengerId());
        assertEquals(fetchedFlightSeat.getPassengerName(), fetchedUpdatedFlightSeat.getPassengerName());
        
    }
    
    /**
     * Gets the random seat id.
     *
     * @return the random seat id
     */
    private Long getRandomSeatId(){
    	int upper = 100;
    	int lower = 1;
    	int r = (int) (Math.random() * (upper - lower)) + lower;
    	return Long.parseLong(String.valueOf(r));
    }
}
