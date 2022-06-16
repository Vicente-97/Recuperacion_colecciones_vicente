package main.java.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Negocio {

	private List<Cliente> listaClientes;
	private List<Pedido> listaPedido;
	private List<Catalogo> listaCatalogo;
	
	
	public Negocio () {
		this.listaCatalogo=new ArrayList<>();
		this.listaClientes= new ArrayList<>();
		this.listaPedido=new ArrayList<>();
	}
	
	public boolean addCliente(Cliente c1) {
		boolean resultado=false;

		if (!listaClientes.contains(c1) && LocalDate.now().getYear()-c1.getFechaNacimiento().getYear()>=18) {
				resultado=true;
				listaClientes.add(c1);
		}
		
		return resultado;
	}
	
	public void addPedido(Pedido p) {
		listaPedido.add(p);
	}
	
	public boolean eliminarCliente(String nombre) {
		boolean resultado=false;
			for(Cliente c: listaClientes) {
				if(c.getNombre().equals(nombre)) {
					listaClientes.remove(c);
					resultado=true;
				}
			}
		
		return resultado;
	}
	
	public String listarClientePorImporteDeVentas () {
		StringBuilder st = new StringBuilder();
		listaPedido.sort(new OrdenarPedidoPorImporteVenta());
		for(Pedido p : listaPedido) {
			st.append(p+System.lineSeparator());
		}
		
		return st.toString();
	}
	
	public String listaClientePorEdad () {
		StringBuilder st = new StringBuilder();
		listaClientes.sort(new ComparatorClientePorEdad());
		for (Cliente c: listaClientes) {
			st.append(c+System.lineSeparator());
		}
	
		return st.toString();
	}
	
	public String mostrarProductosPorCliente() {
		StringBuilder st = new StringBuilder();
		for(Pedido p :listaPedido) {
			st.append(p.getCliente());
			st.append(p.getNumeroProductos()+System.lineSeparator());
		}
		
		return st.toString();
	}
	
	public String mostrarPedidosYLineasPorID () {
		StringBuilder st = new StringBuilder();
		listaPedido.sort(new ComparatorPedidoID());
		for(Pedido p : listaPedido) {
			p.getListaLineas().sort(new ComparadorIDAscendente());
			for(Linea l : p.getListaLineas()) {
				st.append(l);
			}
		}
		
		
		return st.toString();
	}
	
	public String mostrarPedidosYLineasPorPrecio() {
		StringBuilder st = new StringBuilder();
		listaPedido.sort(new ComparatorPedidoPorPrecio());
		for(Pedido p : listaPedido) {
			p.getListaLineas().sort(new CompatorLineaPorPrecio());
			for(Linea l: p.getListaLineas()) {
				st.append(l);
			}
		}		
		return st.toString();
	}
	
	public Pedido mostrarPedidoConMayorCantidadDeProductos () {
		Pedido p1= new Pedido();
		for(Pedido p: listaPedido)
			if ( p1.getNumeroProductos()<p.getNumeroProductos()) {
				p1=p;
			}
		
		return p1;
	}
	
	public Pedido pedidoPrecioUnitarioMasAlto() {
		Pedido p1=new Pedido();
		Linea l1 = new Linea("7895", null, 1, 0.0);
		p1.addLinea(l1);
		
		for(Pedido p: listaPedido) {
			if(p1.precioUnitario()<=p.precioUnitario()) {
				p1=p;
			}
		}
		
		return p1;
	}
	public Pedido pedidoPrecioUnitarioMasBajo() {
		Pedido p1=new Pedido();
		Double contador= 9999.9999;
		for(Pedido p: listaPedido) {
			if(p.precioUnitario()<=contador) {
				contador=p.precioUnitario();
				p1=p;
			}
		}
		
		return p1;
	}
	//mal
	public Pedido pedidoProductoMasCaro() {
		Pedido p1= null;
		Double importeProductoMasCaro=0.0;
		for (Pedido p: listaPedido) {
			if(p.obtenerElProductoMasCaro()>importeProductoMasCaro) {
				importeProductoMasCaro=p.obtenerElProductoMasCaro();
				p1=p;
			}
			
		}
		
		return p1;
	}
	//mal
	public Pedido pedidoProductoMasBarato() {
		Pedido p1= new Pedido();
		Double contador= 9999.9999;
		for (Pedido p:listaPedido) {
			if(p.obtenerElPrecioMasBarato()<contador) {
				contador=p.obtenerElPrecioMasBarato();
				p1=p;
			}
		}
		
		
		return p1;
	}
	
	public Cliente clienteConMayorNumProductos() {
		Pedido p1= new Pedido();
		for (Pedido p : listaPedido) {
			if (p.getNumeroProductos()>p1.getNumeroProductos()) {
				p1=p;
			}
		}
		
		
		return p1.getCliente();
	}
	
	public List<Cliente> clienteVip() {
		Pedido p1= new Pedido();
		Double acumulador=0.0;
		Map<Cliente, Double> listaClientesVip = new HashMap<>();
		for (Pedido p : listaPedido) {
			if (!listaClientesVip.containsKey(p.getCliente())) {
				listaClientesVip.put(p.getCliente(), p.getCostePedido());
			}else {
				listaClientesVip.put(p.getCliente(), listaClientesVip.get(p.getCliente())+p.getCostePedido());
			}
				
			}
		
		List<Double> importes = new ArrayList<>(listaClientesVip.values());
		importes.sort(new ComparatorCostePedido());
		List<Cliente> listaDefinitivaDeVips= new ArrayList<>();
		if (importes.size()>1) {
			for (Cliente c: listaClientesVip.keySet()) {
				if (listaClientesVip.get(c).equals(importes.get(2))||listaClientesVip.get(c).equals(importes.get(1))||
						listaClientesVip.get(c).equals(importes.get(0))) {
					listaDefinitivaDeVips.add(c);
				}
			}
		}
			
		
		return listaDefinitivaDeVips;
	}
	
	public Map<Producto,Integer> obtenerMapaProductoEstrella(){
		Map<Producto,Integer> mapaProductoVip = new HashMap<>();
		
		for (Pedido p: listaPedido) {
			for (Linea l: p.getListaLineas()) {
				if (mapaProductoVip.keySet().contains(l.getProducto())) {
					mapaProductoVip.put(l.getProducto(), l.getCantidad()+mapaProductoVip.get(l.getProducto()));
				}else {
					mapaProductoVip.put(l.getProducto(), l.getCantidad());
					
				}
			}
		}
		
		return mapaProductoVip;
	}
	
	public Producto obtenerProductoEstrella() {
		Map<Producto,Integer> mapaProductoVip = obtenerMapaProductoEstrella();
		Integer resultado=0;
		Producto p1 = new Producto();
		for (Producto p: mapaProductoVip.keySet()) {
			if (mapaProductoVip.get(p)>resultado) {
				resultado= mapaProductoVip.get(p);
				p1=p;
			}
		}
		return p1;
	}
	
}
