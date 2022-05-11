package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.DeviceType;
import com.example.demo.Model.DeviceVendor;
import com.example.demo.ServiceInter.DeviceTypeService;
import com.example.demo.dao.DeviceTypeRepository;
import com.example.demo.dao.DeviceVendorRepository;

@Service
public class DeviceTypeServiceImp implements DeviceTypeService {
	@Autowired
	private DeviceTypeRepository TypeRepo;

	
	public DeviceTypeServiceImp() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DeviceTypeServiceImp(DeviceTypeRepository typeRepo) {
		super();
		TypeRepo = typeRepo;
	}
	public DeviceType save(DeviceType r)
	{
		return TypeRepo.save(r);
	}
	public Optional<DeviceType> find(DeviceType r)
	{
		return TypeRepo.findById(r.getId());
	}
	public Iterable<DeviceType> findAll()
	{
		return TypeRepo.findAll();
	}
	public DeviceType update(DeviceType r)
	{
		if(TypeRepo.existsById(r.getId()))
			return TypeRepo.save(r);
		else
			return save(r);
	}
	public DeviceType delete(DeviceType r)
	{
		TypeRepo.delete(r);
		return r;
	}
}
