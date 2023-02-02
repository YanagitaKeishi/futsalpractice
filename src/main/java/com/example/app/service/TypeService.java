package com.example.app.service;

import java.util.List;

import com.example.app.domain.CourtType;
import com.example.app.domain.TimeZone;

public interface TypeService {

	List<CourtType>getCourtType()throws Exception;
	
	List<TimeZone>getTimeZone()throws Exception;
	
	Integer getCourtId() throws Exception;
}
