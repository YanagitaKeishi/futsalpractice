package com.example.app.domain;

import lombok.Data;

@Data
public class Member {

	private Integer id;
	private String name;
	private Integer tel;
	private String loginId;
	private String loginPass;
}
