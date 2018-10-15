package entes;

import java.awt.Image;

public class Explosion extends Entidad {

	private Image img;
	private Posicion[] areaE;

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

	public Posicion[] getAreaE() {
		return areaE;
	}

	public void setAreaE(Posicion[] areaE) {
		this.areaE = areaE;
	}

	public Explosion(double x, double y) {
		super(x, y);
		generarImagen(x, y);
		radioExplosion(x, y);
		System.out.println("Ha ocurrido una explosion!");
	}

	public void radioExplosion(double x, double y) {
		radio(x, y);
	}

	private void radio(double x, double y) {
		double h = this.getImg().getHeight(null);// Alto de la imagen
		h /= 2;
		double w = this.getImg().getWidth(null);// Ancho de la imagen
		w /= 2;
		Posicion[] areaE = new Posicion[4];
		areaE[0] = new Posicion(x, y - h);// Estas posiciones serian los puntos
		areaE[1] = new Posicion(x, y + h);// en pantalla que encierran al area
		areaE[2] = new Posicion(x - w, y);// de explosion
		areaE[3] = new Posicion(x + w, y);
		this.setAreaE(areaE);
	}

	private Image getImg() {
		// TODO Auto-generated method stub
		return null;
	}

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
