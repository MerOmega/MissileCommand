package entes;

import java.awt.geom.Point2D;

import javax.swing.*;

public class Explosion extends Entidad {

	
	/*
	 * Una explosion se va a dar cuando dos objetos o dos imagenes diferentes se choquen; 
	 * la posicion de la explosion se va a dar por el cruce de los objetos, del choque me 
	 * tengo que quedar con la posicion de donde ocurrio y esa va a ser la posicion de la explosion
	 * 
	 * si (objeto 1 intersecta objeto 2) >> hay colision:
	 *  -se genera la imagen de la explosion en pantalla en la ubicacion de la misma.
	 *  -se saca de pantalla las imagenes de los dos objetos;
	 * 	-si el objeto 2 es una ciudad:
	 * 		::se declara como destruida;
	 * 		
	 * 	-Si el objeto 2 es un silo:
	 * 		::se declara como destruido;
	 * 		::se inhabilita su uso;
	 * 		
	 * 	-Si el objeto 2 es un mbi:
	 * 		::se suman los puntos correspondientes; 
	 * 
	 * y esto lo tiene que hacer el gestor no va aca... 
	 * 
	 */
	
	
	
	
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

	private static boolean seChocan(Point2D.Double p1, double r1, Point2D.Double p2, double r2) 
	{ 
	    final double a = r1 + r2; 
	    final double dx = p1.x - p2.x; 
	    final double dy = p1.y - p2.y; 
	    return a > (dx * dx + dy * dy); 
	} 
	
	
	/*
	 * Para ver si un misil choca con un silo o ciudad tendria que usar el alto y ancho de las imagenes
	 * de cada uno para tener el radio de ubicacion y comparar con el destino final del mbi(si es que 
	 * no exploto antes con un mba)
	 * 
	 *El metodo choca tiene que estar en Entidad, para saber que tipo de objetos chocaron. 
	 * 	
	*/
	
	
}
