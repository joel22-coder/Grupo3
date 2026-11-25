package ar.com.practica2026.ICS6030.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.practica2026.ICS6030.entity.Horario;
import ar.com.practica2026.ICS6030.entity.Materia;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {

	List<Horario> findByMateria(Materia materia);

	List<Horario> findByMateriaIn(List<Materia> materias);
}