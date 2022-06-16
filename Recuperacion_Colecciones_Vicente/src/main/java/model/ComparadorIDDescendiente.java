package main.java.model;

import java.util.Comparator;

public class ComparadorIDDescendiente implements Comparator<Linea> {

	@Override
	public int compare(Linea o1, Linea o2) {	
		return o2.getId().compareTo(o1.getId());
	}

}
