package ar.com.practica2026.ICS6030.serviceimplement;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.practica2026.ICS6030.entity.Carrera;
import ar.com.practica2026.ICS6030.repository.CarreraRepository;
import ar.com.practica2026.ICS6030.service.CarreraService;

@Service
public class CarreraServiceImpl implements CarreraService {

	private final CarreraRepository carreraRepository;

	public CarreraServiceImpl(CarreraRepository carreraRepository) {
		this.carreraRepository = carreraRepository;
	}

	@Override
	public List<Carrera> listarTodas() {
		return carreraRepository.findAll();
	}

	@Override
	public Carrera buscarPorId(Long id) {
		return carreraRepository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Carrera carrera) {
		carreraRepository.save(carrera);
	}

	@Override
	public void eliminar(Long id) {
		carreraRepository.deleteById(id);
	}

}