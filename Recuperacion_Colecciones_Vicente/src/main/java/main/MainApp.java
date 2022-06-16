package main.java.main;

import java.time.LocalDate;

import main.java.model.Cliente;
import main.java.model.Genero;
import main.java.model.Linea;
import main.java.model.Negocio;
import main.java.model.Pedido;
import main.java.model.Producto;
import main.java.model.Status;

public class MainApp {

	public static void main(String[] args) {
		Negocio n1 = new Negocio();
		Cliente c1 = new Cliente("Jose Juan", "Carmona", "josejose@gmail.com",LocalDate.of(2003, 12, 12), Genero.HOMBRE);
		Cliente c2 = new Cliente("Juan Antonio", "Cespedes", "juanjuan@gmail.com",LocalDate.of(2003, 11, 11), Genero.HOMBRE);
		Cliente c3 = new Cliente("Mario", "COnde", "mariomario@gmail.com",LocalDate.of(2003, 11, 11), Genero.HOMBRE);

		Pedido p1 = new Pedido("AAA", Status.PROCESADO, c1);
		Pedido p2 = new Pedido("CCC", Status.PROCESADO, c2);
		Pedido p3 = new Pedido("XXX", Status.PROCESADO, c3);
		
		Producto producto1 = new Producto("Tomate", "cherry", 10.0);
		Producto producto2 = new Producto("Mantequilla", "Tulipan", 5.0);
		Producto producto3 = new Producto("Hojaldre", "Costarica", 3.0);
		Linea l1 = new Linea("5214", producto3, 5, 2.0);
		Linea l2 = new Linea("5216", producto2, 8, 2.0);
		Linea l3 = new Linea("5218", producto1, 6, 2.0);

		n1.addCliente(c1);
		n1.addCliente(c2);
		n1.addCliente(c3);
		p3.addLinea(l3);
		n1.addPedido(p3);
		n1.addPedido(p1);
		n1.addPedido(p2);
		p1.addLinea(l1);
		p1.addLinea(l2);
		p2.addLinea(l2);
		//System.out.println(l1.addProducto(pr3));
		//System.out.println(pr3.isActivo());
		//System.out.println(n1.listarClientesPorImporteVenta());
		System.out.println(n1.mostrarPedidosYLineasPorID());
		System.out.println(n1.mostrarPedidosYLineasPorPrecio());
		
		System.out.println(n1.mostrarPedidoConMayorCantidadDeProductos());
		System.out.println(n1.mostrarProductosPorCliente());
	
		System.out.println(n1.pedidoPrecioUnitarioMasBajo());
		System.out.println(n1.obtenerMapaProductoEstrella());
		System.out.println(n1.obtenerProductoEstrella());
		
		System.out.println(p1.mostrarLineasPorIDAscendente());
		System.out.println(p1.mostrarLineasPorIDDescendiente());
		
		System.out.println(l1);
		
		System.out.println(n1.pedidoPrecioUnitarioMasAlto());
		System.out.println(n1.pedidoPrecioUnitarioMasBajo());
		
		System.out.println(n1.clienteVip());
	}
	}


