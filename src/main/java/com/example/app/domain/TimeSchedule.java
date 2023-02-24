package com.example.app.domain;

import lombok.Data;

@Data
public class TimeSchedule {

	private String courtType;
	private Plan [] event;
}
