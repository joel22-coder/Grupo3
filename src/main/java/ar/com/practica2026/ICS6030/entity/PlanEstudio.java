package ar.com.practica2026.ICS6030.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	public PlanEstudio() {
		super();
	}

	public PlanEstudio(Long idPlan, String nombre, Integer anio) {
		super();
		this.idPlan = idPlan;
		this.nombre = nombre;
		this.anio = anio;
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
	
	
	
}
