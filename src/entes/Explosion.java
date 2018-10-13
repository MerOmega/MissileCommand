package entes;

import java.awt.geom.Point2D;

import javax.swing.*;

public class Explosion extends Entidad {
	
	private Area area;//area va a ser una clase de las librerias la tengo que buscar
	
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

	public Explosion(double x, double y) {
		super(x, y);
		generarImagen(x,y);
	}

	public Area getArea() {
		return area;
	}//el gestor va a pedir el area para corroborar si en la misma hay o no una colision
	

	public void setArea(Area area) {
		this.area = area;
	}
	
	/*
	private static boolean seChocan(Point2D.Double p1, double r1, Point2D.Double p2, double r2) 
	{ 
	    final double a = r1 + r2; 
	    final double dx = p1.x - p2.x; 
	    final double dy = p1.y - p2.y; 
	    return a > (dx * dx + dy * dy); 
	} 
	
	
	
	 * Para ver si un misil choca con un silo o ciudad tendria que usar el alto y ancho de las imagenes
	 * de cada uno para tener el radio de ubicacion y comparar con el destino final del mbi(si es que 
	 * no exploto antes con un mba)
	 * 
	 *El metodo choca tiene que estar en Entidad, para saber que tipo de objetos chocaron. 
	 * 	
	*/
	
	
}
