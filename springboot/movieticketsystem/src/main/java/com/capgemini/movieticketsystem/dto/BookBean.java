package com.capgemini.movieticketsystem.dto;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "book_det")
public class BookBean {
	@Id
	@Column
    @GeneratedValue
	private int bookId;
	@Column
	private int userId;
	@Column
	private int theaterId;
	@Column
	private String movieName;
	@Column
	private String screen;
	@Column
	private LocalDate bookingDate; 
	@Column
	private String showTime; 
	@Column
	private double totalCost; 
	@Column
	private int noOfSeats;
    
}

