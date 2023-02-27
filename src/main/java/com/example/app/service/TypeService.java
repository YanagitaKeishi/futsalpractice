package com.example.app.service;

import java.util.List;

import com.example.app.domain.CourtType;
import com.example.app.domain.PlanType;
import com.example.app.domain.TimeZone;
import com.example.app.domain.UserType;

public interface TypeService {

	List<CourtType>getCourtType()throws Exception;
	
	List<TimeZone>getTimeZone()throws Exception;
	
	List<Integer> getCourtId() throws Exception;
	
	List<PlanType> getPlanType() throws Exception;
	
	List<UserType> getUserType() throws Exception;
	
	PlanType addCourt(Integer id) throws Exception;
	
	CourtType useCourt(Integer id) throws Exception;
}
