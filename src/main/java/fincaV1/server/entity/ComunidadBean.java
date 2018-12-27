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

@Entity
@Table(name = "comunidad")
@SecondaryTables({
	@SecondaryTable(name = "poblacion", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "cod_postal") }) })
public class ComunidadBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "nif")
	private String nif;
	
	@Column(name = "iban")
	private String iban;
	
	@Column(name = "sufijo")
	private String sufijo;
	
	@ManyToOne
	@JoinColumn(name = "cod_poblacion")
	private PoblacionBean poblacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getSufijo() {
		return sufijo;
	}

	public void setSufijo(String sufijo) {
		this.sufijo = sufijo;
	}

	public PoblacionBean getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(PoblacionBean poblacion) {
		this.poblacion = poblacion;
	}

	@Override
	public String toString() {
		return "ComunidadBean [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", nif=" + nif
				+ ", iban=" + iban + ", sufijo=" + sufijo + ", poblacion=" + poblacion + "]";
	}
	
	

}
