package main.java.model;

import java.util.Comparator;

public class ComparadorIDAscendente implements Comparator<Linea> {

	@Override
	public int compare(Linea o1, Linea o2) {		
		return o1.getId().compareTo(o2.getId());
	}

}
