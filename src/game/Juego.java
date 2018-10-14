package game;

import java.awt.Canvas;

import javax.swing.JOptionPane;

import entes.Posicion;
import gestores.Gestor;

public class Juego extends Canvas {
	public static void mnsj(int nro) {
		System.out.println("Parada" + nro);
	}

	private Juego(Posicion pos) {

		Gestor gestor = new Gestor(pos.getX(), pos.getY());
	}

	public void fin() {
		JOptionPane.showMessageDialog(this, "Fin del Juego", "FIN", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	public static void main(String[] args) {
		Posicion tam = new Posicion();
		tam.setX(525);
		tam.setY(480);
		Juego juego = new Juego(tam);
	}

}
