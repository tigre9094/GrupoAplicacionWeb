package com.controlador.entidades;

public class departamento {

	
	private int idTipoDepartamento;
	private String descripcion;
	private String estado;
	public int getIdTipoDepartamento() {
		return idTipoDepartamento;
	}
	public void setIdTipoDepartamento(int idTipoDepartamento) {
		this.idTipoDepartamento = idTipoDepartamento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public departamento(int idTipoDepartamento, String descripcion, String estado) {
		super();
		this.idTipoDepartamento = idTipoDepartamento;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	public departamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	}
