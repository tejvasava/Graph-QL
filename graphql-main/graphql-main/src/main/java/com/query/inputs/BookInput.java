package com.query.inputs;

import lombok.Data;

@Data
public class BookInput {

	private String title;
	private String description;
	private Long author;
	private Long price;
	private Long pages;

}
