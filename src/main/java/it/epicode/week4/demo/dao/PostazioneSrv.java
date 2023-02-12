package it.epicode.week4.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.week4.demo.entity.Postazione;
import it.epicode.week4.demo.entity.Prenotazione;
import it.epicode.week4.demo.entity.TipoPostazione;

@Service
public class PostazioneSrv {

	@Autowired
	private PostazioneRepo postazioneRepo;
	
	public void insert(Postazione p) {
		postazioneRepo.save(p);
	}
	
	public List<Postazione> getPostazioniByType(String tipo){
		return postazioneRepo.findByTipoPostazione(tipo);
	}
	
	public List<Postazione> getAll(){
		return postazioneRepo.findAll();
	}
}
