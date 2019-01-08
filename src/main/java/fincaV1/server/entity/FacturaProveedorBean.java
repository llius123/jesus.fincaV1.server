package fincaV1.server.entity;

import java.sql.Date;

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
@Table(name = "factura_proveedor")
@SecondaryTables({ @SecondaryTable(name = "comunidad", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "id") }),
		@SecondaryTable(name = "tipofactura", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "id") }),
		@SecondaryTable(name = "proveedor", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "id") }) })
public class FacturaProveedorBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	private int id;

	@Column(name = "fecha_registro")
	@NotNull
	private Date fecha_registro;

	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	@NotNull
	private ProveedorBean proveedor;

	@ManyToOne
	@JoinColumn(name = "id_tipofactura")
	@NotNull
	private TipofacturaBean tipofactura;

	@Column(name = "base_imponible0")
	@NotNull
	private double base_imponible0;

	@Column(name = "base_imponible1")
	@NotNull
	private double base_imponible1;

	@Column(name = "base_imponible2")
	@NotNull
	private double base_imponible2;

	@Column(name = "base_imponible3")
	@NotNull
	private double base_imponible3;

	@Column(name = "tipo_iva1")
	@NotNull
	private double tipo_iva1;

	@Column(name = "tipo_iva2")
	@NotNull
	private double tipo_iva2;

	@Column(name = "tipo_iva3")
	@NotNull
	private double tipo_iva3;

	@Column(name = "cuota_iva1")
	@NotNull
	private double cuota_iva1;

	@Column(name = "cuota_iva2")
	@NotNull
	private double cuota_iva2;

	@Column(name = "cuota_iva3")
	@NotNull
	private double cuota_iva3;

	@Column(name = "total")
	@NotNull
	private double total;

	@ManyToOne
	@JoinColumn(name = "id_comunidad")
	@NotNull
	private ComunidadBean comunidad;

	@Column(name = "num_factura")
	@NotNull
	private String num_factura;
	
	@Column(name="cobrado")
	@NotNull
	private String cobrado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public ProveedorBean getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorBean proveedor) {
		this.proveedor = proveedor;
	}

	public TipofacturaBean getTipofactura() {
		return tipofactura;
	}

	public void setTipofactura(TipofacturaBean tipofactura) {
		this.tipofactura = tipofactura;
	}

	public double getBase_imponible0() {
		return base_imponible0;
	}

	public void setBase_imponible0(double base_imponible0) {
		this.base_imponible0 = base_imponible0;
	}

	public double getBase_imponible1() {
		return base_imponible1;
	}

	public void setBase_imponible1(double base_imponible1) {
		this.base_imponible1 = base_imponible1;
	}

	public double getBase_imponible2() {
		return base_imponible2;
	}

	public void setBase_imponible2(double base_imponible2) {
		this.base_imponible2 = base_imponible2;
	}

	public double getBase_imponible3() {
		return base_imponible3;
	}

	public void setBase_imponible3(double base_imponible3) {
		this.base_imponible3 = base_imponible3;
	}

	public double getTipo_iva1() {
		return tipo_iva1;
	}

	public void setTipo_iva1(double tipo_iva1) {
		this.tipo_iva1 = tipo_iva1;
	}

	public double getTipo_iva2() {
		return tipo_iva2;
	}

	public void setTipo_iva2(double tipo_iva2) {
		this.tipo_iva2 = tipo_iva2;
	}

	public double getTipo_iva3() {
		return tipo_iva3;
	}

	public void setTipo_iva3(double tipo_iva3) {
		this.tipo_iva3 = tipo_iva3;
	}

	public double getCuota_iva1() {
		return cuota_iva1;
	}

	public void setCuota_iva1(double cuota_iva1) {
		this.cuota_iva1 = cuota_iva1;
	}

	public double getCuota_iva2() {
		return cuota_iva2;
	}

	public void setCuota_iva2(double cuota_iva2) {
		this.cuota_iva2 = cuota_iva2;
	}

	public double getCuota_iva3() {
		return cuota_iva3;
	}

	public void setCuota_iva3(double cuota_iva3) {
		this.cuota_iva3 = cuota_iva3;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ComunidadBean getComunidad() {
		return comunidad;
	}

	public void setComunidad(ComunidadBean comunidad) {
		this.comunidad = comunidad;
	}

	public String getNum_factura() {
		return num_factura;
	}

	public void setNum_factura(String num_factura) {
		this.num_factura = num_factura;
	}

	public String getCobrado() {
		return cobrado;
	}

	public void setCobrado(String cobrado) {
		this.cobrado = cobrado;
	}

	@Override
	public String toString() {
		return "FacturaProveedorBean [id=" + id + ", fecha_registro=" + fecha_registro + ", proveedor=" + proveedor
				+ ", tipofactura=" + tipofactura + ", base_imponible0=" + base_imponible0 + ", base_imponible1="
				+ base_imponible1 + ", base_imponible2=" + base_imponible2 + ", base_imponible3=" + base_imponible3
				+ ", tipo_iva1=" + tipo_iva1 + ", tipo_iva2=" + tipo_iva2 + ", tipo_iva3=" + tipo_iva3 + ", cuota_iva1="
				+ cuota_iva1 + ", cuota_iva2=" + cuota_iva2 + ", cuota_iva3=" + cuota_iva3 + ", total=" + total
				+ ", comunidad=" + comunidad + ", num_factura=" + num_factura + ", cobrado=" + cobrado + "]";
	}




}
