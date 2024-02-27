package clase;

public class Empleado {

	//  Atributos privados
	private int codigo;
	private String nombre, apellidos;
	private int categoria;
	
	//  Variable privada de clase
	private static int cantidad;
	private static double sumasueldos;

    //  Constante pública de clase 
    public static final double FACTOR_DSCTO;
    
	//  Bloque de inicialización
	static {
		cantidad = 0;
		sumasueldos = 0;
		FACTOR_DSCTO = 0.13;
	}

	public Empleado(int codigo, String nombre, String apellidos, int categoria) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.categoria = categoria;
		cantidad ++;
		sumasueldos +=sueldoNeto(); 
	}
	
	
	public Empleado(int codigo, String nombre){
		this(codigo, nombre, "Lopez", 2);}
	
	
	public Empleado(String nombre){
		this(953641214 , nombre, "Rodriguez", 1);}
	
	
	public Empleado() {
		this(54321, "Pedro" );}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public static void setCantidad(int cantidad) {
		Empleado.cantidad = cantidad;
	}

	public static void setSumasueldos(double sumasueldos) {
		Empleado.sumasueldos = sumasueldos;
	}


	
	public int getCodigo() {
		return codigo;
	}


	
	public String getNombre() {
		return nombre;
	}


	
	public String getApellidos() {
		return apellidos;
	}


	
	public int getCategoria() {
		return categoria;
	}


	
	public static int getCantidad() {
		return cantidad;
	}


	
	public static double getSumasueldos() {
		return sumasueldos;
	}


	
	public static double getFactorDscto() {
		return FACTOR_DSCTO;
	}
	
	
	//Metodos de calculo
	
	public double sueldoBruto() {
		double sueldo=0;
		
		switch (categoria) {
			case 0:
				sueldo=980.0;
				break;
			case 1:
				sueldo=1450.0;
				break;
			case 2:
				sueldo=1740.0;
				break;
			case 3:
				sueldo=2150.0;

			default:
				break;
		}
	
		return sueldo;}
	
	
	public double descuento() {
		
		return sueldoBruto()*FACTOR_DSCTO;}
	
	
	public double sueldoNeto() {
		
		return sueldoBruto()-descuento() ;}
	
	
	
}
