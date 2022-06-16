package main.java.model;

import java.util.Comparator;

public class ComparatorClientePorEdad implements Comparator<Cliente> {

	@Override
	public int compare(Cliente o1, Cliente o2) {

		return o1.getFechaNacimiento().compareTo(o2.getFechaNacimiento());
	}

}
