package ar.com.practica2026.ICS6030.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "plan_estudio")
public class PlanEstudio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_plan")
	private Long idPlan;

	@Column(name = "nombre", length = 40, nullable = false)
	private String nombre;

	@Column(name = "anio", nullable = false)
	private Integer anio;

	@ManyToOne
	@JoinColumn(name = "id_carrera", nullable = false)
	private Carrera carrera;

	// Al eliminar el plan se eliminan sus materias
	@OneToMany(mappedBy = "planEstudio", cascade = CascadeType.REMOVE)
	private List<Materia> materias;

	public PlanEstudio() {
		super();
	}

	public PlanEstudio(Long idPlan, String nombre, Integer anio, Carrera carrera, List<Materia> materias) {
		super();
		this.idPlan = idPlan;
		this.nombre = nombre;
		this.anio = anio;
		this.carrera = carrera;
		this.materias = materias;
	}

	public Long getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(Long idPlan) {
		this.idPlan = idPlan;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

}
