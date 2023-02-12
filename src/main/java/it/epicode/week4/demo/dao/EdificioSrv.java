package it.epicode.week4.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.week4.demo.entity.Edificio;

@Service
public class EdificioSrv {
	
	@Autowired
	private EdificioRepo EdificioRepo;
	
	public void insert(Edificio e) {
		EdificioRepo.save(e);
	}
}
