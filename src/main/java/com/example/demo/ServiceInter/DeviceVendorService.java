package com.example.demo.ServiceInter;

import java.util.Optional;

import com.example.demo.Model.DeviceVendor;

public interface DeviceVendorService {
	public DeviceVendor save(DeviceVendor r);
	public Optional<DeviceVendor> find(DeviceVendor r);
	public Iterable<DeviceVendor> findAll();
	public DeviceVendor update(DeviceVendor r);
	public DeviceVendor delete(DeviceVendor r);
}
