package com.example.app.domain;

import lombok.Data;

@Data
public class ReservForm {

	private Integer id;
	private User user;
	private Plan plan;
}
