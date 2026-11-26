
package ar.com.practica2026.ICS6030.service;

import java.time.LocalDate;
import java.util.List;

import ar.com.practica2026.ICS6030.entity.Asistencia;

public interface asistenciaservice {

    List<Asistencia> listarTodas();

    Asistencia buscarPorId(Long id);

    Asistencia guardar(Asistencia asistencia);

    boolean existeAsistencia(Long idDocente, LocalDate fecha);

   
}