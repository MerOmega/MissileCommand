package entes.Misiles;

import java.util.LinkedList;

import entes.Entidad;
import entes.Posicion;
import taller2.grafico.InformacionDibujable;

public class MBInteligente extends MisilCrucero {

	public MBInteligente(double d, double x, double y, int i) {
		super(d, x, y, 25);
	}

	// Metodo que evada el misil proximamente
	private void PosicionEvasion() {

	}

	@Override
	public void generarUbicacion(double x, double y, boolean donde) {
		super.generarUbicacion(x, y, donde);
	}

	@Override
	public InformacionDibujable dibujar() {
		return super.dibujar();
	}

	private void ubiRandom(LinkedList<Entidad> target) {
		Posicion targetPos = new Posicion();
		int valor = (int) (Math.random() * 8);
		targetPos = target.get(valor).getPosicion();
		this.destino = targetPos;
	}
}
