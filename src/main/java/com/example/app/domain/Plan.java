package com.example.app.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Plan {

	private Integer id;
	private Date eventAt;
	private PlanType planType;
	private String timeZone;
	private CourtType courtType;
	private Integer maximum;
	private Integer emptyMaximum;
	private Integer price;
	private List<User> users;//予約者リスト
}
