package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.DeviceType;

public interface DeviceTypeRepository extends JpaRepository<DeviceType,Integer> {

}
