package ar.com.practica2026.ICS6030.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.practica2026.ICS6030.entity.Correlatividad;
import ar.com.practica2026.ICS6030.entity.Materia;

@Repository
public interface CorrelatividadRepository extends JpaRepository<Correlatividad, Long> {

	List<Correlatividad> findByMateria(Materia materia);

	List<Correlatividad> findByMateriaIn(List<Materia> materias);
}