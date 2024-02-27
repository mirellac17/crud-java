package arreglos;

import clases.Venta;
import java.util.ArrayList;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ArregloVentas {

	// public class ArregloImpresoras {
	// Atributo privado
	private ArrayList<Venta> vent;
	private String archivo;

	// Constructor
	public ArregloVentas(String archivo) {
		vent = new ArrayList<Venta>();
		this.archivo = archivo;
		cargarVentas();
	}

	// Métodos de acceso: set/get
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getArchivo() {
		return archivo;
	}

	// Constructor
	// public ArregloVentas() {
	// vent = new ArrayList<Ventas>();
	// adicionar(new Venta(3001,1001,2001,10, 1350.0, 01/01/2024));
	// adicionar(new Venta(3002,1002,2001,210, 2300.0, 02/01/2024));
	// adicionar(new Venta(3003,1003,2001,310, 2100.0, 03/01/2024));
	// adicionar(new Venta(3004,1004,2001,140, 1900.0, 04/01/2024));
	// adicionar(new Venta(3005,1005,2001,510,1050.0, 05/01/2024));
	// adicionar(new Venta(3006,1006,2001,106, 4210.0, 06/01/2024));
	// adicionar(new Venta(3007,1007,2001,710, 2090.0, 07/01/2024));
	// adicionar(new Venta(3008,1008,2001,180,3520.0, 08/01/2024));
	// adicionar(new Venta(3009,1009,2001,910, 3500.0,09/01/2024));
	// adicionar(new Venta(3010,1010,2001,110, 2200.0, 10/01/2024));
//	}

	
	// Operaciones públicas básicas
	public void adicionar(Venta x) {
		vent.add(x);
	}

	public Venta obtener(int i) {
		return vent.get(i);
	}

	public int tamaño() {
		return vent.size();
	}

	public void eliminar(Venta x) {
		vent.remove(x);
	}

	public void reinicializarArreglo() {
		if (tamaño() > 0)
			vent.clear();
	}

	// }

//	public Venta buscar(int codigoVenta) {
//		Venta x;
	//	for (int i = 0; i < tamaño(); i++) {
	//		x = obtener(i);
	//		if (x.getCodigoVenta() == codigoVenta)
	//			return x;
	//		else
	//		if (x.getCodigoCliente() == codigoCliente)
	//			return x;
	//		else
	///		if (x.getCodigoProducto() == codigoProducto)
	//			return x;
	//	}
	//	return null;
	
//}
	
	public Venta buscar(int codigo) {
		Venta x;
		for (int i = 0; i < tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigoVenta() == codigo)
				return x;
		}
		return null;
	}
	
	public Venta buscar(String fecha) {
		Venta x;
		for (int i = 0; i < tamaño(); i++) {
			x = obtener(i);
			if (x.getFecha().equals(fecha))
				return x;
		}
		return null;
	}
//	public Venta buscar(int codigoCliente) {
//		Venta x;
//		for (int i = 0; i < tamaño(); i++) {
//			x = obtener(i);
//			if (x.getCodigoCliente() == codigoCliente)
//
				//// if (x.getStockMaximo().equals(StockMaximo))
//				return x;
//		}
//		return null;
//	}
	
//	public Venta buscar(int codigoProducto) {
//		Venta x;
//		for (int i = 0; i < tamaño(); i++) {
//			x = obtener(i);
//			if (x.getCodigoProducto() == codigoProducto)
//				return x;
	//	}
	//	return null;
	//}

// Operaciones públicas complementarias
	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 3001;
		else
			return obtener(tamaño() - 1).getCodigoVenta() + 1;
	}

	public void grabarVentas() {
		try {
			PrintWriter pw;
			String linea;
			Venta x;
			pw = new PrintWriter(new FileWriter("archivo"));
			for (int i = 0; i < vent.size(); i++) {
				x = vent.get(i);
//	for (int i=0; i<tamaño(); i++) {
//	x = obtener(i);
				linea = x.getCodigoVenta() + ";" +  x.getCodigoCliente() + ";" + x.getCodigoProducto() + ";" + x.getCantidad() + ";"
						+ x.getPrecio() + ";" + x.getFecha();
//	x.getPeso() + ";" +
//	x.getEstatura(); 
				
			
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public void cargarVentas() {
		try {
			BufferedReader br;
			String linea, fecha;
			String s[];
			Double precio;
			int codigoVenta;
			int codigoCliente;
			int codigoProducto;
			int cantidad;
//	double peso, estatura;
			br = new BufferedReader(new FileReader("archivo"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoVenta = Integer.parseInt(s[0].trim());
				codigoCliente = Integer.parseInt(s[1].trim());
				codigoProducto = Integer.parseInt(s[2].trim());
				cantidad = Integer.parseInt(s[3].trim());
				precio = Double.parseDouble(s[4].trim());
				fecha = (s[5].trim());
//	peso = Double.parseDouble(s[2].trim());
//	estatura = Double.parseDouble(s[3].trim());
				adicionar(new Venta(codigoVenta, codigoCliente, codigoProducto, cantidad, precio, fecha));
		
				
			}
			br.close();
		} catch (Exception e) {
		}
	}
}


