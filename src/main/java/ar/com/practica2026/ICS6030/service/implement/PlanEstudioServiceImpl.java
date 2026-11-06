package ar.com.practica2026.ICS6030.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.practica2026.ICS6030.entity.PlanEstudio;
import ar.com.practica2026.ICS6030.repository.PlanEstudioRepository;
import ar.com.practica2026.ICS6030.service.PlanEstudioService;

@Service
public class PlanEstudioServiceImpl implements PlanEstudioService{

	
	private final PlanEstudioRepository planEstudioRepository;

	public PlanEstudioServiceImpl(PlanEstudioRepository planEstudioRepository) {
		this.planEstudioRepository = planEstudioRepository;
	}

	@Override
	public List<PlanEstudio> listarTodos() {
		return planEstudioRepository.findAll();
	}

	@Override
	public PlanEstudio buscarPorId(Long id) {
		return planEstudioRepository.findById(id).orElse(null);
	}

	@Override
	public void guardar(PlanEstudio planEstudio) {
		planEstudioRepository.save(planEstudio);
	}

	@Override
	public void eliminar(Long id) {
		planEstudioRepository.deleteById(id);
	}

}
