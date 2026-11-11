package ar.com.practica2026.ICS6030.service;

import java.util.List;

import ar.com.practica2026.ICS6030.entity.Materia;
import ar.com.practica2026.ICS6030.entity.PlanEstudio;

public interface MateriaService {

	List<Materia> listarTodas();

	List<Materia> listarPorPlan(PlanEstudio planEstudio);

	Materia buscarPorId(Long id);

	void guardar(Materia materia);

	void eliminar(Long id);
}