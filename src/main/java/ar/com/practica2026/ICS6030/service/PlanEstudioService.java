package ar.com.practica2026.ICS6030.service;

import java.util.List;

import ar.com.practica2026.ICS6030.entity.PlanEstudio;

public interface PlanEstudioService {

	List<PlanEstudio> listarTodos();

	PlanEstudio buscarPorId(Long id);

	void guardar(PlanEstudio planEstudio);

	void eliminar(Long id);
}
