package it.epicode.week4.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import it.epicode.week4.demo.entity.Utente;

public interface UtenteRepo extends JpaRepository<Utente, Integer> {

}
