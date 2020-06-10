package com.capgemini.movieticketsystem.dto;

import java.util.List;

import lombok.Data;

@Data
public class TheaterResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<TheaterBean> theater;
	private UserBean getOneTheater;
}
