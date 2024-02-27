package gui;

import arreglos.ArregloAlumnos;
import clases.Alumno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
//import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;

public class GuiAlumnos extends JInternalFrame {
	ArregloAlumnos a=new ArregloAlumnos();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnListar;
	private JButton btnReportar;
	private JScrollPane scrollPaneA;
	private JScrollPane scrollPaneB;
	private JTextArea txtS;
	private JTable tblTabla;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiAlumnos frame = new GuiAlumnos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiAlumnos() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		//setBounds(100, 100, 450, 300);
		setTitle("Listado general de ventas mostrando en cada caso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
			Alumno a = new Alumno(111,"Marco", 23,15);
			listado(a);
			
			}
		});
	//	btnListar.addActionListener(this);
		btnListar.setBounds(116, 11, 89, 23);
		contentPane.add(btnListar);
		btnReportar = new JButton("Reportar");
	//	btnReportar.addActionListener(this);
		btnReportar.setBounds(209, 11, 89, 23);
		contentPane.add(btnReportar);
		scrollPaneA = new JScrollPane();
		scrollPaneA.setBounds(10, 48, 394, 200);
		contentPane.add(scrollPaneA);
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPaneA.setViewportView(tblTabla);
		modelo = new DefaultTableModel();
		modelo.addColumn("Código de Venta");
		modelo.addColumn("Código de Cliente");
		modelo.addColumn("Código de Producto");
		modelo.addColumn("Fecha");
		modelo.addColumn("Importe Subtotal");
		modelo.addColumn("Importe del IGV");
		modelo.addColumn("Importe total");
		tblTabla.setModel(modelo);
		scrollPaneB = new JScrollPane();
		scrollPaneB.setBounds(10, 252, 394, 200);
		contentPane.add(scrollPaneB);
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPaneB.setViewportView(txtS);
		}
		public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnReportar) {
		actionPerformedBtnReportar(arg0);
		}
		if (arg0.getSource() == btnListar) {
		actionPerformedBtnListar(arg0);
		}
		}

		// Declaración global
		ArregloAlumnos aa = new ArregloAlumnos();
		protected void actionPerformedBtnListar(ActionEvent arg0) {
			
			
			
			
		/**
		* Visualiza el contenido del ArrayList
		*/
		modelo.setRowCount(0);
		for (int i=0; i<aa.tamaño(); i++) {
		Object[] fila = { aa.obtener(i).getCodigo(),
		aa.obtener(i).getNombre(),
		aa.obtener(i).getNota1(),
		aa.obtener(i).getNota2(),
		aa.obtener(i).promedio() };
		modelo.addRow(fila);
		}
		}
		protected void actionPerformedBtnReportar(ActionEvent arg0) {
		/**
		* Muestra un reporte del ArrayList
		*/
		txtS.setText("");
		imprimir("cantidad de alumnos : " + aa.tamaño());
		imprimir("promedio general : " + aa.promedioGeneral());
		}
		
	//	protected void actionPerformedBtnGenerar(ActionEvent arg0) {
			 /* 
			* Remplaza los números por otros aleatorios de tres cifras
			*/
			
			// a.generar();
	//		 txtS.setText("Los números del arreglo han sido cambiados.");
	//		 }
		
		// Métodos tipo void sin parámetros
		void imprimir() {
		imprimir("");
		}
	//	// Métodos tipo void con parámetros
	//	void imprimir(String s) {
	//	txtS.append(s + "\n");
	//	}
		
		protected void actionPerformedBtnProcesar(ActionEvent arg0) {
			Alumno a = new Alumno(12345, "Juan", 13, 15);
			listado(a);
			a.setNota1(19);
			a.setNota2(18);
			listado(a);
			}
			// Métodos tipo void con parámetros
			void listado(Alumno x) {
			imprimir("DirMem : " + x);
			imprimir("código : " + x.getCodigo());
			imprimir("nombre : " + x.getNombre());
			imprimir("nota 1 : " + x.getNota1());
			imprimir("nota 2 : " + x.getNota2());
			imprimir("promedio : " + x.promedio());
			}
			// Métodos tipo void con parámetros
			void imprimir(String s) {
			txtS.append(s + "\n");
			}

		
		
		}

	


