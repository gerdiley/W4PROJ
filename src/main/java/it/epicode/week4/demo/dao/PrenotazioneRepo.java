package it.epicode.week4.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.epicode.week4.demo.entity.Postazione;
import it.epicode.week4.demo.entity.Prenotazione;

@Repository
public interface PrenotazioneRepo extends JpaRepository<Prenotazione, Integer> {
	
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM postazione p WHERE p.tipo_postazione = :t"
		)
		List<Postazione> findByTipoPostazione(@Param("t") String t);
		

	
}
