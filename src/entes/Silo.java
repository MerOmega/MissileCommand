package entes;

public class Silo extends Entidad {
	final private int cantMisiles;
	private int puntajeMisil;
	private int cantMisActual;
	private Posicion rangoVision;
	
	public Silo(double x, double y, double rx, double ry) {
		//seteo cant de misiles por silo y ubicacion del silo
		super(x,y);
		this.cantMisiles=3;
		this.cantMisActual=this.cantMisiles;
		setRangoVision(rx,ry);
	}
	
	public void setRangoVision(double x, double y) {
		rangoVision = new Posicion(x,y);
	}
	
	//Devuelve la posicion de disparo
	public Posicion disparar() {
		Posicion posicion = new Posicion(Math.random() * this.rangoVision.getX(),Math.random() * this.rangoVision.getY());
		return posicion;
	}
	
	public void isDestruido() {
		super.isDestruida();
		System.out.println("Silo" + this.getClass().getSimpleName() + " ha sido destruido!");
	}
	
	public int Puntaje(int puntajeXMisil) {
		return cantMisActual*puntajeXMisil;
	}
	
}
