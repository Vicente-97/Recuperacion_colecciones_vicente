package main.java.model;

import java.util.HashSet;
import java.util.Set;

public class Catalogo {

	private Set<Producto> listaProductos;
	
	public Catalogo() {
		this.listaProductos=new HashSet<>();
	}
	
	public String mostrarProductos() {
		StringBuilder st = new StringBuilder();
		for(Producto p : listaProductos) {
			st.append(p+System.lineSeparator());
		}
		
				
		return st.toString();
	}
	
	public String mostrarProductosActivos() {
		StringBuilder st = new StringBuilder();
		for(Producto p :listaProductos) {
			if (p.isActivo()==true) {
				st.append(p+System.lineSeparator());
			}
		}
		return st.toString();
	}
}
