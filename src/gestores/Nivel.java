package gestores;

import java.util.LinkedList;

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

	private Nivel() {
		puntaje = 0;
		this.nroNivel = 1;

	}

	public static Nivel getNivel() {
		if (nivel == null) {
			nivel = new Nivel();
		}
		return nivel;
	}

	// a definir

	public static int getnroNivel() {
		return nroNivel;
	}

	public void initMisiles(double x, double y) {
		int MisilesPorNivel = (int) (Math.random() * MisilesPorNivelmax + MisilesPorNivelmin);
		for (int i = 0; i < MisilesPorNivel; i++) {
			misiles.add(new MBTonto(x, y, false));
			misiles.get(i).generarDestino();
		}
	}

	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

}
