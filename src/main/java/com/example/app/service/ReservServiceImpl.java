package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dao.ReservDao;
import com.example.app.domain.Reserv;

@Service
public class ReservServiceImpl implements ReservService {

	@Autowired
	ReservDao reservDao;
	
	@Override
	public List<Reserv> getReservList() throws Exception {
		return reservDao.selectAll();
	}

}
