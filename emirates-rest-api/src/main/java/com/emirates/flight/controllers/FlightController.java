package com.emirates.flight.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.flight.domain.FlightSeat;
import com.emirates.flight.domain.SeatMap;
import com.emirates.flight.services.FlightSeatService;
import com.emirates.flight.services.SeatMapService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author divyang.patel
 * The Class FlightController.
 */
@RestController
@RequestMapping("/flight/seat")
@Api(value="FlightSeat", description ="Operations pertaining to create or change flight seat on given date and check seat avialability")
public class FlightController {

    private FlightSeatService flightSeatService;
    private SeatMapService seatMapService;

    /**
     * Sets the flightSeat service.
     *
     * @param flightSeatService the new flightSeat service
     */
    @Autowired
    public void setFlightSeatService(FlightSeatService flightSeatService) {
        this.flightSeatService = flightSeatService;
    }
    
    /**
     * Sets the seatMap service.
     *
     * @param seatMapService the new seatMap service
     */
    @Autowired
    public void setSeatMapService(SeatMapService seatMapService) {
        this.seatMapService = seatMapService;
    }

    /**
     * List.
     *
     * @param model the model
     * @param date the date
     * @return the response entity
     */
    @ApiOperation(value = "View a list of available seat, create and change the seat.",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    
    /**
     * list available seat.
     * 
     * @param Date the date
     * @return the response entity
     */
    @RequestMapping(value = "/available-list/{date}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Map<String, Object>> availableSeatList(Model model, @PathVariable @DateTimeFormat(pattern="dd-MM-yyyy") Date date){
    	Map<String, Object> message = new HashMap<String, Object>();
    	Map<String, Object> json = new HashMap<String, Object>();
    	HttpStatus responseStatus = HttpStatus.OK;
    	try{
    		//get all available seats
    		List<String> availableSeatList = flightSeatService.getAvailableSeatList(date);
        	String[] availableSeatArray = availableSeatList.toArray(new String[availableSeatList.size()]);
            
        	//set response messages
        	message.put("code", 200);
            message.put("summary", "available seats retrieved successfully");
            message.put("seatMaps", availableSeatArray);
            json.put("success", true);
            json.put("message", message);
    	}catch(Exception e){
    		
    		//set response messages
    		message.put("code", 500);
    		message.put("summary", "Error while fetching available seatMap on date: " + date);
            json.put("error", true);
            json.put("message", message);
            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    	}
        
        return (new ResponseEntity<Map<String, Object>>(json, responseStatus));
    }
    
    /**
     * list booked seatMaps.
     *
     * @param model the model
     * @param date the date
     * @return the response entity
     */
    @RequestMapping(value = "/booked-list/{date}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Map<String, Object>> bookedSeatList(Model model, @PathVariable @DateTimeFormat(pattern="dd-MM-yyyy") Date date){
    	Map<String, Object> message = new HashMap<String, Object>();
    	Map<String, Object> json = new HashMap<String, Object>();
    	HttpStatus responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    	try{
    		//get all booked seats
    		List<String> bookedSeatList = flightSeatService.getBookedSeatList(date);
        	String[] bookedSeatArray = bookedSeatList.toArray(new String[bookedSeatList.size()]);
            
        	//set response messages
        	message.put("code", 200);
            message.put("summary", "Booked seats retrieved successfully");
            message.put("seatMaps", bookedSeatArray);
            json.put("success", true);
            json.put("message", message);
            responseStatus = HttpStatus.OK;
    	}catch(Exception e){
    		//set response messages
    		message.put("code", 500);
    		message.put("summary", "Error while fetching booked seats on date: " + date);
            json.put("error", true);
            json.put("message", message);
    	}
        
        return (new ResponseEntity<Map<String, Object>>(json, responseStatus));
    }
    
    /**
     * Create a seat.
     *
     * @param flightSeat the flightSeat
     * @return the response entity
     */
    @ApiOperation(value = "Create seat")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Map<String, Object>> CreateSeat(@RequestBody FlightSeat flightSeat){
    	ResponseEntity<Map<String, Object>> response = createSeat(flightSeat);
    	return response;
    }

    /**
     * Change a seat.
     *
     * @param passengerId the passenger id
     * @param flightSeat the flightSeat
     * @return the response entity
     */
    @ApiOperation(value = "Change seat")
    @RequestMapping(value = "/change/{passengerId}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<Map<String, Object>> ChangeSeat(@PathVariable String passengerId, @RequestBody FlightSeat flightSeat){
    	ResponseEntity<Map<String, Object>> response = changeSeat(flightSeat, passengerId);
    	return response;
    }
    /**
     * Create seat.
     *
     * @param flightSeat the flightSeat
     * @return the response entity
     */
    private ResponseEntity<Map<String,Object>> createSeat(FlightSeat flightSeat){
    	
    	Map<String, Object> message = new HashMap<String, Object>();
    	Map<String, Object> flightSeatDetail = new HashMap<String, Object>();
    	Map<String, Object> json = new HashMap<String, Object>();
    	HttpStatus responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    	
    	if(flightSeat.getSeatId() < 1 || flightSeat.getSeatId() > 100){
    		//set response messages
    		message.put("summary", "Please select seat from 1 to 100");
            message.put("code", 500);
            json.put("error", true);
            json.put("message", message);
    	}else{
    		//create seat 
    		int id = flightSeatService.saveSeat(flightSeat);
        	if(id > 0){
        		
        		//set response messages
        		message.put("summary", "Flight seat booked successfully.");
                message.put("code", 201);
                SeatMap seatMap = seatMapService.find(flightSeat.getSeatId()); 
                flightSeatDetail.put("passengerId", flightSeat.getPassengerId());
                flightSeatDetail.put("passengerName", flightSeat.getPassengerName());
                flightSeatDetail.put("passengerEmail", flightSeat.getPassengerEmail());
                flightSeatDetail.put("seat", seatMap.getName());
                json.put("success", true);
                json.put("message", message);
                json.put("passenger_detail", flightSeatDetail);
                responseStatus = HttpStatus.CREATED;
        	}else if(id == -1){
        		
        		//set response messages
        		message.put("summary", "Flight seat already booked by someone.Please select another seat.");
                message.put("code", 500);
                json.put("error", true);
                json.put("message", message);
        	}
    	}
        return (new ResponseEntity<Map<String, Object>>(json, responseStatus));
    }
    
    /**
     * Change seat.
     *
     * @param flightSeat the flightSeat
     * @param passengerId the passenger id
     * @return the response entity
     */
    private ResponseEntity<Map<String, Object>> changeSeat(FlightSeat flightSeat, String passengerId){
    	Map<String, Object> message = new HashMap<String, Object>();
    	Map<String, Object> flightSeatDetail = new HashMap<String, Object>();
    	Map<String, Object> json = new HashMap<String, Object>();
    	HttpStatus responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    	
    	//get booked seat using passengerId
    	FlightSeat bookedFlight = flightSeatService.getSeatByPassengerId(passengerId);
        if(bookedFlight == null){
        	//set response messages
        	message.put("summary", "No booking seat found for passengerId::" + passengerId);
            message.put("code", 500);
            json.put("error", true);
            json.put("message", message);
            return (new ResponseEntity<Map<String, Object>>(json, responseStatus));
        }
        if(bookedFlight.getSeatId() == flightSeat.getSeatId()){
        	//set response messages
        	message.put("summary", "Seat no is same as previous selected seat.Please select another seat.");
            message.put("code", 500);
            json.put("error", true);
            json.put("message", message);
            return (new ResponseEntity<Map<String, Object>>(json, responseStatus));
        }
        
        if(flightSeat.getSeatId() < 1 || flightSeat.getSeatId() > 100){
        	//set response messages
        	message.put("summary", "Please select seat from 1 to 100");
            message.put("code", 500);
            json.put("error", true);
            json.put("message", message);
    	}else{
    		//change the seat with seat id in object
    		bookedFlight.setSeatId(flightSeat.getSeatId());
            bookedFlight.setModifiedDate(new Date());
    		
            //update the seat
            int id = flightSeatService.updateSeat(bookedFlight);
        	
    		if(id > 0){
    			//set response messages
        		message.put("summary", "Flight booking seat changed successfully.");
                message.put("code", 200);
                SeatMap seatMap = seatMapService.find(bookedFlight.getSeatId()); 
                flightSeatDetail.put("passengerId", bookedFlight.getPassengerId());
                flightSeatDetail.put("passengerName", bookedFlight.getPassengerName());
                flightSeatDetail.put("passengerEmail", bookedFlight.getPassengerEmail());
                flightSeatDetail.put("seat", seatMap.getName());
                json.put("success", true);
                json.put("message", message);
                json.put("passenger_detail", flightSeatDetail);
                responseStatus = HttpStatus.OK;
        	}else if(id == -1){
        		//set response messages
        		message.put("summary", "Flight seat already booked by someone.Please select another seat.");
                message.put("code", 500);
                json.put("error", true);
                json.put("message", message);
        	}
    	}
        return (new ResponseEntity<Map<String, Object>>(json, responseStatus));
    }
   
}
