package entes;

import java.awt.Image;

public class MisilCrucero extends Misil {

	protected Image Imagen;

	public MisilCrucero(double d, double x, double y, int i) {
		super(d, x, y);
		super.setPuntaje(i);
	}

	public void generarUbicacion(double n) {
		// TODO Auto-generated method stub

	}

}
