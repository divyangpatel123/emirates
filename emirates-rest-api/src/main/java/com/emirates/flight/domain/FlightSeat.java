package com.emirates.flight.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author divyang.patel
 * The Class FlightSeat.
 */
@Entity
@Table(name = "flight_seat")
public class FlightSeat {
	
	/** The id. */
	@JsonIgnoreProperties("id")
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated ID")
    private Integer id;
	
	/** The seat id. */
	@Column(name = "seatId", nullable = false)
    @ApiModelProperty(notes = "Seat")
    private Long seatId;
	
    /** The passenger id. */
    @Column(name = "passengerId", nullable = false)
    @ApiModelProperty(notes = "Passenger ID")
    private String passengerId;
    
    /** The passenger name. */
    @Column(name = "passengerName", nullable = false)
    @ApiModelProperty(notes = "Passenger name")
    private String passengerName;
    
    /** The passenger email. */
    @Column(name = "passengerEmail", nullable = false)
    @ApiModelProperty(notes = "Passenger email")
    private String passengerEmail;
    
    /** The passenger mobile. */
    @Column(name = "passengerMobile", nullable = false)
    @ApiModelProperty(notes = "Passenger mobile")
    private String passengerMobile;

    /** The departure date. */
    @Column(name = "departureDate", nullable = false)
    @ApiModelProperty(notes = "Departure date")
    private Date departureDate;
    
    /** The created date. */
    @JsonIgnoreProperties("createdDate")
    @Column(name = "createdDate", nullable = false)
    @ApiModelProperty(notes = "created date")
    private Date createdDate;
    
    /** The modified date. */
    @JsonIgnoreProperties("modifiedDate")
    @Column(name = "modifiedDate", nullable = false)
    @ApiModelProperty(notes = "modified date")
    private Date modifiedDate;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the seat id.
	 *
	 * @return the seat id
	 */
	public Long getSeatId() {
		return seatId;
	}

	/**
	 * Sets the seat id.
	 *
	 * @param seatId the new seat id
	 */
	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	/**
	 * Gets the passenger id.
	 *
	 * @return the passenger id
	 */
	public String getPassengerId() {
		return passengerId;
	}

	/**
	 * Sets the passenger id.
	 *
	 * @param passengerId the new passenger id
	 */
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	/**
	 * Gets the passenger name.
	 *
	 * @return the passenger name
	 */
	public String getPassengerName() {
		return passengerName;
	}

	/**
	 * Sets the passenger name.
	 *
	 * @param passengerName the new passenger name
	 */
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	/**
	 * Gets the passenger email.
	 *
	 * @return the passenger email
	 */
	public String getPassengerEmail() {
		return passengerEmail;
	}

	/**
	 * Sets the passenger email.
	 *
	 * @param passengerEmail the new passenger email
	 */
	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}

	/**
	 * Gets the passenger mobile.
	 *
	 * @return the passenger mobile
	 */
	public String getPassengerMobile() {
		return passengerMobile;
	}

	/**
	 * Sets the passenger mobile.
	 *
	 * @param passengerMobile the new passenger mobile
	 */
	public void setPassengerMobile(String passengerMobile) {
		this.passengerMobile = passengerMobile;
	}

	/**
	 * Gets the departure date.
	 *
	 * @return the departure date
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * Sets the departure date.
	 *
	 * @param departureDate the new departure date
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the modified date.
	 *
	 * @return the modified date
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * Sets the modified date.
	 *
	 * @param modifiedDate the new modified date
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
    
}
