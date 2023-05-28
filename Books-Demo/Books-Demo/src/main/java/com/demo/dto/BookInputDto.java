package com.demo.dto;

import lombok.Data;

@Data
public class BookInputDto {
	private Long id;
	private String title;
	private String description;
	private Long author;
	private Long pages;
	private Long price;

}
