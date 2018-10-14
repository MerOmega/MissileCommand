package entes;

import java.awt.geom.Area;

public class Explosion extends Entidad {

	private Image img;
	
	@Override
	public Posicion getPosicion() {
		// TODO Auto-generated method stub
		return super.getPosicion();
	}

	@Override
	public void setPosicion(Posicion posicion) {
		// TODO Auto-generated method stub
		super.setPosicion(posicion);
	}

	@Override
	public void setPosicion(double x, double y) {
		// TODO Auto-generated method stub
		super.setPosicion(x, y);
	}
	
	private void generarImagen(double x, double y) {
		
		
	}


	public Explosion(double x, double y) {
		super(x, y);
		generarImagen(x, y);
		System.out.println("Se ha producido una explosion!");
	}
	
	//No termino todavia de darme cuenta el tipo con el cual deberia devolver el area
	public void areaExplosion(double x, double y){
		area(x,y);
	}
	
	private void area(double x, double y){
		double h=this.getImg().getHeight(null);//Alto de la imagen
		h/=2;
		double w=this.getImg().getWidth(null);//Ancho de la imagen
		w/=2;
		Posicion p1=new Posicion(x,y-h);//Estas posiciones serian los puntos 
		Posicion p2=new Posicion(x,y+h);//en pantalla que encierran al area 
		Posicion p3=new Posicion(x-w,y);//de explosion
		Posicion p4=new Posicion(x+w,y);
		
	} // 
	
	
	

	/*
	 * private static boolean seChocan(Point2D.Double p1, double r1, Point2D.Double
	 * p2, double r2) { final double a = r1 + r2; final double dx = p1.x - p2.x;
	 * final double dy = p1.y - p2.y; return a > (dx * dx + dy * dy); }
	 * 
	 * 
	 * 
	 * Para ver si un misil choca con un silo o ciudad tendria que usar el alto y
	 * ancho de las imagenes de cada uno para tener el radio de ubicacion y comparar
	 * con el destino final del mbi(si es que no exploto antes con un mba)
	 * 
	 * El metodo choca tiene que estar en Entidad, para saber que tipo de objetos
	 * chocaron.
	 * 
	 */

}
