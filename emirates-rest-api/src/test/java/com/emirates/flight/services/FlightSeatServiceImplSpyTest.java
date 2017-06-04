package com.emirates.flight.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.emirates.flight.domain.FlightSeat;
import com.emirates.flight.repositories.FlightSeatRepository;

/**
 * @author divyang.patel
 * The Class FlightSeatServiceImplSpyTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class FlightSeatServiceImplSpyTest {
    
    @Spy
    private FlightSeatServiceImpl flightSeatServiceSpy;
    @Mock
    private FlightSeatRepository flightSeatRepository;
    @Mock
    private FlightSeat flightSeat;
    @Mock
    private List<String> availableSeatList;
    @Mock
    private List<String> bookedSeatList;

    /**
     * Should throw null pointer exception when get available seat list is called without context.
     *
     * @throws Exception the exception
     */
    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerException_whenGetAvailableSeatListIsCalledWithoutContext() 
    		throws Exception {
        Date departureDate = new Date();
    	//Act
        List<String> retrievedAvailableSeatList = flightSeatServiceSpy.getAvailableSeatList(departureDate);
        //Assert
        assertThat(retrievedAvailableSeatList, is(equalTo(availableSeatList)));
    }
    
    /**
     * Should throw null pointer exception when get booked seat list is called without context.
     *
     * @throws Exception the exception
     */
    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerException_whenGetBookedSeatListIsCalledWithoutContext() 
    		throws Exception {
        Date departureDate = new Date();
    	//Act
        List<String> retrievedBookedSeatList = flightSeatServiceSpy.getBookedSeatList(departureDate);
        //Assert
        assertThat(retrievedBookedSeatList, is(equalTo(bookedSeatList)));
    }

    /**
     * Should throw null pointer exception when save seat is called without context.
     *
     * @throws Exception the exception
     */
    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerException_whenSaveSeatIsCalledWithoutContext() throws Exception {
    	 Integer saveReturnVal = null;
    	//Arrange
        Mockito.doReturn(saveReturnVal).when(flightSeatRepository).saveSeat(flightSeat);
        //Act
        Integer retrievedReturnVal = flightSeatServiceSpy.saveSeat(flightSeat);
        //Assert
        assertThat(saveReturnVal, is(equalTo(retrievedReturnVal)));
    }
    
    /**
     * Should throw null pointer exception when update seat is called without context.
     *
     * @throws Exception the exception
     */
    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerException_whenUpdateSeatIsCalledWithoutContext() throws Exception {
   	 Integer updateReturnVal = null;
   	//Arrange
       Mockito.doReturn(updateReturnVal).when(flightSeatRepository).updateSeat(flightSeat);
       //Act
       Integer retrievedReturnVal = flightSeatServiceSpy.updateSeat(flightSeat);
       //Assert
       assertThat(updateReturnVal, is(equalTo(retrievedReturnVal)));
   }
    
}