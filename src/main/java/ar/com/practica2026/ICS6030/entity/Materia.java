package ar.com.practica2026.ICS6030.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_materia")
	private Long idMateria;

	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;

	@Column(name = "horas_semanales", nullable = false)
	private Integer horasSemanales;

	@ManyToOne
	@JoinColumn(name = "id_carrera", nullable = false)
	private Carrera carrera;

	public Materia() {
		super();
	}

	public Materia(Long idMateria, String nombre, Integer horasSemanales, Carrera carrera) {
		super();
		this.idMateria = idMateria;
		this.nombre = nombre;
		this.horasSemanales = horasSemanales;
		this.carrera = carrera;
	}

	public Long getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Long idMateria) {
		this.idMateria = idMateria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getHorasSemanales() {
		return horasSemanales;
	}

	public void setHorasSemanales(Integer horasSemanales) {
		this.horasSemanales = horasSemanales;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	
	
}
