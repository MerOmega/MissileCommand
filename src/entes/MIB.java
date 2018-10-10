package entes;

import java.util.LinkedList;

public class MIB extends MisilCrucero {
	
	private Posicion posInicial;
	private Posicion posFinal;

	public MIB(double x, double y) {
		super(0.0,x, y,25);
		generarUbicacion(y);
	}

	
	
	public void generarUbicacion(double x) {
		posInicial = new Posicion(Math.random()*x,0);
		
	}
	
	private Posicion ubiRandom(LinkedList<Entidad> target) {
		Posicion targetPos = new Posicion();
		int valor = (int) (Math.random()*8);
		targetPos = target.get(valor).getPosicion();
		return targetPos;
	}
	
	
	public void generarDestino(LinkedList<Entidad> L,double x, double y) {
		posFinal = ubiRandom(L);
		
	}
	
	

}
