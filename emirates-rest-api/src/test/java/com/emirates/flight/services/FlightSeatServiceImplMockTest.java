package com.emirates.flight.services;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.emirates.flight.domain.FlightSeat;
import com.emirates.flight.repositories.FlightSeatRepository;

/**
 * @author divyang.patel
 * The Class FlightServiceImplMockTest.
 */
public class FlightSeatServiceImplMockTest {

    private FlightSeatServiceImpl flightSeatServiceImpl;
    @Mock
    private FlightSeatRepository flightSeatRepository;
    @Mock
    private FlightSeat flightSeat;
    @Mock
    private List<String> avaialableSeatList;
    @Mock
    private List<String> bookedSeatList;

    
    /**
     * Setup mock.
     */
    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        flightSeatServiceImpl=new FlightSeatServiceImpl();
        flightSeatServiceImpl.setFlightSeatRepository(flightSeatRepository);
    }
    
    /**
     * Should return flight seat when get flight seat by passenger id is called.
     *
     * @throws Exception the exception
     */
    @Test
    public void shouldReturnFlightSeat_whenGetFlightSeatByPassengerIdIsCalled() throws Exception {
        // Arrange
        when(flightSeatRepository.getSeatByPassengerId("EMIPASS26")).thenReturn(flightSeat);
        // Act
        FlightSeat retrievedFlightSeat = flightSeatServiceImpl.getSeatByPassengerId("EMIPASS26");
        // Assert
        assertThat(retrievedFlightSeat, is(equalTo(flightSeat)));

    }
    
    /**
     * Should return available seat list when get available seat list is called.
     *
     * @throws Exception the exception
     */
    @Test
    public void shouldReturnAvailableSeatList_whenGetAvailableSeatListIsCalled() throws Exception {
        Date departureDate = new Date();
    	// Arrange
        when(flightSeatRepository.getAvailableSeatList(departureDate)).thenReturn(avaialableSeatList);
        // Act
        List<String> retrivedAvaialableSeatList = flightSeatServiceImpl.getAvailableSeatList(departureDate);
        // Assert
        assertThat(retrivedAvaialableSeatList, is(equalTo(avaialableSeatList)));
    }
    
    /**
     * Should return booked seat list when get booked seat list is called.
     *
     * @throws Exception the exception
     */
    @Test
    public void shouldReturnBookedSeatList_whenGetBookedSeatListIsCalled() throws Exception {
        Date departureDate = new Date();
    	// Arrange
        when(flightSeatRepository.getBookedSeatList(departureDate)).thenReturn(bookedSeatList);
        // Act
        List<String> retrivedBookedSeatList = flightSeatServiceImpl.getBookedSeatList(departureDate);
        // Assert
        assertThat(retrivedBookedSeatList, is(equalTo(bookedSeatList)));
    }
    
   /**
    * Should return integer val when save seat is called.
    *
    * @throws Exception the exception
    */
   @Test
    public void shouldReturnIntegerVal_whenSaveSeatIsCalled() throws Exception {
	   Integer saveReturnVal = null;
	   // Arrange
        when(flightSeatRepository.saveSeat(flightSeat)).thenReturn(saveReturnVal);
        // Act
        Integer retrivedSaveReturnVal = flightSeatServiceImpl.saveSeat(flightSeat);
        // Assert
        assertThat(retrivedSaveReturnVal, is(equalTo(saveReturnVal)));
    }
   
   /**
    * Should return integer val when update seat is called.
    *
    * @throws Exception the exception
    */
   @Test
   public void shouldReturnIntegerVal_whenUpdateSeatIsCalled() throws Exception {
	   Integer updateReturnVal = null;
	   // Arrange
       when(flightSeatRepository.updateSeat(flightSeat)).thenReturn(updateReturnVal);
       // Act
       Integer retrivedUpdateReturnVal = flightSeatServiceImpl.updateSeat(flightSeat);
       // Assert
       assertThat(retrivedUpdateReturnVal, is(equalTo(updateReturnVal)));
   }
   
}