package com.example.app.domain;

import lombok.Data;

@Data
public class User {

	//予約者情報
	private Integer id;
	private String name;
	private String memberId;
	private String tel;
	private UserType userType;
	private Plan planId;
}
