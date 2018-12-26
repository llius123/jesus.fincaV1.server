package fincaV1.server.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="incidencia")
public class VecinoBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="nif")
	private String nif;
	
	@Column(name="iban")
	private String iban;
	
	@Column(name="num_mandato")
	private String num_mandato;
	
	@Column(name="fecha")
	private Date fecha;
	
	@Column(name="porccentaje_participacion")
	private int porcentaje_participacion;
	
	@Column(name="id_comunidad")
	private int id_comunidad;
	
	@Column(name="email")
	private String email;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="id_tipovecino")
	private int id_tipovecino;
	
	@Column(name="cod_poblacion")
	private int cod_poblacion;

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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public String getNum_mandato() {
		return num_mandato;
	}

	public void setNum_mandato(String num_mandato) {
		this.num_mandato = num_mandato;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getPorcentaje_participacion() {
		return porcentaje_participacion;
	}

	public void setPorcentaje_participacion(int porcentaje_participacion) {
		this.porcentaje_participacion = porcentaje_participacion;
	}

	public int getId_comunidad() {
		return id_comunidad;
	}

	public void setId_comunidad(int id_comunidad) {
		this.id_comunidad = id_comunidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getId_tipovecino() {
		return id_tipovecino;
	}

	public void setId_tipovecino(int id_tipovecino) {
		this.id_tipovecino = id_tipovecino;
	}

	public int getCod_poblacion() {
		return cod_poblacion;
	}

	public void setCod_poblacion(int cod_poblacion) {
		this.cod_poblacion = cod_poblacion;
	}

	@Override
	public String toString() {
		return "VecinoBean [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", numero=" + numero
				+ ", nif=" + nif + ", iban=" + iban + ", num_mandato=" + num_mandato + ", fecha=" + fecha
				+ ", porcentaje_participacion=" + porcentaje_participacion + ", id_comunidad=" + id_comunidad
				+ ", email=" + email + ", telefono=" + telefono + ", id_tipovecino=" + id_tipovecino
				+ ", cod_poblacion=" + cod_poblacion + "]";
	}
	
	

}
