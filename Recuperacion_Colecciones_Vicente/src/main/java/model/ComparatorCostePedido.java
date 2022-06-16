package main.java.model;

import java.util.Comparator;

public class ComparatorCostePedido implements Comparator<Double> {

	@Override
	public int compare(Double o1, Double o2) {
		return o2.compareTo(o1);
	}

}
