package fincaV1.server.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
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

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "vecino")
@SecondaryTables({
		@SecondaryTable(name = "poblacion", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "cod_postal") }),
		@SecondaryTable(name = "comunidad", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "id") }),
		@SecondaryTable(name = "tipovecino", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "id") })
})
@DynamicUpdate(value=true)
public class VecinoBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	private int id;

	@Column(name = "nombre")
	@NotNull
	private String nombre;

	@Column(name = "direccion")
	@NotNull
	private String direccion;

	@Column(name = "numero")
	@NotNull
	private String numero;

	@Column(name = "nif")
	@NotNull
	private String nif;

	@Column(name = "iban")
	@NotNull
	private String iban;

	@Column(name = "num_mandato")
	@NotNull
	private String num_mandato;

	@Column(name = "fecha_mandato")
	@NotNull
	private Date fecha_mandato;

	@Column(name = "porcentaje_participacion")
	@NotNull
	private int porcentaje_participacion;

	@ManyToOne
	@JoinColumn(name = "id_comunidad")
	@NotNull
	private ComunidadBean comunidad;

	@Column(name = "email")
	@NotNull
	private String email;

	@Column(name = "telefono")
	@NotNull
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name = "id_tipovecino")
	@NotNull
	private TipovecinoBean id_tipovecino;

	@Column(name = "login")
	@NotNull
	private String login;

	@Column(name = "pass")
	private String pass;

	@ManyToOne
	@JoinColumn(name = "cod_poblacion")
	@NotNull
	private PoblacionBean poblacion;

	public void setPoblacion(PoblacionBean poblacion) {
		this.poblacion = poblacion;
	}

	public PoblacionBean getPoblacion() {
		return poblacion;
	}

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

	public Date getFecha_mandato() {
		return fecha_mandato;
	}

	public void setFecha_mandato(Date fecha_mandato) {
		this.fecha_mandato = fecha_mandato;
	}

	public int getPorcentaje_participacion() {
		return porcentaje_participacion;
	}

	public void setPorcentaje_participacion(int porcentaje_participacion) {
		this.porcentaje_participacion = porcentaje_participacion;
	}

	public ComunidadBean getComunidad() {
		return comunidad;
	}

	public void setComunidad(ComunidadBean comunidad) {
		this.comunidad = comunidad;
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

	public TipovecinoBean getId_tipovecino() {
		return id_tipovecino;
	}

	public void setId_tipovecino(TipovecinoBean id_tipovecino) {
		this.id_tipovecino = id_tipovecino;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@JsonIgnore
	public String getPass() {
		return pass;
	}

	@JsonProperty
	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "VecinoBean [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", numero=" + numero
				+ ", nif=" + nif + ", iban=" + iban + ", num_mandato=" + num_mandato + ", fecha_mandato="
				+ fecha_mandato + ", porcentaje_participacion=" + porcentaje_participacion + ", comunidad=" + comunidad
				+ ", email=" + email + ", telefono=" + telefono + ", id_tipovecino=" + id_tipovecino + ", login="
				+ login + ", pass=" + pass + ", poblacion=" + poblacion + "]";
	}







}
