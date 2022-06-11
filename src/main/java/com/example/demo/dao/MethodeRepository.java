package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.DlmsMethode;

@Repository
public interface MethodeRepository extends JpaRepository<DlmsMethode,Integer>{

	DlmsMethode findByName(String name);

}
