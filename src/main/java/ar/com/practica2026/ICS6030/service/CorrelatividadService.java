package ar.com.practica2026.ICS6030.service;

import java.util.List;

import ar.com.practica2026.ICS6030.entity.Correlatividad;
import ar.com.practica2026.ICS6030.entity.Materia;

public interface CorrelatividadService {

	List<Correlatividad> listarPorMateria(Materia materia);

	List<Correlatividad> listarPorMaterias(List<Materia> materias);

	Correlatividad buscarPorId(Long id);

	void guardar(Correlatividad correlatividad);

	void eliminar(Long id);

}
