package ar.com.practica2026.ICS6030.serviceimplement;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.practica2026.ICS6030.entity.Materia;
import ar.com.practica2026.ICS6030.entity.PlanEstudio;
import ar.com.practica2026.ICS6030.repository.MateriaRepository;
import ar.com.practica2026.ICS6030.service.MateriaService;

@Service
public class MateriaServiceImpl implements MateriaService {

	private final MateriaRepository materiaRepository;

	public MateriaServiceImpl(MateriaRepository materiaRepository) {
		this.materiaRepository = materiaRepository;
	}

	@Override
	public List<Materia> listarTodas() {
		return materiaRepository.findAll();
	}

	@Override
	public List<Materia> listarPorPlan(PlanEstudio planEstudio) {
		return materiaRepository.findByPlanEstudioOrderByCursoAsc(planEstudio);
	}

	@Override
	public Materia buscarPorId(Long id) {
		return materiaRepository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Materia materia) {
		materiaRepository.save(materia);
	}

	@Override
	public void eliminar(Long id) {
		materiaRepository.deleteById(id);
	}
}