
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
@Table(name = "asistencia")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private Long idAsistencia;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    // Presente / Ausente / Justificado
    @Column(name = "estado", length = 15, nullable = false)
    private String estado;

    @Column(name = "observacion", length = 255)
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "id_docente", nullable = false)
    private Docente docente;

    public Asistencia() {
        super();
    }

    public Asistencia(Long idAsistencia, LocalDate fecha,
            String estado, String observacion, Docente docente) {
        super();
        this.idAsistencia = idAsistencia;
        this.fecha = fecha;
        this.estado = estado;
        this.observacion = observacion;
        this.docente = docente;
    }

    public Long getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(Long idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}
