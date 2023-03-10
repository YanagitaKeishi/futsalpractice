package com.example.app.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Plan {

	public Integer id;
	public Date eventAt;
	public String planType;
	public String timeZone;
	public String courtType;
	public Integer maximum;
	public Integer emptyMaximum;
	public Integer price;
	private List<User> users;//予約者リスト
}
