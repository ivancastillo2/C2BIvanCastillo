package com.curso.jpa.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JOBS",schema = "HR")
public class Trabajo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "JOB_ID")
	private String id;
	
	@Column(name = "JOB_TITLE")
	private String tituloTrabajo;
	
	@Column(name = "MIN_SALARY")
	private Double salarioMinimo;
	
	@Column(name = "MAX_SALARY")
	private Double salarioMaximo;

	public Trabajo() {
		
	}
	
	public Trabajo(String id, String tituloTrabajo, Double salarioMinimo, Double salarioMaximo) {
		super();
		this.id = id;
		this.tituloTrabajo = tituloTrabajo;
		this.salarioMinimo = salarioMinimo;
		this.salarioMaximo = salarioMaximo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTituloTrabajo() {
		return tituloTrabajo;
	}

	public void setTituloTrabajo(String tituloTrabajo) {
		this.tituloTrabajo = tituloTrabajo;
	}

	public Double getSalarioMinimo() {
		return salarioMinimo;
	}

	public void setSalarioMinimo(Double salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}

	public Double getSalarioMaximo() {
		return salarioMaximo;
	}

	public void setSalarioMaximo(Double salarioMaximo) {
		this.salarioMaximo = salarioMaximo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Trabajo other = (Trabajo) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Trabajo [id=" + id + ", tituloTrabajo=" + tituloTrabajo + ", salarioMinimo=" + salarioMinimo
				+ ", salarioMaximo=" + salarioMaximo + "]";
	}
	
}
