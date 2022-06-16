package main.java.model;

import java.util.Comparator;

public class ComparatorPedidoID implements Comparator<Pedido> {

	@Override
	public int compare(Pedido o1, Pedido o2) {
		return o1.getId().compareTo(o2.getId());
	}

}
