package ar.com.practica2026.ICS6030.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.practica2026.ICS6030.entity.Materia;
import ar.com.practica2026.ICS6030.entity.PlanEstudio;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

	List<Materia> findByPlanEstudioOrderByCursoAsc(PlanEstudio planEstudio);

}
