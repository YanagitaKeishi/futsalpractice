package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dao.CourtTypeDao;
import com.example.app.dao.TimeZoneDao;
import com.example.app.domain.CourtType;
import com.example.app.domain.TimeZone;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	CourtTypeDao courtTypeDao;
	
	@Autowired
	TimeZoneDao timeZoneDao;
	
	@Override
	public List<CourtType> getCourtType() throws Exception {
		return courtTypeDao.selectAll();
	}

	@Override
	public List<TimeZone> getTimeZone() throws Exception {
		return timeZoneDao.selectAll();
	}

	@Override
	public Integer getCourtId() throws Exception {
		return courtTypeDao.selelctIdAll();
	}

}
