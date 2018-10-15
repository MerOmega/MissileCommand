package gestores;

import java.util.LinkedList;

import entes.Entidad;
import entes.Estructuras.Silo;
import entes.Misiles.MBTonto;
import entes.Misiles.Misil;
import game.Juego;

public class Nivel {
	private static Nivel nivel;

	static int MisilesPorNivelmax = 17;
	static int MisilesPorNivelmin = 12;
	private static boolean nivelTerminado;
	private static boolean usarBonus;
	private static int nroNivel;
	private static int puntaje;
	private static int puntBonus;
	static LinkedList<MBTonto> misiles = new LinkedList<MBTonto>();
	static LinkedList<Entidad> estructuras = Gestor.estructuras;

	// Setea el puntaje en 0 y el nivel inicial en 1
	private Nivel() {
		puntaje = 0;
		Nivel.nroNivel = 1;
	}

	// comienza el nivel, sin bonusCity, indicando que el nivel esta sin terminarse
	public static Nivel getNivel() {
		if (nivel == null) {
			nivel = new Nivel();
			nivelTerminado = false;
			usarBonus = false;
			empezarSimulacion();
			// Recibo las ciudades iniciadas, luego cada vez que termino el nivel verifico
			// si hay bonus city para reconstruirlas
		}
		return nivel;
	}

	// Inicializa los misiles y les da un destino
	private static void initMisiles(double x, double y) {
		int MisilesPorNivel = (int) (Math.random() * MisilesPorNivelmax + MisilesPorNivelmin);
		for (int i = 0; i < MisilesPorNivel; i++) {
			misiles.add(new MBTonto(x, y, false));
			misiles.get(i).generarDestino();
		}
	}

	// reconstruye los silos, y verifica bonusCity
	private static void reiniciar() {
		initMisiles(Juego.ancho, Juego.largo);
		usarBonus = false;
		nivelTerminado = false;
		puntaje = puntBonus = 0;
	}

	// comenzaria la simulacion, evalua puntajes y setea una ronda de misiles, asi
	// como si
	// paso o no la siguiente nivel
	private static void empezarSimulacion() {
		while (Gestor.juegoTerminado != true || Nivel.nroNivel != 3) {

			rondasDeMisiles();
			setPuntaje();
			Gestor.restartCity(estructuras, puntBonus, puntaje);
			evaluar();
			// Evalua si se completo el nivel con exito o perdio pero tiene una bonus city
			if (nivelTerminado == true) {
				siguienteNivel();
			} else if (Gestor.juegoTerminado != true) {
				reiniciar();
			}
		}
	}

	// rona de mba
	private static void rondaMisilesMba() {
		for (int i = 0; i < estructuras.size(); i++) {
			if (estructuras.get(i).getClass().getSimpleName().equals("Silo")) {
				Silo silo = (Silo) estructuras.get(i);
				silo.disparar();
			}
		}
	}

	// ronda de entra 3 o 4 misiles, les da und estino y verific a quien alcanzo, e
	// suna oleada cada 4 segundos aproximadamente
	public static void rondasDeMisiles() {
		// Devuelve 4 o 3 para la ronda de misiles
		int i = 0;
		int random = (int) Math.random() * 4 + 3;
		while (i < misiles.size()) {

			misiles.get(i).generarDestino(estructuras, Juego.ancho, Juego.largo);
			evaluarDestruccion(misiles.get(i));
			i++;
			random--;
			// al fin de la oleada espera 4 segundos antes de volver a disparar
			if (random == 0) {
				rondaMisilesMba();
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// evalua si destruyo silo o ciudad
	private static void evaluarDestruccion(Misil misil) {
		for (int i = 0; i < estructuras.size(); i++) {
			if (misil.getDestino().equals(estructuras.get(i).getPosicion())) {
				estructuras.get(i).entidadDestruida();
			}
		}
	}
	// evalua si el juego termino, si quedaron ciudades en pie se tomaria como nivel
	// terminado, sino termino el juego a menos que haya bonusCity

	private static void evaluar() {
		boolean evaluarEstructuras = true;
		for (int i = 0; i < estructuras.size(); i++) {
			// Hay al menos una ciudad en pie el juego continua
			if (estructuras.get(i).getClass().getSimpleName().equals("Ciudad")
					&& estructuras.get(i).isDestruida() == false) {
				evaluarEstructuras = false;
			}
		}
		if (evaluarEstructuras == true && usarBonus == false) {
			Gestor.juegoTerminado = true;
		} else if (evaluarEstructuras == false) {
			Nivel.nivelTerminado = true;
		}
	}

	public static int getnroNivel() {
		return nroNivel;
	}

	// pasa al siguiente nivel y reinicia
	public static void siguienteNivel() {
		nroNivel++;
		reiniciar();
	}

	///////////////////////////////////////////////// Referente a puntajes
	public static int getPuntaje() {
		puntaje = puntaje * nroNivel;
		return puntaje;
	}

	// para el caso cuando explota los misiles
	public void setPuntaje(int valor) {
		Nivel.puntaje += valor;
	}

	// el puntaje se agrega y verifica si hay bonus city disponible
	public static void setPuntaje() {
		for (int i = 0; i < Nivel.estructuras.size(); i++) {
			// Si la clase es silo
			if (Nivel.estructuras.get(i).getClass().getSimpleName().equals("Silo")) {
				Silo silo = (Silo) Nivel.estructuras.get(i);
				Nivel.puntaje = silo.getPuntaje();
			} else if (Nivel.estructuras.get(i).getClass().getSimpleName().equals("Ciudad")
					&& !Nivel.estructuras.get(i).isDestruida()) {
				Nivel.puntaje += Nivel.estructuras.get(i).getPuntaje();
			}
		}
		puntBonus = puntaje / Gestor.bonusCity;
		if (puntBonus != 0) {
			usarBonus = true;
		}
	}

	//////////////////////////////////////////////// Fin Puntaje

}
