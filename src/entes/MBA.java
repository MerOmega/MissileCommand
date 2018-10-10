package entes;


public class MBA extends Misil {
	
	private boolean usado;
	
	public MBA(double y1,double x, double y) {
		super(y1,x,y);
		usado=false;
	}
	
	public void generarUbicacion() {
		
	}
	
	public void usado() {
		usado=true;
	}
	
	
	public void destino(Posicion pos) {
		System.out.println("Misil disparo en la posicion " + pos.toString());
	}

}
