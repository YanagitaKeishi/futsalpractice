package com.example.app.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Plan {

	private Integer id;
	private Date eventAt;
	private String title;
	private PlanType planType;
	private TimeZone startTime;
	private TimeZone endTime;
	private CourtType courtType;//コートの種類
	private Integer maximum;
	private Integer emptyMaximum;
	private Integer price;
	private List<User> users;//予約者リスト
}
