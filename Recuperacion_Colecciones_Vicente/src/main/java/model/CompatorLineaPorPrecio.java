package main.java.model;

import java.util.Comparator;

public class CompatorLineaPorPrecio implements Comparator<Linea> {

	@Override
	public int compare(Linea o1, Linea o2) {
		return o1.getImporte().compareTo(o2.getImporte());
	}

}
