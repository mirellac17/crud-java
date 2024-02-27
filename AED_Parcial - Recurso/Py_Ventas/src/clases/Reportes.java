package clases;

public class Reportes {

	private int codigoVenta; 
	 private int codigoCliente, codigoProducto;
	 private String fecha;
	 private double importe_subtotal,importe_del_IGV,importe_total;
	
	 public Reportes(int codigoVenta, int codigoCliente, int codigoProducto, String fecha, double importe_subtotal,
			double importe_del_IGV, double importe_total) {
		//super();
		this.codigoVenta = codigoVenta;
		this.codigoCliente = codigoCliente;
		this.codigoProducto = codigoProducto;
		this.fecha = fecha;
		this.importe_subtotal = importe_subtotal;
		this.importe_del_IGV = importe_del_IGV;
		this.importe_total = importe_total;
	}

	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getImporte_subtotal() {
		return importe_subtotal;
	}

	public void setImporte_subtotal(double importe_subtotal) {
		this.importe_subtotal = importe_subtotal;
	}

	public double getImporte_del_IGV() {
		return importe_del_IGV;
	}

	public void setImporte_del_IGV(double importe_del_IGV) {
		this.importe_del_IGV = importe_del_IGV;
	}

	public double getImporte_total() {
		return importe_total;
	}

	public void setImporte_total(double importe_total) {
		this.importe_total = importe_total;
	}


	 
}
	
//	Listado general de ventas mostrando en cada caso: código de venta, código de cliente, 
//	código de producto, fecha, importe subtotal, importe del IGV e importe total.
	
	// public Reportes(int codigoVenta, int codigoCliente, int codigoProducto,String fecha, double importe_subtotal, double importe_del_IGV, double importe_total ) {
	
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 