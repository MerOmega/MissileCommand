package entes.Misiles;

import entes.Entidad;
import entes.Posicion;
import taller2.grafico.InformacionDibujable;

public class Misil extends Entidad {

	protected Posicion posMin;
	protected Posicion posMax;
	protected Posicion destino;
	protected double velocidad;
	private int puntaje;

	public Misil(double y1, double x, double y) {
		super();
		posMin = new Posicion(x, y1);
		posMax = new Posicion(x, y);
		// TODO Auto-generated constructor stub
	}

	public Misil() {

	}

	public Posicion getPosMin() {
		return posMin;
	}

	public void setPosMin(Posicion posMin) {
		this.posMin = posMin;
	}

	public Posicion getPosMax() {
		return posMax;
	}

	public void setPosMax(Posicion posMax) {
		this.posMax = posMax;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	@Override
	public InformacionDibujable dibujar() {
		InformacionDibujable misil = new InformacionDibujable((int) this.destino.getX(), (int) this.destino.getY(),
				'M');
		return misil;
	}

	public void generarUbicacion() {

	}

	public void generarDestino() {

	}
}
