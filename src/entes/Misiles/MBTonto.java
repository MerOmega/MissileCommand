package entes.Misiles;

import java.util.LinkedList;

import entes.Entidad;
import entes.Posicion;
import taller2.grafico.Dibujable;
import taller2.grafico.InformacionDibujable;

public class MBTonto extends MisilCrucero implements Dibujable {

	// donde indica si se disparo desde el tope o si lo disparo un satelite/avion
	private boolean donde;

	public MBTonto(double x, double y, boolean donde) {
		// Posicion Minima y maxima del misil
		super(0.0, x, y, 25);
		this.donde = donde;
		generarUbicacion(x, y, donde);
	}

	// Metodo de ubicacion, en caso de que salga del tope de la pantalla
	public void generarUbicacion(double x, double y, boolean donde) {

		super.generarUbicacion(x, y, donde);

	}

	private void ubiRandom(LinkedList<Entidad> target) {
		Posicion targetPos = new Posicion();
		int valor = (int) (Math.random() * 8);
		targetPos = target.get(valor).getPosicion();
		this.destino = targetPos;
	}

	public void generarDestino(LinkedList<Entidad> L, double x, double y) {
		ubiRandom(L);

	}

	// division del misil
	public MBTonto fork() {
		// completar con posicion actual del misil
		Posicion posIni2 = new Posicion();
		MBTonto mib2 = new MBTonto(posIni2.getX(), posIni2.getY(), this.donde);
		// sigue
		return mib2;
	}

	@Override
	public InformacionDibujable getInformacionDibujable() {
		return super.getInformacionDibujable();
	}

}
