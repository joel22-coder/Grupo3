package ar.com.practica2026.ICS6030.repository;
	
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.practica2026.ICS6030.entity.Asistencia;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {

	  // busca todas las asistencias y las ordena por fecha
    List<Asistencia> findAllByOrderByFechaDesc();
    //verifica si un docente ya tiene una asistencia registrada en una fecha determinada.
    boolean existsByDocenteIdDocenteAndFecha(
            Long idDocente, LocalDate fecha);

   
    
}