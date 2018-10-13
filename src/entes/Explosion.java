package entes;

import java.awt.geom.Point2D;

import javax.swing.*;

public class Explosion extends Entidad {


	public Explosion(double x, double y) {
		super(x, y);
	}

	private static boolean seChocan(Point2D.Double p1, double r1, Point2D.Double p2, double r2) 
	{ 	//suponiendo que los dibujos de los objetos se aproximan a circulos se podria calcular 
		//la distancia entre los mismos, la cual si es menor a
	    final double a = r1 + r2; //radio de objeto 1 mas objeto 2
	    final double dx = p1.x - p2.x; //diferencia en x
	    final double dy = p1.y - p2.y; //diferencia en y
	    return a > (dx * dx + dy * dy); 
	} 
	
	
	
	
}
