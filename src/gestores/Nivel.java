package gestores;

import java.util.LinkedList;

import entes.Entidad;
import entes.Estructuras.Silo;
import entes.Misiles.MBTonto;

public class Nivel {
	private static Nivel nivel;

	static int MisilesPorNivelmax = 17;
	static int MisilesPorNivelmin = 12;

	private static int nroNivel;
	private boolean terminado;
	private boolean bonusCity;
	private int puntaje;
	private int puntBonus;
	LinkedList<MBTonto> misiles = new LinkedList<MBTonto>();
	static LinkedList<Entidad> estructuras = Gestor.estructuras;

	private Nivel() {
		puntaje = 0;
		Nivel.nroNivel = 1;

	}

	public static Nivel getNivel() {
		if (nivel == null) {
			nivel = new Nivel();
			// Recibo las ciudades iniciadas, luego cada vez que termino el nivel verifico
			// si hay bonus city para reconstruirlas
		}
		return nivel;
	}

	public void initMisiles(double x, double y) {
		int MisilesPorNivel = (int) (Math.random() * MisilesPorNivelmax + MisilesPorNivelmin);
		for (int i = 0; i < MisilesPorNivel; i++) {
			misiles.add(new MBTonto(x, y, false));
			misiles.get(i).generarDestino();
		}
	}

	public void reiniciar() {
		puntaje = puntBonus = 0;

	}

	public void empezarSimulacion() {
		setPuntaje();
	}

	public static int getnroNivel() {
		return nroNivel;
	}

	public static void siguienteNivel() {
		nroNivel++;
	}

	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}

	///////////////////////////////////////////////// Referente a puntajes
	public int getPuntaje() {
		puntaje = puntaje * nroNivel;
		return puntaje;
	}

	// para el caso cuando explota los misiles
	public void setPuntaje(int valor) {
		this.puntaje += valor;
	}

	public void setPuntaje() {
		for (int i = 0; i < Nivel.estructuras.size(); i++) {
			// Si la clase es silo
			if (Nivel.estructuras.get(i).getClass().getSimpleName().equals("Silo")) {
				Silo silo = (Silo) Nivel.estructuras.get(i);
				this.puntaje = silo.getPuntaje();
			} else if (Nivel.estructuras.get(i).getClass().getSimpleName().equals("Ciudad")
					&& Nivel.estructuras.get(i).isDestruida()) {
				this.puntaje = this.puntaje + Nivel.estructuras.get(i).getPuntaje();
			}
		}
		puntBonus = puntaje / Gestor.bonusCity;
	}

	//////////////////////////////////////////////// Fin Puntaje

}
