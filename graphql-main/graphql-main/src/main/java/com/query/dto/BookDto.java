package com.query.dto;

import lombok.Data;

@Data
public class BookDto {

	private Long id;
	private String title;
	private String description;
	private Long pages;
	private Long price;
	private AuthorDto author;

}
