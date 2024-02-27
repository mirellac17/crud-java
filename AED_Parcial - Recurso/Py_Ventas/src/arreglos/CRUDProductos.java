package arreglos;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class CRUDProductos extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUDProductos frame = new CRUDProductos();
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
	public CRUDProductos() {
		setTitle("Productos");
		setBounds(100, 100, 450, 300);

	}

}
