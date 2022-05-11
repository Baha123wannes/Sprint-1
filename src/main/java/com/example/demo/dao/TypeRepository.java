package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.DlmsType;

@Repository 
public interface TypeRepository  extends JpaRepository<DlmsType,Integer>{
	

}
