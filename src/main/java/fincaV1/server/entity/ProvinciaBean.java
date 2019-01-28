package fincaV1.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "provincia")
public class ProvinciaBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	private int id;

	@Column(name = "descripcion")
	@NotNull
	private String descripcion;
	
	@Column(name = "cod_provincia")
	@NotNull
	private String cod_provincia;



	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCod_provincia() {
		return cod_provincia;
	}

	public void setCod_provincia(String cod_provincia) {
		this.cod_provincia = cod_provincia;
	}

	@Override
	public String toString() {
		return "ProvinciaBean [id=" + id + ", descripcion=" + descripcion + ", cod_provincia=" + cod_provincia + "]";
	}


}
