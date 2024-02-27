package examen;

public class ArregloCodigos {
	private int codigo[];
	private int indice;

	public ArregloCodigos() {
		codigo = new int[10];
		indice = 0;
	}

	public int tamano() {
		return indice;
	}

	public double obtener(int p) {
		return codigo[p];
	}

	public void adicionar(int cod) {
		if (indice == tamano())
			ampliarArreglo();
		codigo[indice] = cod;
		indice++;
	}

	private void ampliarArreglo() {
		int aux[] = codigo;
		codigo = new int[indice + 10];
		for (int i = 0; i < indice; i++)
			codigo[i] = aux[i];
	}

	//================================== CREAR LOS M�TODOS ABAJO =========================================
	
	private void intercambiar (int pos1, int pos2){	
		int aux = codigo[pos1];
		codigo[pos1] = codigo[pos2];
		codigo[pos2] = aux;
		
	}
	
	public int posUltima (){
		for (int i=tamano()-2; i>=0; i--)
			if (codigo[i]>0)
				return i;
		return -1;
	}
	
	public int posSegunda (){
		int pos = 0;
		for(int i=0; i<tamano(); i++){
			if(codigo[i] >= 0)
				pos++;
				if (pos == 2)
					return i;
		}
		return -1; // -1 es que no lo encontr�
	}
	
	public void  intercambiarSegPen (){
		intercambiar (posSegunda (), posUltima ());}
				
	
	
	public int posUltimoCodigo (){
		for (int i=tamano()-1; i>=0; i--)
			if (codigo[i]>= 1000 && codigo [i]<=1111)
				return i;
		return -1;
	}
	
	public int posTercera (){
		int pos = 0;
		for(int i=0; i<tamano(); i++){
			if(codigo[i] >= 0)
				pos++;
				if (pos == 3)
					return i;
		}
		return -1; // -1 es que no lo encontr�
	}
	
	
	public void  intercambiarCodigo (){
		intercambiar (posUltimoCodigo (), posTercera ());}

	
	
	public int posPrimera (){
		int pos = 0;
		for(int i=0; i<tamano(); i++){
			if(codigo[i] >= 0)
				pos++;
				if (pos == 1)
					return i;
		}
		return -1; // -1 es que no lo encontr�
	}
	
	
	
	public void  eliminarPrimero (){
		eliminar (posPrimera ());
				
	}
	
	private void eliminar(int pos) {
		for (int i=pos; i<indice-1; i++)
			codigo[i] = codigo[i+1];
		indice --;
	}
	
	public void  eliminarCodigo (){
		eliminar (posUltimoCodigo());
				
	}
	
	
	
	
}
