package com.example.demo.ServiceInter;

import java.util.Optional;

import com.example.demo.Model.Restrection;

public interface RestrectionService {
	
	public Restrection save(Restrection r);
	public Optional<Restrection> find(Restrection r);
	public Iterable<Restrection> findAll();
	public Restrection update(Restrection r);
	public Restrection delete(Restrection r);
	

}
