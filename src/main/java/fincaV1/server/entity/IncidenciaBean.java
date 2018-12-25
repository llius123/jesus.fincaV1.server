package fincaV1.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name ="incidencia")
public class IncidenciaBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="id_vecino")
	private String id_vecino;
	
	@Column(name="desc")
	private String desc;
	
	public IncidenciaBean() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getId_vecino() {
		return id_vecino;
	}

	public void setId_vecino(String id_vecino) {
		this.id_vecino = id_vecino;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "IncidenciaBean [id=" + id + ", id_vecino=" + id_vecino + ", desc=" + desc + "]";
	}
	
	

}
