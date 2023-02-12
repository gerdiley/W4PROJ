package it.epicode.week4.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.week4.demo.entity.Edificio;


public interface EdificioRepo extends JpaRepository<Edificio, Integer>  {
	
}
