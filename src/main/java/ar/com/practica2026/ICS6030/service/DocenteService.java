package ar.com.practica2026.ICS6030.service;

import java.util.List;

import ar.com.practica2026.ICS6030.entity.Docente;

public interface DocenteService {
	List<Docente> listarTodos();

	Docente buscarPorId(Long id);

	void guardar(Docente docente);

	void eliminar(Long id);

}
