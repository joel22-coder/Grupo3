package ar.com.practica2026.ICS6030.service;

import java.util.List;

import ar.com.practica2026.ICS6030.entity.Docente;

public interface DocenteService {
	List<Docente> buscar(String texto);

	List<Docente> listarActivos();

	Docente buscarPorId(Long id);

	boolean existeOtroConDni(Docente docente);

	void guardar(Docente docente);

	void cambiarEstado(Long id, String estado);

}
