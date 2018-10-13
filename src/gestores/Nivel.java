package gestores;

public class Nivel {
	private int nivel;
	private boolean terminado;
	private boolean bonusCity;
	private int puntaje;
	private int puntBonus;
	double velocidad;
	static long tiempo;

	public Nivel() {
		puntaje = 0;
		tiempo = System.nanoTime();
	}

	// a definir
	private void setVelocidad() {
		velocidad = velocidad * (tiempo * nivel);
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
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
