package gui;
import java.awt.EventQueue;
//import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
//import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
//import javax.swing.SwingConstants;

public class AltaCliente extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaCliente frame = new AltaCliente();
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
	public AltaCliente() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("AltaCliente");
		setBounds(100, 100, 533, 446);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alta de Cliente");
		lblNewLabel.setBounds(182, 25, 83, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Código");
		lblNewLabel_1.setBounds(20, 48, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Teléfono");
		lblNewLabel_2.setBounds(20, 107, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(72, 48, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(72, 73, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(72, 104, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setBounds(20, 73, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 135, 404, 124);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nombre", "Tel\u00E9fono"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setIcon(new ImageIcon(AltaCliente.class.getResource("/imagenes/Img/add-file16.png")));
		btnListar.setBounds(93, 270, 89, 23);
		getContentPane().add(btnListar);
		
		JButton btnReportar = new JButton("Reportar");
		btnReportar.setIcon(new ImageIcon(AltaCliente.class.getResource("/imagenes/Img/hoja-de-calculo16.png")));
		btnReportar.setBounds(246, 270, 89, 23);
		getContentPane().add(btnReportar);
		
		JButton btnNewButton_2 = new JButton("Agregar");
		btnNewButton_2.setIcon(new ImageIcon(AltaCliente.class.getResource("/imagenes/Img/delete16.png")));
		btnNewButton_2.setBounds(269, 103, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 304, 404, 94);
		getContentPane().add(textArea);

	}
}

