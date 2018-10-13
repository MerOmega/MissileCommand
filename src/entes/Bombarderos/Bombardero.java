package entes.Bombarderos;

import java.awt.Image;

import entes.Entidad;
import entes.Posicion;

public class Bombardero extends Entidad {
	protected Image Imagen;
	protected Posicion posDestino;
	protected Posicion tamPantalla;

	public Bombardero(double x, double y, Posicion pantalla) {
		// Por defecto tiene posicion y es visible
		super(x, y);
		this.tamPantalla = pantalla;
	}

	/////// Si su posicion inicial es en x 0, se desplaza hasta el otro extremo de
	/////// la pantalla
	////// si es al reves, va desde x que es el extremo de la pantalla al otro lado

	public void desplazamiento() {
		if (this.getPosicion().getX() == 0) {
			this.posDestino = new Posicion(this.tamPantalla.getX(), super.getPosicion().getY());
		} else {
			this.posDestino = new Posicion(0, super.getPosicion().getY());
		}
	}

	@Override
	public void entidadDestruida() {
		super.entidadDestruida();
	}
}
