//package fincaV1.server.entity;
//
//import java.sql.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.PrimaryKeyJoinColumn;
//import javax.persistence.SecondaryTable;
//import javax.persistence.SecondaryTables;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
//@Entity
//@Table(name = "recibo")
//@SecondaryTables({
//	@SecondaryTable(name = "vecino", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "id") }) })
//public class ReciboBean {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	@NotNull
//	private int id;
//	
//	@Column(name = "fecha_emision")
//	@NotNull
//	private Date fecha_emision;
//	
//	@Column(name = "num_registro")
//	@NotNull
//	private double num_registro;
//	
//	@Column(name = "descripcion")
//	@NotNull
//	private String descripcion;
//	
//	@Column(name = "importe")
//	@NotNull
//	private double importe;
//	
//	@Column(name = "fecha_cobro")
//	@NotNull
//	private Date fecha_cobro;
//	
//	@ManyToOne
//	@JoinColumn(name = "id_vecino")
//	@NotNull
//	private VecinoBean vecino;
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public Date getFecha_emision() {
//		return fecha_emision;
//	}
//
//	public void setFecha_emision(Date fecha_emision) {
//		this.fecha_emision = fecha_emision;
//	}
//
//	public double getNum_registro() {
//		return num_registro;
//	}
//
//	public void setNum_registro(double num_registro) {
//		this.num_registro = num_registro;
//	}
//	
//	public String getDescripcion() {
//		return descripcion;
//	}
//
//	public void setDescripcion(String descripcion) {
//		this.descripcion = descripcion;
//	}
//
//	public double getImporte() {
//		return importe;
//	}
//
//	public void setImporte(double importe) {
//		this.importe = importe;
//	}
//
//	public Date getFecha_cobro() {
//		return fecha_cobro;
//	}
//
//	public void setFecha_cobro(Date fecha_cobro) {
//		this.fecha_cobro = fecha_cobro;
//	}
//
//	public VecinoBean getVecino() {
//		return vecino;
//	}
//
//	public void setVecino(VecinoBean vecino) {
//		this.vecino = vecino;
//	}
//
//	@Override
//	public String toString() {
//		return "ReciboBean [id=" + id + ", fecha_emision=" + fecha_emision + ", num_registro=" + num_registro
//				+ ", descripcion=" + descripcion + ", importe=" + importe + ", fecha_cobro=" + fecha_cobro + ", vecino="
//				+ vecino + "]";
//	}
//
//}
