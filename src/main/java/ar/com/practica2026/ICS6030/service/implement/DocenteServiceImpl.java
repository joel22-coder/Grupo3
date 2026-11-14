package ar.com.practica2026.ICS6030.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.practica2026.ICS6030.entity.Docente;
import ar.com.practica2026.ICS6030.repository.DocenteRepository;
import ar.com.practica2026.ICS6030.service.DocenteService;

@Service
public class DocenteServiceImpl implements DocenteService {
	private final DocenteRepository docenteRepository;
	List<Docente> docentes = new ArrayList<>();

	public DocenteServiceImpl(DocenteRepository docenteRepository) {
		this.docenteRepository = docenteRepository;
	}

	@Override
	public List<Docente> listarTodos() {

		return docentes;
	}

	@Override
	public Docente buscarPorId(Long id) {

		return docenteRepository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Docente docente) {
		docenteRepository.save(docente);

	}

	@Override
	public void eliminar(Long id) {
		docenteRepository.deleteById(id);

	}

}
