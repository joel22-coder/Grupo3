package ar.com.practica2026.ICS6030.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_licencia")
public class TipoLicencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo")
	private Long idTipo;

	@Column(name = "descripcion", length = 150, nullable = false)
	private String descripcion;

	@Column(name = "dias_maximos", nullable = false)
	private Integer diasMaximos;

	// Valores posibles: "Sí" / "No"
	@Column(name = "requiere_certificado", length = 2, nullable = false)
	private String requiereCertificado = "No";

	public TipoLicencia() {
		super();
	}

	public TipoLicencia(Long idTipo, String descripcion, Integer diasMaximos, String requiereCertificado) {
		super();
		this.idTipo = idTipo;
		this.descripcion = descripcion;
		this.diasMaximos = diasMaximos;
		this.requiereCertificado = requiereCertificado;
	}

	public Long getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getDiasMaximos() {
		return diasMaximos;
	}

	public void setDiasMaximos(Integer diasMaximos) {
		this.diasMaximos = diasMaximos;
	}

	public String getRequiereCertificado() {
		return requiereCertificado;
	}

	public void setRequiereCertificado(String requiereCertificado) {
		this.requiereCertificado = requiereCertificado;
	}
	
	
	
}
