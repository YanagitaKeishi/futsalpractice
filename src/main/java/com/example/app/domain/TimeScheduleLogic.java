package com.example.app.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeScheduleLogic {

	
	public TimeSchedule showSchedule(String select, Integer id) throws ParseException {
		//タイムスケジュールのインスタンス生成
		TimeSchedule ts = new TimeSchedule();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date eventAt = dateFormat.parse(select);
		
		//SELECT DISTINCT court_type_id  FROM plans..DISTINCTで重複回避
		

		
		return ts;
	};
}
