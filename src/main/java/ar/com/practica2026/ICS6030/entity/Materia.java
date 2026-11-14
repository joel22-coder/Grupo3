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

	// Código de la materia en el plan de estudio, ej: "1.13"
	@Column(name = "codigo", length = 6, nullable = false)
	private String codigo;

	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;

	@Column(name = "horas_semanales", nullable = false)
	private Integer horasSemanales;

	// Año de la carrera en que se dicta: 1, 2, 3...
	@Column(name = "curso", nullable = false)
	private Integer curso;

	// "Anual" / "1º cuatrimestre" / "2º cuatrimestre"
	@Column(name = "tipo_cursado", length = 15, nullable = false)
	private String tipoCursado = "Anual";

	@ManyToOne
	@JoinColumn(name = "id_plan", nullable = false)
	private PlanEstudio planEstudio;

	public Materia() {
		super();
	}

	public Materia(Long idMateria, String codigo, String nombre, Integer horasSemanales, Integer curso,
			String tipoCursado, PlanEstudio planEstudio) {
		super();
		this.idMateria = idMateria;
		this.codigo = codigo;
		this.nombre = nombre;
		this.horasSemanales = horasSemanales;
		this.curso = curso;
		this.tipoCursado = tipoCursado;
		this.planEstudio = planEstudio;
	}

	public Long getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Long idMateria) {
		this.idMateria = idMateria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public String getTipoCursado() {
		return tipoCursado;
	}

	public void setTipoCursado(String tipoCursado) {
		this.tipoCursado = tipoCursado;
	}

	public PlanEstudio getPlanEstudio() {
		return planEstudio;
	}

	public void setPlanEstudio(PlanEstudio planEstudio) {
		this.planEstudio = planEstudio;
	}

}
