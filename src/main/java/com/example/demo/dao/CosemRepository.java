package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Cosem;

@Repository
public interface CosemRepository extends JpaRepository<Cosem,Integer> {

	

}
