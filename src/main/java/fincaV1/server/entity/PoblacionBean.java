package fincaV1.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="poblacion")
public class PoblacionBean {
	
	@Id
	@Column(name = "cod_postal")
	private int cod_postal;
	
	@Column(name="desc")
	private String desc;
	
	@Column(name="cod_provincia")
	private int cod_provincia;

	public int getCod_postal() {
		return cod_postal;
	}

	public void setCod_postal(int cod_postal) {
		this.cod_postal = cod_postal;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getCod_provincia() {
		return cod_provincia;
	}

	public void setCod_provincia(int cod_provincia) {
		this.cod_provincia = cod_provincia;
	}

	@Override
	public String toString() {
		return "PoblacionBean [cod_postal=" + cod_postal + ", desc=" + desc + ", cod_provincia=" + cod_provincia + "]";
	}
	
	

}
