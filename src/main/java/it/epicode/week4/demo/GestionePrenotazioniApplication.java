package it.epicode.week4.demo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import it.epicode.week4.demo.config.PrenotazioneConfig;
import it.epicode.week4.demo.dao.EdificioSrv;
import it.epicode.week4.demo.dao.PostazioneSrv;
import it.epicode.week4.demo.dao.PrenotazioneSrv;
import it.epicode.week4.demo.dao.UtenteRepo;
import it.epicode.week4.demo.dao.UtenteSrv;
import it.epicode.week4.demo.entity.Edificio;
import it.epicode.week4.demo.entity.Postazione;
import it.epicode.week4.demo.entity.Prenotazione;
import it.epicode.week4.demo.entity.TipoPostazione;
import it.epicode.week4.demo.entity.Utente;

@SpringBootApplication
public class GestionePrenotazioniApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GestionePrenotazioniApplication.class, args);
	}
	
	@Autowired
	PrenotazioneSrv ps;
	@Autowired
	PostazioneSrv pos;
	@Autowired
	UtenteSrv us;
	
	@Autowired
	EdificioSrv es;
	
	ApplicationContext ctx = new AnnotationConfigApplicationContext(PrenotazioneConfig.class);

	@Override
	public void run(String... args) throws Exception {
		
		
		// --------CREO EDIFICIO---------
		Edificio e1 = (Edificio)ctx.getBean("ed1");
		
		es.insert(e1);
		
		// --------CREO POSTAZIONI-------
		
		Postazione p1 = (Postazione)ctx.getBean("post1", e1);
		insertPostazione(p1);
		Postazione p2 = (Postazione)ctx.getBean("post2", e1);
		insertPostazione(p2);
		Postazione p3 = (Postazione)ctx.getBean("post3", e1);
		insertPostazione(p3);
		
		
		
		
		
		// --------CREO UTENTE-------
		
		Utente u = new Utente().builder().fullName("Gerardo Di Letizia").email("gerardo@gmail.com").build();
		
		us.put(u);
		
		
		// --------CREO Prenotazione-------
		
		insertPrenotazione(u, p1, LocalDate.now());
	
	
	
//		getPrenotazioneById(1);
//		getByType("OPENSPACE");
//		getByCity("Roma");
		
		
		
		((AnnotationConfigApplicationContext)ctx).close();
		
	}
	

	
	public void insertPostazione(Postazione p) {
		pos.insert(p);
	}
	
	public void insertPrenotazione(Utente u, Postazione p, LocalDate data) {
		Prenotazione pr = new Prenotazione().builder().utente(u).postazione(p).dataPrenotazione(data).build();
		ps.insert(pr);
	}
	
	public void getPrenotazioneById(int id) {
		Optional<Prenotazione> pren = ps.getById(id);
		if(pren.isPresent()) {
		Prenotazione prenotazione = pren.get(); 
		System.out.println(prenotazione);
		} else
		{System.out.println("Non trovato");}
	}
	
	public void updateAll(){
		ps.getAll().forEach(prenotazione -> {
			int id = prenotazione.getId();
			ps.update(id);
		});
	}
	
	public void getByType(String tipo) {
		List<Postazione> post = pos.getPostazioniByType(tipo);
		post.forEach(p->{System.out.println(p);});
	}
	
	public void getByCity(String citta) {
		List<Postazione> post = pos.getAll().stream().filter(p->p.getEdificio().getCitta().contains(citta)).toList();
		post.stream().forEach(p->{System.out.println(p);});
	}
}
