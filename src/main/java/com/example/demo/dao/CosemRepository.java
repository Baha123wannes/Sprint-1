package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Cosem;
import com.example.demo.Model.DataModel;

@Repository
public interface CosemRepository extends JpaRepository<Cosem,Integer> {


	List<Cosem> findByCategory(String cat);

	Cosem findBycategory(String category);

	Cosem findByName(String name);

	

}
