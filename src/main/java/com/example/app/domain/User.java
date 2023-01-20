package com.example.app.domain;

import lombok.Data;

@Data
public class User {

	private Integer id;
	private String name;
	private String memberId;
	private Integer playerCount;
	private Integer tel;
	private String userType;
}
