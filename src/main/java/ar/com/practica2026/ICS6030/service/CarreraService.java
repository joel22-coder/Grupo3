package ar.com.practica2026.ICS6030.service;

import java.util.List;

import ar.com.practica2026.ICS6030.entity.Carrera;

public interface CarreraService {

	List<Carrera> listarTodas();

	Carrera buscarPorId(Long id);

	void guardar(Carrera carrera);

	void eliminar(Long id);
	
}
