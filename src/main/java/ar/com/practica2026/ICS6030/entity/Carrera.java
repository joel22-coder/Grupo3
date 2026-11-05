package ar.com.practica2026.ICS6030.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrera")
public class Carrera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_carrera")
	private Long idCarrera;

	@Column(name = "nombre", length = 40, nullable = false)
	private String nombre;

	@Column(name = "duracion", nullable = false)
	private Integer duracion;

	public Carrera() {
		super();
	}

	public Carrera(Long idCarrera, String nombre, Integer duracion) {
		super();
		this.idCarrera = idCarrera;
		this.nombre = nombre;
		this.duracion = duracion;
	}

	public Long getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(Long idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

 
	
}
