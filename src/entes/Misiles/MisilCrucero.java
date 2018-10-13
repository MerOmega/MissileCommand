package entes.Misiles;

import java.awt.Image;

import entes.Posicion;

public class MisilCrucero extends Misil {

	protected Image Imagen;
	protected Posicion posInicial;
	protected Posicion posFinal;

	public MisilCrucero(double d, double x, double y, int i) {
//		la variable d es para indicar la posicion minima a la cual puede llegar el cohete 
//		por ejemplo si es MBA el minimo es la raya imaginaria, mientras que en el enemigo el minimo depende si es
//		el borde d el pantalla o desde un avion etc
		super(d, x, y);
		super.setPuntaje(i);
	}

	public void generarUbicacion(double x, double y, boolean donde) {
		if (donde) {
			posInicial = new Posicion(Math.random() * x, y);
		} else {
			posInicial = new Posicion(x, y);
		}

	}

}
