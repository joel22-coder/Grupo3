package ar.com.practica2026.ICS6030.serviceimplement;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.practica2026.ICS6030.entity.Horario;
import ar.com.practica2026.ICS6030.entity.Materia;
import ar.com.practica2026.ICS6030.repository.HorarioRepository;
import ar.com.practica2026.ICS6030.service.HorarioService;

@Service
public class HorarioServiceImpl implements HorarioService {

	private final HorarioRepository horarioRepository;

	public HorarioServiceImpl(HorarioRepository horarioRepository) {
		this.horarioRepository = horarioRepository;
	}

	@Override
	public List<Horario> listarTodos() {
		return horarioRepository.findAll();
	}

	@Override
	public List<Horario> listarPorMateria(Materia materia) {
		return horarioRepository.findByMateria(materia);
	}

	@Override
	public List<Horario> listarPorMaterias(List<Materia> materias) {
		return horarioRepository.findByMateriaIn(materias);
	}

	@Override
	public Horario buscarPorId(Long id) {
		return horarioRepository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Horario horario) {
		horarioRepository.save(horario);
	}

	@Override
	public void eliminar(Long id) {
		horarioRepository.deleteById(id);
	}
}