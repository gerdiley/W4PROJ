package it.epicode.week4.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.epicode.week4.demo.entity.Postazione;
import it.epicode.week4.demo.entity.TipoPostazione;

@Repository
public interface PostazioneRepo extends JpaRepository<Postazione, Integer> {
	
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM postazione p WHERE p.tipo_postazione = :tp"
		)
		List<Postazione> findByTipoPostazione(@Param("tp") String tipo);
		
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM postazione WHERE postazione.edificio.citta = :c"
			)
	List<Postazione> findByCity(@Param("c") String c);
}
