package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.DeviceVendor;
import com.example.demo.ServiceInter.DeviceVendorService;
import com.example.demo.dao.DeviceVendorRepository;

@Service
public class DevicevendorServiceImp implements DeviceVendorService{
	@Autowired
	private DeviceVendorRepository VendorRepo;

	
	public DevicevendorServiceImp() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DevicevendorServiceImp(DeviceVendorRepository vendorRepo) {
		super();
		VendorRepo = vendorRepo;
	}
	public DeviceVendor save(DeviceVendor r)
	{
		return VendorRepo.save(r);
	}
	public Optional<DeviceVendor> find(DeviceVendor r)
	{
		return VendorRepo.findById(r.getId());
	}
	public Iterable<DeviceVendor> findAll()
	{
		return VendorRepo.findAll();
	}
	public DeviceVendor update(DeviceVendor r)
	{
		if(VendorRepo.existsById(r.getId()))
			return VendorRepo.save(r);
		else
			return save(r);
	}
	public DeviceVendor delete(DeviceVendor r)
	{
		VendorRepo.delete(r);
		return r;
	}
}
