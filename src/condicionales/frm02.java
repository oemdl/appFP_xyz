package condicionales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm02 extends JFrame {
	private static final long serialVersionUID = 1L;
	JTextField txtUnidades;
	JTextArea txaRpta;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm02 frame = new frm02();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frm02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 300, 420);
		setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblUnidades = new JLabel("Unidades :");
		lblUnidades.setBounds(50, 50, 80, 30);
		getContentPane().add(lblUnidades);

		txtUnidades = new JTextField();
		txtUnidades.setBounds( 130, 50, 100, 30);
		txtUnidades.setHorizontalAlignment( SwingConstants.RIGHT );
		txtUnidades.setMargin( new Insets(5, 5, 5, 5) );
		getContentPane().add(txtUnidades);

		txaRpta = new JTextArea();
		txaRpta.setFocusable(false);
		txaRpta.setMargin( new Insets(5, 5, 5, 5) );
		
		JScrollPane scrollPane = new JScrollPane(txaRpta);
		scrollPane.setBounds(50, 90, 200, 200);
		getContentPane().add(scrollPane);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds( 80, 330, 100, 30);
		btnCalcular.setMnemonic('a');
		getContentPane().add(btnCalcular);

		btnCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCalcular_actionPerformed();
			}
		});

	}

	protected void btnCalcular_actionPerformed() {
		int unidades = Integer.parseInt( txtUnidades.getText() );

		int precio = 20 * unidades;
		if ( unidades >= 26 && unidades <= 50 ) precio = 25;
		else if ( unidades > 50 ) precio = 23;
	
		double compra = precio * unidades;

		//double descuento = 0.16;
		//if ( compra <= 500 ) descuento = 0.12;
		//else if ( compra > 500 && compra <= 700 ) descuento = 0.14;
		//descuento *= compra;

		double descuento = compra * ( compra <= 500 ? 0.12 : compra > 700 ? 0.16 : 0.14 );
		double total = compra - descuento;

		int caramelos = unidades <= 50 ? 5 : unidades > 100 ? 15 : 10;

		txaRpta.setText("");
		txaRpta.append( String.format("Compra\tS/ %.2f\n", compra ) );
		txaRpta.append( String.format("Descuento\tS/ %.2f\n", descuento ) );
		txaRpta.append( String.format("Total \tS/ %.2f\n", total ) );
		txaRpta.append( String.format("Caramelos \t%s", caramelos ) );
	}

}