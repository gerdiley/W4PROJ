package it.epicode.week4.demo.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.week4.demo.entity.Postazione;
import it.epicode.week4.demo.entity.Prenotazione;
import it.epicode.week4.demo.entity.StatoPrenotazione;

@Service
public class PrenotazioneSrv {
	
	@Autowired
	private PrenotazioneRepo prenotazioneRepo;
	
	
	public void insert(Prenotazione p) {
		
		prenotazioneRepo.save(p);
	}
	
	public Optional<Prenotazione> getById(int id) {
		return prenotazioneRepo.findById(id);
	}
	
	public void update(int id) {
        Optional<Prenotazione> pren = this.getById(id);
        if (pren.isPresent() && pren.get().getDataPrenotazione().isAfter(LocalDate.now().plusDays(1))) {
            Prenotazione p = pren.get();
            p.setStatoPrenotazione(StatoPrenotazione.SCADUTA);
            p.getPostazione().setLibero(true);
        }
    }
	
	
	public List<Prenotazione> getAll(){
		return prenotazioneRepo.findAll();
	}
	
	
}
