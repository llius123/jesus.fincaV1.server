package fincaV1.server.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name ="incidencia")
public class IncidenciaBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	private int id;
	
	@Column(name="id_vecino")
	@NotNull
	private int id_vecino;
	
	@Column(name="descripcion")
	@NotNull
	private String descripcion;
	
	@Column(name="fecha_creacion")
	@NotNull
	private Date fecha_creacion;
	
	@Column(name="atendido")
	@NotNull
	private String atendido;
	
	public IncidenciaBean() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_vecino() {
		return id_vecino;
	}

	public void setId_vecino(int id_vecino) {
		this.id_vecino = id_vecino;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getAtendido() {
		return atendido;
	}

	public void setAtendido(String atendido) {
		this.atendido = atendido;
	}

	@Override
	public String toString() {
		return "IncidenciaBean [id=" + id + ", id_vecino=" + id_vecino + ", descripcion=" + descripcion
				+ ", fecha_creacion=" + fecha_creacion + ", atendido=" + atendido + "]";
	}

	
	

}
