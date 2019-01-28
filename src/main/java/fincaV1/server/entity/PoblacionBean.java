package fincaV1.server.entity;

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

@Entity
@Table(name ="poblacion")
@SecondaryTables({
	@SecondaryTable(name = "provincia", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "id") }) })
public class PoblacionBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	private int id;
	
	@Column(name = "cod_postal")
	@NotNull
	private int cod_postal;
	
	@Column(name="descripcion")
	@NotNull
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="cod_provincia")
	@NotNull
	private ProvinciaBean cod_provincia;

	public int getCod_postal() {
		return cod_postal;
	}

	public void setCod_postal(int cod_postal) {
		this.cod_postal = cod_postal;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ProvinciaBean getCod_provincia() {
		return cod_provincia;
	}

	public void setCod_provincia(ProvinciaBean cod_provincia) {
		this.cod_provincia = cod_provincia;
	}

	@Override
	public String toString() {
		return "PoblacionBean [cod_postal=" + cod_postal + ", descripcion=" + descripcion + ", cod_provincia="
				+ cod_provincia + "]";
	}

}
