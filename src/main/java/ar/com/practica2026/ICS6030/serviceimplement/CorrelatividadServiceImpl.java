package ar.com.practica2026.ICS6030.serviceimplement;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.practica2026.ICS6030.entity.Correlatividad;
import ar.com.practica2026.ICS6030.entity.Materia;
import ar.com.practica2026.ICS6030.repository.CorrelatividadRepository;
import ar.com.practica2026.ICS6030.service.CorrelatividadService;

@Service
public class CorrelatividadServiceImpl implements CorrelatividadService {

	private final CorrelatividadRepository correlatividadRepository;

	public CorrelatividadServiceImpl(CorrelatividadRepository correlatividadRepository) {
		super();
		this.correlatividadRepository = correlatividadRepository;
	}

	@Override
	public List<Correlatividad> listarPorMateria(Materia materia) {
		return correlatividadRepository.findByMateria(materia);
	}

	@Override
	public List<Correlatividad> listarPorMaterias(List<Materia> materias) {
		return correlatividadRepository.findByMateriaIn(materias);
	}

	@Override
	public Correlatividad buscarPorId(Long id) {
		return correlatividadRepository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Correlatividad correlatividad) {
		correlatividadRepository.save(correlatividad);
	}

	@Override
	public void eliminar(Long id) {
		correlatividadRepository.deleteById(id);
	}

}
