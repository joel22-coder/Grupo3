package ar.com.practica2026.ICS6030.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.practica2026.ICS6030.entity.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {
}
