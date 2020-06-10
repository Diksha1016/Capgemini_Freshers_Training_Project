package com.capgemini.movieticketsystem.dto;

import java.util.List;

import lombok.Data;

@Data
public class BookResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<BookBean> book;
	private BookBean getOneBook;
}
