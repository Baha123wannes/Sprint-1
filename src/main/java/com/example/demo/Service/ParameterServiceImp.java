package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Parameter;
import com.example.demo.dao.ParameterRepository;

@Service
public class ParameterServiceImp {
	@Autowired
	ParameterRepository ParameterRepo;

	public ParameterServiceImp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParameterServiceImp(ParameterRepository parameterRepo) {
		super();
		ParameterRepo = parameterRepo;
	}

	public ParameterRepository getParameterRepo() {
		return ParameterRepo;
	}

	public void setParameterRepo(ParameterRepository parameterRepo) {
		ParameterRepo = parameterRepo;
	}
	public Parameter save(Parameter p)
	{
		ParameterRepo.save(p);
		return p;
	}
	public Optional<Parameter> find(Parameter p)
	{
		return ParameterRepo.findById(p.getId());
		
	}
	public Iterable<Parameter> findAll()
	{
		return ParameterRepo.findAll();
	}
	public Parameter update(Parameter p)
	{
		return ParameterRepo.save(p);
	}
	public Parameter delete(Parameter p)
	{
		ParameterRepo.delete(p);
		return p;
	}
}
