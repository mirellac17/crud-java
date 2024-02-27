package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import examen.ArregloCodigos;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Problema_2 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JTextField txtCodigo;
	private JLabel lblCodigo;
	private JButton btnInterCambio1;
	private JButton btnEliminarPrimero;
	private JButton btnEliminarCodigo;
	private JButton btnAdicionar;

	ArregloCodigos a = new ArregloCodigos();
	private JButton btnInterCambio2;

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
					Problema_2 frame = new Problema_2();
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
	public Problema_2() {
		setTitle("Problema_2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 225, 412);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scrollPane.setViewportView(txtS);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(66, 8, 169, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 11, 46, 14);
		contentPane.add(lblCodigo);

		btnInterCambio1 = new JButton("Intercambio 1");
		btnInterCambio1.addActionListener(this);
		btnInterCambio1.setBounds(247, 7, 213, 23);
		contentPane.add(btnInterCambio1);
		
		btnEliminarPrimero = new JButton("Eliminar Primero");
		btnEliminarPrimero.addActionListener(this);
		btnEliminarPrimero.setBounds(245, 85, 215, 23);
		contentPane.add(btnEliminarPrimero);
		
		btnEliminarCodigo = new JButton("Eliminar C\u00F3digo");
		btnEliminarCodigo.addActionListener(this);
		btnEliminarCodigo.setBounds(245, 119, 215, 23);
		contentPane.add(btnEliminarCodigo);
		
		JButton button = new JButton("Intercambio 1");
		button.setBounds(247, 7, 213, 23);
		contentPane.add(button);
		
		btnInterCambio2 = new JButton("Intercambio 2");
		btnInterCambio2.addActionListener(this);
		btnInterCambio2.setBounds(245, 40, 213, 23);
		contentPane.add(btnInterCambio2);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(245, 153, 215, 23);
		contentPane.add(btnAdicionar);
	}

	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource() == btnInterCambio1) {
			actionPerformedbtnInterCambio1(arg0);
		}
		if (arg0.getSource() == btnInterCambio2) {
			actionPerformedBtnInterCambio2(arg0);
		}
		if (arg0.getSource() == btnEliminarCodigo) {
			actionPerformedEliminarCodigo(arg0);
		}
		if (arg0.getSource() == btnEliminarPrimero) {
			actionPerformedBtneliminarPrimero(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}

	//==========================================================================================
	
//  Declaraci�n global
	ArregloCodigos ac = new ArregloCodigos();
	
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		try {
			ac.adicionar(leerCodigo());
			listar();
		}
		catch (Exception e) {
			mensaje("error de ingreso");
		}	
	}

	protected void actionPerformedbtnInterCambio1(ActionEvent arg0) {
		try {ac.intercambiarSegPen();
		listar();
		} 
		catch (Exception e) {mensaje ("El arreglo est� vacio");}
	}
	
	
	protected void actionPerformedBtneliminarPrimero(ActionEvent arg0) {
		try {ac.eliminarPrimero();
		listar();
		} 
		catch (Exception e) {mensaje ("El arreglo est� vacio");}
	
		
	}
	
	protected void actionPerformedBtnInterCambio2(ActionEvent arg0) {
		try {ac.intercambiarCodigo();
		listar();
		} 
		catch (Exception e) {mensaje ("El arreglo est� vacio");}}
	
		
	protected void actionPerformedEliminarCodigo(ActionEvent arg0) {
			try {ac.eliminarCodigo();
			listar();
			} 
			catch (Exception e) {mensaje ("El arreglo est� vacio");}
			
		
	}
	
	//==========================================================================================
	void imprimir() {
		imprimir("");
	}
	
	void limpiar() {
		txtCodigo.setText("");
		txtCodigo.requestFocus();
	}
	

	void listar() {
		txtS.setText("");
		for (int i = 0; i < ac.tamano(); i++) {
			imprimir("codigo[" + i + "] : " + ac.obtener(i));
		}
	}
	
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	

	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}

	

	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}
	

}
