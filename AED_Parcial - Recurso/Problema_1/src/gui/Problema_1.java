package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clase.Empleado;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;

public class Problema_1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JButton btnProcesar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema_1 frame = new Problema_1();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Problema_1() {
		setTitle("Problema_1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(173, 11, 89, 23);
		contentPane.add(btnProcesar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 408, 541);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}

	protected void actionPerformedBtnProcesar(ActionEvent arg0) {

		Empleado a = new Empleado(622,"Juana","Paredes",3);
		listado(a);

		Empleado b = new Empleado(566,"Almendra");
		listado(b);
		
		Empleado c = new Empleado("Diana");
		listado(c);
		
		Empleado d = new Empleado();
		listado(d);
		
		imprimir("------------------------------------");
		imprimir("Cantidad de objetos creados :  " + Empleado.getCantidad());
		imprimir("Suma de sueldos acumulados  :  " + String.format("%,5.2f",Empleado.getSumasueldos()));
		imprimir("Factor descuento            :  " + Empleado.FACTOR_DSCTO);
		imprimir("------------------------------------");
			
		
	}

	void imprimir() {
		imprimir("");
	}
	
	void listado(Empleado x) {
		imprimir("DirMem\t\t:  " + x);
		imprimir("Codigo\t\t:  " + x.getCodigo());
		imprimir("Nombre\t\t:  " + x.getNombre());
		imprimir("Apellido\t:  " + x.getApellidos());
		imprimir("Categoria\t:  " + x.getCategoria());
		imprimir("Sueldo bruto\t:  " + x.sueldoBruto());
		imprimir("Descuento\t:  " + String.format("%,5.2f",x.descuento()));
		imprimir("Sueldo neto\t:  " + String.format("%,5.2f",x.sueldoNeto()));
		imprimir();
	}
	
	
	
	
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
}
