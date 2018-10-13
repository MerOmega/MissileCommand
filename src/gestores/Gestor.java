package gestores;

import java.util.LinkedList;

import entes.Entidad;
import entes.Explosion;
import entes.Posicion;
import entes.Estructuras.Ciudad;
import entes.Estructuras.Silo;
import entes.Misiles.Misil;

public class Gestor {

	private boolean juegoTerminado;
	private int puntajeTotal;
	private static Posicion pos;
	double velocidad;
	static long tiempo;
	static int bonusCity = 10000;

	static LinkedList<Entidad> estructuras = new LinkedList<Entidad>();

	public Gestor(double x, double y) {
		tiempo = System.nanoTime();
		init();
		Nivel nivel = Nivel.getNivel();
		// Referente a tamaño de pantalla
		pos.setX(x);
		pos.setY(y);
		puntajeTotal = 0;

	}

	public int transferirPuntos() {
		return this.puntajeTotal;
	}

	//

	private void setVelocidad() {
		velocidad = (double) tiempo * (double) Nivel.getnroNivel();
	}

	// Inicializo todo
	private void init() {
		initCiudad();
		initSilo();
	}

	//// Inicializadores

	public static void restartCity(LinkedList<Entidad> estructura, int cantidad) {
		initSilo();
		while (cantidad != 0) {
			for (int i = 0; i < estructura.size(); i++) {

				if (estructura.get(i).getClass().getSimpleName().equals("Ciudad")
						&& estructura.get(i).isDestruida() == true) {
					estructura.get(i).setDestruida();
					cantidad--;
				}
			}
		}
	}

	public static void initSilo() {
		double visionPantalla = pos.getX() / 3;
		estructuras.add(new Silo(26, 465, visionPantalla, 0));
		estructuras.add(new Silo(262, 465, visionPantalla * 2, 0));
		estructuras.add(new Silo(pos.getX() - 26, pos.getY() - 15, visionPantalla * 3, 0));

	}

	// ver como hacerlo mas eficiente sin depender de una cantidad fija de pantalla
	private void initCiudad() {
		estructuras.add(new Ciudad(84, 465));
		estructuras.add(new Ciudad(142, 465));
		estructuras.add(new Ciudad(200, 465));

		estructuras.add(new Ciudad(320, 465));
		estructuras.add(new Ciudad(378, 465));
		estructuras.add(new Ciudad(436, 465));
	}

	public void avanzar() {

	}

	public void llegaADestino(Misil a) {
		// if(a.getPosicion()==a.getDestino()){
		// obtener de la estructura de ciudades o silos cual pertenece a esa ubicacion
		// generarExplosion con el misil y el silo o ciudad
	}

	// si el mba llega a destino hay que chequear si hay otro misil en el radio de
	// explosion
	// de ser asi se destruye tambien el mbi
	//

	public void generarExplosion(Entidad a, Entidad b) {
		this.explota(a, b);
	}

	private void explota(Entidad a, Entidad b) {
		a.isDestruida();
		b.isDestruida();
		Explosion e = new Explosion(b.getPosicion().getX(), b.getPosicion().getY());
		// tomo como referencia la posicion de b por si se trata de una ciudad o silo;
	}

	/*
	 * Una explosion se va a dar cuando dos objetos o dos imagenes diferentes se
	 * choquen; la posicion de la explosion se va a dar por el cruce de los objetos,
	 * del choque me tengo que quedar con la posicion de donde ocurrio y esa va a
	 * ser la posicion de la explosion
	 * 
	 * si (objeto 1 intersecta objeto 2) >> hay colision: -se genera la imagen de la
	 * explosion en pantalla en la ubicacion de la misma. -se saca de pantalla las
	 * imagenes de los dos objetos; -si el objeto 2 es una ciudad: ::se declara como
	 * destruida;
	 * 
	 * -Si el objeto 2 es un silo: ::se declara como destruido; ::se inhabilita su
	 * uso;
	 * 
	 * -Si el objeto 2 es un mbi: ::se suman los puntos correspondientes;
	 * 
	 * 
	 * 
	 */

	/*
	 * volver a generar el random de mbi; resetear los silos;
	 * 
	 * linkedList<ciudad> ciudades=new linkedList<Ciudad>(n,x,y); resetear las
	 * ciudades correspondientes(usar los bonus city); } } }
	 * 
	 */

}
