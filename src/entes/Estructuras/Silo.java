package entes.Estructuras;

import java.util.ArrayList;

import entes.Entidad;
import entes.Posicion;
import entes.Misiles.MBA;

public class Silo extends Entidad {
	final private int cantMisiles;
	private int puntajeMisil;
	private int cantMisActual;
	private Posicion rangoVision;
	private ArrayList<MBA> antibalistico;

	public Silo(double x, double y, double rx, double ry) {
		// seteo cant de misiles por silo y ubicacion del silo
		super(x, y);
		this.cantMisiles = 3;
		// vector
		this.cantMisActual = this.cantMisiles;
		antibalistico = new ArrayList<MBA>();
		seteoMisiles(false);
		setRangoVision(rx, ry);
	}

	public void setRangoVision(double x, double y) {
		rangoVision = new Posicion(x, y);
	}

	public void seteoMisiles(boolean accion) {
		if (accion != true) {
			for (int i = 0; i < cantMisiles; i++) {
				System.out.println(i);
				antibalistico.add(new MBA(500, rangoVision.getX(), rangoVision.getY()));
			}
		} else {
			// elimino M
			antibalistico.clear();
		}
	}

	public void disparar() {

		for (int i = 0; i > antibalistico.size(); i++) {

			antibalistico.get(i).destino(posDeDisparo());
		}
	}

	// Devuelve la posicion de disparo
	public Posicion posDeDisparo() {
		Posicion posicion = new Posicion(Math.random() * this.rangoVision.getX(),
				Math.random() * this.rangoVision.getY());
		return posicion;
	}

	public void isDestruido() {
		super.entidadDestruida();
		seteoMisiles(true);
		System.out.println("Silo" + this.getClass().getSimpleName() + " ha sido destruido!");
	}

	public int getPuntaje() {
		return cantMisActual;
	}

	public void soloCuandoTermina() {
		this.reset();
	}

	public void reset() {
		super.setDestruida();
	}

	public void actualizar() {
		if (super.isDestruida()) {
			seteoMisiles(true);
		}

	}

}
