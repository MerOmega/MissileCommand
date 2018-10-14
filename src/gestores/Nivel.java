package gestores;

import java.util.LinkedList;

import entes.Entidad;
import entes.Estructuras.Silo;
import entes.Misiles.MBTonto;

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

	private Nivel() {
		puntaje = 0;
		Nivel.nroNivel = 1;
	}

	public static Nivel getNivel() {
		if (nivel == null) {
			nivel = new Nivel();
			nivelTerminado = false;
			usarBonus=false;
			empezarSimulacion();
			// Recibo las ciudades iniciadas, luego cada vez que termino el nivel verifico
			// si hay bonus city para reconstruirlas
		}
		return nivel;
	}

	private static void initMisiles(double x, double y) {
		int MisilesPorNivel = (int) (Math.random() * MisilesPorNivelmax + MisilesPorNivelmin);
		for (int i = 0; i < MisilesPorNivel; i++) {
			misiles.add(new MBTonto(x, y, false));
			misiles.get(i).generarDestino();
		}
	}

	private static void reiniciar() {
		initMisiles(Gestor.getPos().getX(),Gestor.getPos().getY());
		usarBonus=false;
		nivelTerminado=false;
		puntaje = puntBonus = 0;
	}

	private static void empezarSimulacion() {
		while(Gestor.juegoTerminado!=true) {
		
		setPuntaje();
		Gestor.restartCity(estructuras, puntBonus,puntaje);
		evaluar();
		// Evalua si se completo el nivel con exito o perdio pero tiene una bonus city
		if(nivelTerminado==true) {
		siguienteNivel();
		}else {
			reiniciar();
		}
		}
	}
	
	private void rondasDeMisiles() {
			//Devuelve 4 o 3 para la ronda de misiles
			int i=0;
			int random = (int) Math.random()*4 +3;
			while(!misiles.isEmpty()) {
				misiles.get(i).generarDestino(estructuras, Gestor.getPos().getX(),Gestor.getPos().getY());
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			
		
	}
	
	private static void evaluar() {
		boolean evaluarEstructuras=true;
		for(int i=0;i<estructuras.size();i++) {
			//Hay al menos una ciudad en pie el juego continua
			if(estructuras.get(i).getClass().getSimpleName().equals("Ciudad") && estructuras.get(i).isDestruida()==false) {
				evaluarEstructuras=false;
			}
		}
		if(evaluarEstructuras==true && usarBonus==false) {
			Gestor.juegoTerminado=true;
		} else if(evaluarEstructuras==true && usarBonus==true){
			Nivel.nivelTerminado=true;
		}
	}

	public static int getnroNivel() {
		return nroNivel;
	}

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

	public static void setPuntaje() {
		for (int i = 0; i < Nivel.estructuras.size(); i++) {
			// Si la clase es silo
			if (Nivel.estructuras.get(i).getClass().getSimpleName().equals("Silo")) {
				Silo silo = (Silo) Nivel.estructuras.get(i);
				Nivel.puntaje = silo.getPuntaje();
			} else if (Nivel.estructuras.get(i).getClass().getSimpleName().equals("Ciudad")
					&& Nivel.estructuras.get(i).isDestruida()) {
				Nivel.puntaje += Nivel.estructuras.get(i).getPuntaje();
			}
		}
		puntBonus = puntaje / Gestor.bonusCity;
		if(puntBonus!=0) {
			usarBonus=true;
		}
	}

	//////////////////////////////////////////////// Fin Puntaje

}
