package ar.com.practica2026.ICS6030.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "licencia")
public class Licencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_licencia")
	private Long idLicencia;

	@Column(name = "fecha_solicitud", nullable = false)
	private LocalDate fechaSolicitud;

	@Column(name = "fecha_inicio", nullable = false)
	private LocalDate fechaInicio;

	@Column(name = "fecha_fin", nullable = false)
	private LocalDate fechaFin;

	// "Pendiente" / "Aprobada" / "Rechazada" / "Finalizada"
	@Column(name = "estado", length = 10, nullable = false)
	private String estado = "Pendiente";

	@ManyToOne
	@JoinColumn(name = "id_tipo_licencia", nullable = false)
	private TipoLicencia tipoLicencia;

	@ManyToOne
	@JoinColumn(name = "id_docente", nullable = false)
	private Docente docente;

	public Licencia() {
		super();
	}

	public Licencia(Long idLicencia, LocalDate fechaSolicitud, LocalDate fechaInicio, LocalDate fechaFin, String estado,
			TipoLicencia tipoLicencia, Docente docente) {
		super();
		this.idLicencia = idLicencia;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.tipoLicencia = tipoLicencia;
		this.docente = docente;
	}

	public Long getIdLicencia() {
		return idLicencia;
	}

	public void setIdLicencia(Long idLicencia) {
		this.idLicencia = idLicencia;
	}

	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public TipoLicencia getTipoLicencia() {
		return tipoLicencia;
	}

	public void setTipoLicencia(TipoLicencia tipoLicencia) {
		this.tipoLicencia = tipoLicencia;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

}
