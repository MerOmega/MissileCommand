package entes.Misiles;

import entes.Entidad;
import entes.Posicion;
import taller2.grafico.Dibujable;
import taller2.grafico.InformacionDibujable;

public class MBA extends Misil implements Dibujable {

	private boolean usado;

	public MBA(double y1, double x, double y) {
		super(y1, x, y);
		usado = false;
	}

	public MBA() {
		// TODO Auto-generated constructor stub
	}

	public void generarUbicacion(Entidad silo) {
		System.out.println("Misil disparado desde silo:" + silo.getClass().getSimpleName() + "\n");
	}

	public void usado() {
		usado = true;
	}

	public Posicion destino(Posicion pos) {
		// en el recuento de puntos no se toma en cuenta si esta usado
		this.usado();
		// protected, esta en la clase Misil
		this.destino = pos;
		System.out.println("Misil disparo en la posicion " + pos.toString());
		return pos;
	}

	@Override
	public InformacionDibujable dibujar() {
		return super.dibujar();
	}

}
