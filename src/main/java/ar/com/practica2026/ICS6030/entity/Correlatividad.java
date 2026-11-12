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
@Table(name = "correlatividad")
public class Correlatividad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_correlatividad")
	private Long idCorrelatividad;
	// materia que tiene la correlativa (ej: 1.14 Matemática II)
	@ManyToOne
	@JoinColumn(name = "id_materia", nullable = false)
	private Materia materia;

	// su correlativa (ej: 1.13 Matemática I)
	@ManyToOne
	@JoinColumn(name = "id_correlativa", nullable = false)
	private Materia correlativa;

	public Correlatividad() {
		super();
	}

	public Correlatividad(Long idCorrelatividad, Materia materia, Materia correlativa) {
		super();
		this.idCorrelatividad = idCorrelatividad;
		this.materia = materia;
		this.correlativa = correlativa;
	}

	public Long getIdCorrelatividad() {
		return idCorrelatividad;
	}

	public void setIdCorrelatividad(Long idCorrelatividad) {
		this.idCorrelatividad = idCorrelatividad;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Materia getCorrelativa() {
		return correlativa;
	}

	public void setCorrelativa(Materia correlativa) {
		this.correlativa = correlativa;
	}

}
