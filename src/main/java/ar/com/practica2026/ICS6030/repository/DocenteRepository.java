package ar.com.practica2026.ICS6030.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.practica2026.ICS6030.entity.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {

	// Buscar docente por DNI
	List<Docente> findByDni(Integer dni);

	// Buscar docentes por estado
	List<Docente> findByEstado(String estado);

	// Buscar por apellido o nombre sin importar mayúsculas
	List<Docente> findByApellidoContainingIgnoreCaseOrNombreContainingIgnoreCase(String apellido, String nombre);

}