package gestores;

import java.util.LinkedList;

import entes.Entidad;
import entes.Posicion;
import entes.Estructuras.Ciudad;
import entes.Estructuras.Silo;

public class Gestor {
	static int MisilesPorNivel;
	private boolean nivelTerminado;
	private boolean juegoTerminado;
	private int MisilesUsadosEnOleada;
	private int puntajeTotal;
	private Posicion pos;
	LinkedList<Entidad> estructuras = new LinkedList<Entidad>();
	Nivel nivel = new Nivel();

	public Gestor(double x, double y) {
		MisilesPorNivel = (int) (Math.random() * 17 + 12);
		this.nivel.setNivel(1);
		puntajeTotal = 0;
		// Referente a tamaño de pantalla
		pos.setX(x);
		pos.setY(y);
	}

	public int transferirPuntos() {
		return this.puntajeTotal;
	}

	//
	public void puntajes() {
		if (nivelTerminado) {
			this.puntajeTotal += nivel.getPuntaje();
		}
	}
	
	private boolean bonusCity(){
		return this.puntajeTotal/bonusCity>=1;
	}
	
	private int bonus(){
		return this.puntajeTotal/bonusCity;
	}

	private void init() {
		initCiudad();
		initSilo();
	}

<<<<<<< HEAD
	private void initCiudad(LinkedList<Entidad> e) {
		int cantEstructuras = 9;
		double x = 0;
		double y = 0;
		int cantSilos = 3;
		int cantCiudades = 6;
		double separacionEnX = pos.getY() / cantEstructuras; // 9 es la cantidad de estructuras
		// por ej la pantalla en y es de 525, es decir que entre ciudad/silo hay un
		// espacio de 58,3 entre cada uno
		double ry = 0;
		double rx = pos.getX() / cantSilos;
		for (int i = 1; i < 3; i++) {
			Silo silo = new Silo(x, 440, rx);

		}
		rx=pos.getX()/cantCiudades;
		LinkedList<Ciudad> lCiudades=new LinkedList<Ciudad>();
		lCiudades=null;
		for(int i=0; i<cantCiudades; i++){
			Ciudad ciudad=new Ciudad(rx,y);
			lCiudades.add(ciudad);
		}
=======
	//// Inicializadores

	private void initSilo() {
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
>>>>>>> 659bf187b3a50ad485c44aeccc13249560c1dd10

		estructuras.add(new Ciudad(320, 465));
		estructuras.add(new Ciudad(378, 465));
		estructuras.add(new Ciudad(436, 465));
	}
	
	public void avanzar(){
		if(this.bonusCity()){
			if(this.bonus()>
		}
		
		
	}
	

	/*
	 * if (mib==0) { if (ciudades != 0 || bonus city >=1) { avanzar(){
	 * System.out.println("pasa al siguiente nivel"+n); imprimir en pantalla el nro
	 * de nivel al que se pasa;
	 * 
	 * volver a generar el random de mbi; resetear los silos;
	 * 
	 * linkedList<ciudad> ciudades=new linkedList<Ciudad>(n,x,y); resetear las
	 * ciudades correspondientes(usar los bonus city); } } }
	 * 
	 */

}
