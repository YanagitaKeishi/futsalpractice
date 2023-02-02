package com.example.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.TimeZone;

@Mapper
public interface TimeZoneDao {

	List<TimeZone>selectAll() throws Exception;
}
