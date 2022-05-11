package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.DeviceType;
import com.example.demo.Model.DeviceVendor;
import com.example.demo.Model.Restrection;
import com.example.demo.Model.RestrectionType;
import com.example.demo.ServiceInter.DeviceTypeService;
import com.example.demo.ServiceInter.DeviceVendorService;
import com.example.demo.ServiceInter.RestrectionService;
import com.example.demo.dao.RestrectionRepository;

@Service
public class RestrectionServiceImp implements RestrectionService {

	@Autowired
	private RestrectionRepository RestrectionRepo;

	  @Autowired 
	private DeviceVendorService deviceVendorService;

	  @Autowired 
	private DeviceTypeService deviceTypeService;
	public RestrectionServiceImp() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RestrectionServiceImp(RestrectionRepository restrectionRepo,DeviceVendorService deviceVendorService,DeviceTypeService deviceTypeService) {
		super();
		RestrectionRepo = restrectionRepo;
		this.deviceTypeService=deviceTypeService;
		this.deviceVendorService=deviceVendorService;
	}
	public Restrection save(Restrection r)
	{
		return RestrectionRepo.save(r);
	}
	public Optional<Restrection> find(Restrection r)
	{
		return RestrectionRepo.findById(r.getId());
	}
	public Iterable<Restrection> findAll()
	{
		return RestrectionRepo.findAll();
	}
	public Restrection update(Restrection r)
	{
		if(RestrectionRepo.existsById(r.getId()))
			return RestrectionRepo.save(r);
		else
			return save(r);
	}
	public Restrection delete(Restrection r)
	{
		RestrectionRepo.delete(r);
		return r;
	}

}