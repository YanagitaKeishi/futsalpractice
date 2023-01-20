package com.example.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Reserv;

@Mapper
public interface ReservDao {

	List<Reserv>selectAll() throws Exception;
}
