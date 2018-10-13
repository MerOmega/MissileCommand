package game;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Juego extends Canvas {
	// indicador de serie para saber si es mi clase u otra
	private static final long serialVersionUID = 1L;
	// una unica ventana
	private static JFrame ventana;
	private static int ANCHO = 525;
	private static int ALTO = 480;
	private static final String Nombre = "Missile Commander";

	// una sola instancia del juego le paso ancho y alto
	private Juego() {
		setPreferredSize(new Dimension(ANCHO, ALTO));
		ventana = new JFrame(Nombre);
		// Sale sin que quede en 2do plano y permite redimensionar
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(true);
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		// el tamaño se ajusta a lo de adentro
		ventana.pack();
		// la ventana en el centro del escritorio
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
		/*
		 * mostrar menu; gestor.iniciar(); crear las ciudades; crear silos; nuevo
		 * jugador;
		 * 
		 */
		fin();
	}
	
	public void fin() {
		JOptionPane.showMessageDialog(this, "Fin del Juego", "FIN", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	public static void main(String[] args) {
		System.out.println("Imprimir");
		for (int i = 0; i < 2; i++) {
			System.out.println(i);
		}
		// Juego juego = new Juego();
	}

}
