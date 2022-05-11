package com.example.demo.ServiceInter;

import java.util.Optional;

import com.example.demo.Model.DeviceType;

public interface DeviceTypeService {
	public DeviceType save(DeviceType r);
	public Optional<DeviceType> find(DeviceType r);
	public Iterable<DeviceType> findAll();
	public DeviceType update(DeviceType r);
	public DeviceType delete(DeviceType r);
}
