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
@Table(name = "proveedor")
@SecondaryTables({
	@SecondaryTable(name = "poblacion", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "cod_postal") }) })
public class ProveedorBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "email")
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "cod_poblacion")
	private PoblacionBean poblacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PoblacionBean getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(PoblacionBean poblacion) {
		this.poblacion = poblacion;
	}

	@Override
	public String toString() {
		return "ProveedorBean [id=" + id + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email
				+ ", poblacion=" + poblacion + "]";
	}
	
	
}
