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
	@Column(name = "cod_provincia")
	@NotNull
	private int cod_provincia;

	@Column(name = "descripcion")
	@NotNull
	private String descripcion;

	public int getCod_provincia() {
		return cod_provincia;
	}

	public void setCod_provincia(int cod_provincia) {
		this.cod_provincia = cod_provincia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "ProvinciaBean [cod_provincia=" + cod_provincia + ", descripcion=" + descripcion + "]";
	}

}
