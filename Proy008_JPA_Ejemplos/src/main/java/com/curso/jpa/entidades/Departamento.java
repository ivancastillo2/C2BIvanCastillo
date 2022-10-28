package com.curso.jpa.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENTS")
@NamedQueries({
	
	@NamedQuery(name="Departamento.findALL", 
			query="SELECT D FROM Departamento D"),
	@NamedQuery(name="Departamento.findByManager", 
			query="SELECT d FROM Departamento d WHERE d.idManager = :idManager"),
	@NamedQuery(name="Departamento findSinManager", 
			query="SELECT D FROM Departamento d where d.idManager IS NULL"),
	
})
public class Departamento implements Serializable{

	@Id
	@Column(name="DEPARTMENT_ID")
	private Integer id;
	@Column(name="DEPARTMENT_NAME")
	private String nombreDepartamento;
	@Column(name="MANAGER_ID")
	private Integer idManager;
	@Column(name="LOCATION_ID")
	private Integer idLocalidad;
	
	public Departamento() {
		
	}

	public Departamento(Integer id, String nobreDepartamento, Integer idManager, Integer idLocalidad) {
		super();
		this.id = id;
		this.nombreDepartamento = nobreDepartamento;
		this.idManager = idManager;
		this.idLocalidad = idLocalidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nobreDepartamento) {
		this.nombreDepartamento = nobreDepartamento;
	}

	public Integer getIdManager() {
		return idManager;
	}

	public void setIdManager(Integer idManager) {
		this.idManager = idManager;
	}

	public Integer getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Integer idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombreDepartamento=" + nombreDepartamento + ", idManager=" + idManager
				+ ", idLocalidad=" + idLocalidad + "]";
	}
	
}
