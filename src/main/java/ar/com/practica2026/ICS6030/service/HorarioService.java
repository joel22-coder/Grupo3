package ar.com.practica2026.ICS6030.service;

import java.util.List;

import ar.com.practica2026.ICS6030.entity.Horario;
import ar.com.practica2026.ICS6030.entity.Materia;

public interface HorarioService {

	List<Horario> listarTodos();

	List<Horario> listarPorMateria(Materia materia);

	List<Horario> listarPorMaterias(List<Materia> materias);

	Horario buscarPorId(Long id);

	void guardar(Horario horario);

	void eliminar(Long id);
}