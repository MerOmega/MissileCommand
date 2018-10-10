package entes;

public class Misil extends Entidad{

	protected Posicion posMin;
	protected Posicion posMax;
	protected double velocidad;
    private int puntaje;
	
	public Misil(double y1,double x, double y,int puntaje) {
		super();
		posMin = new Posicion(x,y1);
		posMax = new Posicion(x,y);
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


	public void generarUbicacion(double n) {
		
	}
	
	public void generarDestino() {
		
	}
}
