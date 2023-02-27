package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dao.CourtTypeDao;
import com.example.app.dao.PlanTypeDao;
import com.example.app.dao.TimeZoneDao;
import com.example.app.dao.UserTypeDao;
import com.example.app.domain.CourtType;
import com.example.app.domain.PlanType;
import com.example.app.domain.TimeZone;
import com.example.app.domain.UserType;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	CourtTypeDao courtTypeDao;
	
	@Autowired
	TimeZoneDao timeZoneDao;
	
	@Autowired
	PlanTypeDao planTypeDao;
	
	@Autowired
	UserTypeDao userTypeDao;
	
	@Override
	public List<CourtType> getCourtType() throws Exception {
		return courtTypeDao.selectAll();
	}

	@Override
	public List<TimeZone> getTimeZone() throws Exception {
		return timeZoneDao.selectAll();
	}

	@Override
	public List<Integer> getCourtId() throws Exception {
		return courtTypeDao.selectIdAll();
	}

	@Override
	public List<PlanType> getPlanType() throws Exception {
		return planTypeDao.selectAll();
	}

	@Override
	public List<UserType> getUserType() throws Exception {
		return userTypeDao.selectAll();
	}

	@Override
	public PlanType addCourt(Integer id) throws Exception {
		return planTypeDao.addCourt(id);
	}

	@Override
	public CourtType useCourt(Integer id) throws Exception {
		return courtTypeDao.getCourtType(id);
	}

}
