package main.java.model;

public class Linea {

	private Integer id=0;
	private String codigo;
	private Integer cantidad;
	private Double importe;
	private Producto producto;
	private static Integer secuencia=0;
	
	public Linea () {
		
	}
	
	public Linea (String codigo, Producto producto,Integer cantidad, Double importe) {
		this.codigo=codigo;
		this.producto=producto;
		this.id=secuencia++;
		this.cantidad=cantidad;
		this.importe=importe;
		this.importe=importe;
		this.id++;
	}
	
	public boolean addProducto (Producto producto1) {
		boolean resultado= false;
			if (producto1.getFechaBaja()==null&&this.importe>0) {
				setProducto(producto1);
				resultado=true;
			}
		return resultado;
	}
	
	public boolean eliminarProducto(Integer id) {
		boolean resultado=false;
			if(this.producto.getId()==id) {
				this.producto=null;
				resultado=true;
			}
		
		return resultado;
	}
	
	public boolean vaciarLinea() {
		boolean resultado=false;
			this.cantidad=null;
			this.codigo=null;
			this.id=null;
			this.importe=null;
			this.producto=null;
			resultado=true;
		
		return resultado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Linea [id=" + id + ", codigo=" + codigo + ", cantidad=" + cantidad + ", importe=" + importe
				+ ", producto=" + producto + "]";
	}
	
	
}
