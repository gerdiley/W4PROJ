package it.epicode.week4.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.week4.demo.entity.Utente;

@Service
public class UtenteSrv {
	
	@Autowired
	UtenteRepo utenteRepo;
	
	public void put(Utente u) {
		try {
			utenteRepo.save(u);
			System.out.println(u);
			System.out.println("Utente registrato con successo");
		} catch (Exception e) {
			System.out.println("Errore salvataggio cliente");
		}
	}
}
