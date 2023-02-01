package com.example.app.domain;

import java.util.Date;

import lombok.Data;

@Data
public class TimeSchedule {

	private Date date;
	private String court;
	private String [] schedule;
	private Integer [] planId;
}
