package ar.com.practica2026.ICS6030.serviceimplement;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.practica2026.ICS6030.entity.Asistencia;
import ar.com.practica2026.ICS6030.repository.AsistenciaRepository;
import ar.com.practica2026.ICS6030.service.asistenciaservice;

@Service
public class AsistenciaServiceImpl implements asistenciaservice{

    private final AsistenciaRepository asistenciaRepository;

    public AsistenciaServiceImpl(
            AsistenciaRepository asistenciaRepository) {
        this.asistenciaRepository = asistenciaRepository;
    }

    @Override
    public List<Asistencia> listarTodas() {
        return asistenciaRepository.findAllByOrderByFechaDesc();
    }

    @Override
    public Asistencia buscarPorId(Long id) {
        return asistenciaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Asistencia no encontrada: " + id));
    }

    @Override
    public Asistencia guardar(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    @Override
    public boolean existeAsistencia(Long idDocente, LocalDate fecha) {
        return asistenciaRepository
                .existsByDocenteIdDocenteAndFecha(idDocente, fecha);
    }

  
    }

