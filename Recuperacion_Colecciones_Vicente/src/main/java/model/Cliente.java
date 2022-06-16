package main.java.model;

import java.time.LocalDate;

public class Cliente {

	private static final int MAYOR_EDAD = 18;
	private Integer id;
	private String nombre;
	private String apellidos;
	private String email;
	private String dni;
	private LocalDate fechaNacimiento;
	private Genero genero;
	
	

	public Cliente () {
		
	}



	public Cliente(String nombre, String apellidos, String email, LocalDate fechaNacimiento, Genero genero) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
	}

	public boolean esMayorEdad() {
		boolean resultado=false;
				
		return getFechaNacimiento().getYear()-LocalDate.now().getYear()>=MAYOR_EDAD;
	}


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public Genero getGenero() {
		return genero;
	}



	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	
}
