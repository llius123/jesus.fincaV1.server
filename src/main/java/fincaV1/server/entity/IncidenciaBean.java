package fincaV1.server.entity;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import fincaV1.server.exception.BadBeanFormat;

@Entity
@Table(name = "incidencia")
@SecondaryTables({ @SecondaryTable(name = "vecino", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "id") }) })
public class IncidenciaBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_vecino")
	@NotNull
	private VecinoBean vecino;

	@Column(name = "descripcion")
	@NotNull
	private String descripcion;

	@Column(name = "fecha_creacion")
	@NotNull
	//@Pattern(regexp ="^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")
	private Date fecha_creacion;

	@Column(name = "atendido")
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

	public VecinoBean getVecino() {
		return vecino;
	}

	public void setVecino(VecinoBean vecino) {
		this.vecino = vecino;
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
		return "IncidenciaBean [id=" + id + ", vecino=" + vecino + ", descripcion=" + descripcion + ", fecha_creacion="
				+ fecha_creacion + ", atendido=" + atendido + "]";
	}

}
