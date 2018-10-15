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
	private static ArrayList<MBA> antibalistico;

	// inicio silo, con cantidad de misiles, misiles actuales y tanto rango de
	// vision como destino de los misiles
	public Silo(double x, double y, double rx, double ry) {
		// seteo cant de misiles por silo y ubicacion del silo
		super(x, y);
		this.cantMisiles = 3;
		// vector
		this.cantMisActual = this.cantMisiles;
		antibalistico = new ArrayList<MBA>();
		setRangoVision(rx, ry);
		seteoMisiles(false);

	}

	public void setRangoVision(double x, double y) {
		rangoVision = new Posicion(x, y);
	}

	// Setea dependiendo que pasa, false es un inicio normal de silos, mientras que
	// true significa que fue destruido
	// y elimina todos los misiles

	public void seteoMisiles(boolean accion) {
		if (accion != true) {
			for (int i = 0; i < cantMisiles; i++) {
				MBA mis = new MBA(500, rangoVision.getX(), rangoVision.getY());

				antibalistico.add(mis);
			}
		} else {
			// elimino M
			antibalistico.clear();
		}
	}

	// Les da la ubicacion destino
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

	// sobreescribe al padre, agregandole una salida por pantalla y eliminando los
	// misiles que quedan
	@Override
	public void entidadDestruida() {
		super.entidadDestruida();
		seteoMisiles(true);
		System.out.println("Silo" + this.getClass().getSimpleName() + " ha sido destruido!");
	}

	@Override
	public boolean isDestruida() {
		return super.isDestruida();
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
