package com.example.app.domain;

import lombok.Data;

@Data
public class TimeSchedule {

	private Integer planId;
	private Integer startId;
	private String [][] event;
}
