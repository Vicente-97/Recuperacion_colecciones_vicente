package main.java.model;

import java.util.Comparator;

public class ComparatorPedidoPorPrecio implements Comparator<Pedido> {

	@Override
	public int compare(Pedido o1, Pedido o2) {
		return o1.getCostePedido().compareTo(o2.getCostePedido());
	}

}
