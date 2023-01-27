package com.example.app.domain;

import lombok.Data;

@Data
public class MyCalendar {

	private Integer year;
	private Integer month;
	private String [][] data;
}
