package com.example.app.domain;

import lombok.Data;

@Data
public class Member {

	public Integer id;
	public String name;
	public Integer tel;
	public String loginId;
	public String loginPass;
	public Integer reservId;
}
