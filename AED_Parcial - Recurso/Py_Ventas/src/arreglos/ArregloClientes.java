package arreglos;

import clases.Clientes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArregloClientes {

	// Atributo privado
	private ArrayList<Clientes> cli;
	private String archivo;

	// Constructor
	public ArregloClientes(String archivo) {
		cli = new ArrayList<Clientes>();
		this.archivo = archivo;
		cargarPersonas();
	}

	// Métodos de acceso: set/get
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getArchivo() {
		return archivo;
	}

//	adicionar(new Clientes(1001, "Juan Felipe"," Prado Salazar", "Av. Tacna # 100 Lima", "4282175", "40414243"));
//	adicionar(new Clientes(1002, "Pedro Zacarias"," Romero Soto","Av. Perú # 1200 Lima" , " 2795158","50514521"));
//	adicionar(new Clientes(1003, "Luis Demóstenes"," Pinto Garza", "Av. Arequipa # 5100 Lima" ," 3821832","07172730"));
//	adicionar(new Clientes(1004, "Daniel Marcos"," Rojas Saenz","Av. 28 de Julio # 789 Lima" , "5402172","10111212"));
//	adicionar(new Clientes(1005, "Jorge Josué"," Vespino Guerra","Av. Lima # 100 Lima" , "2500759"," 31324481"));
//	adicionar(new Clientes(1006, "John Mateo"," Belisario Veliz","Jr. Callao # 1210 Lima" , "3310759","25628415"));
//	adicionar(new Clientes(1007, "Jorge Lucas"," Portocarrero Paz","Calle Santa Rosa 999 Lima" , "4451019","23456789"));
//	adicionar(new Clientes(1008, "Jose Ricardo"," Alegria Cruz","Av. Ricardo Palma # 123 Lima" , "5100769","01811223"));
//	adicionar(new Clientes(1009, "Juan Sebastian"," Sagrado Manzanero","Av. Abancay # 456 Lima" , "4104779"," 56575859"));
//	adicionar(new Clientes(1010, "Jean Carlos"," Zapata Osorio","Av. Larco # 789 Lima" , "5100759"," 21222324"));
//	}

	// Operaciones públicas básicas
	public void adicionar(Clientes p) {
		cli.add(p);
	}

	public int tamaño() {
		return cli.size();
	}

	public Clientes obtener(int pos) {
		return cli.get(pos);
	}

	public void eliminar(Clientes x) {
		cli.remove(x);
	}

	public Clientes buscar(int codigo) {
		Clientes x;
		for (int i = 0; i < tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigoCliente() == codigo)
				return x;
		}
		return null;
	}

	public Clientes buscar(String dni) {
		Clientes x;
		for (int i = 0; i < tamaño(); i++) {
			x = obtener(i);
			if (x.getDni().equals(dni))
				return x;
		}
		return null;
	}

	// Operaciones públicas complementarias
	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 1001;
		else
			return obtener(tamaño() - 1).getCodigoCliente() + 1;
	}

	public void grabarClientes() {
		try {
			PrintWriter pw;
			String linea;
			Clientes x;
			pw = new PrintWriter(new FileWriter("archivo"));
			for (int i = 0; i < cli.size(); i++) {
				x = cli.get(i);
				// for (int i=0; i<tamaño(); i++) {
				// x = obtener(i);
				linea = x.getCodigoCliente() + ";" + x.getApellidos() + ";" + x.getDirección() + ";" + x.getTeléfono()
						+ ";" + x.getDni();

				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public void cargarPersonas() {
		try {
			BufferedReader br;
			String linea, nombres, apellidos, dirección, telefono, dni;
			String s[];
			int codigoCliente;

			br = new BufferedReader(new FileReader("archivo"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoCliente = Integer.parseInt(s[0].trim());
				nombres = s[1].trim();
				apellidos = s[2].trim();
				dirección = s[3].trim();
				telefono = s[4].trim();
				dni = s[5].trim();
				// peso = Double.parseDouble(s[2].trim());
				// estatura = Double.parseDouble(s[3].trim());
				adicionar(new Clientes(codigoCliente, nombres, apellidos, dirección, telefono, dni));

			}
			br.close();
		} catch (Exception e) {
		}
	}
}
