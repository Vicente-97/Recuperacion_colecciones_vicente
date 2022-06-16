package main.java.model;

import java.time.LocalDate;

public class Producto {

	private LocalDate fechaAlta;
	private LocalDate fechaBaja;
	private String nombre;
	private Integer id;
	private String descripcion;
	private Double precioUnitario;
	
	public Producto() {
		
	}
	
	public Producto ( String nombre, String descripcion, Double precioUnitario) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.precioUnitario=precioUnitario;
	}
	
	public boolean isActivo() {
		boolean resultado=false;
			if(this.fechaBaja==null) {
				resultado=true;
			}
		return resultado;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public LocalDate getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(LocalDate fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@Override
	public String toString() {
		return "Producto [fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja + ", nombre=" + nombre + ", id=" + id
				+ ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario + "]";
	}
	
	
}
