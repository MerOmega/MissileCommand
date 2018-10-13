package entes.Misiles;

import java.util.LinkedList;

import entes.Entidad;
import entes.Posicion;

public class MBInteligente extends MisilCrucero {

	public MBInteligente(double d, double x, double y, int i) {
		super(d, x, y, i);
	}

	private void ubiRandom(LinkedList<Entidad> target) {
		Posicion targetPos = new Posicion();
		int valor = (int) (Math.random() * 8);
		targetPos = target.get(valor).getPosicion();
		this.destino = targetPos;
	}
}
