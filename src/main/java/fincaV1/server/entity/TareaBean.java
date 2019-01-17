package fincaV1.server.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "tarea")
public class TareaBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	private int id;

	@Column(name = "fecha")
	@NotNull
	private Date fecha;

	@Column(name = "descripcion")
	@NotNull
	private String descripcion;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "tarea_tag", joinColumns = @JoinColumn(name = "id_tarea"), inverseJoinColumns = @JoinColumn(name = "id_tag"))
	private Set<TagBean> tags;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<TagBean> getTags() {
		return tags;
	}

	@JsonDeserialize(as=TagBean.class)
	public void setTags(Set<TagBean> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "TareaBean [id=" + id + ", fecha=" + fecha + ", descripcion=" + descripcion + ", tags=" + tags + "]";
	}
	
	

}
