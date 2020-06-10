package com.capgemini.movieticketsystem.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "theater_det")
public class TheaterBean {
	@Id
	@Column
private int theaterId;
	@Column
private String theaterName;
	@Column
private String theaterCity;
	@Column
	private int noOfScreens;
}
