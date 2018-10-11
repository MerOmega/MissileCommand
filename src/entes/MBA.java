package entes;

public class MBA extends Misil {

	private boolean usado;

	public MBA(double y1, double x, double y) {
		super(y1, x, y);
		usado = false;
	}

	public MBA() {
		// TODO Auto-generated constructor stub
	}

	public void generarUbicacion(Entidad silo) {
		System.out.println("Misil disparado desde silo:" + silo.getClass().getSimpleName() + "\n");
	}

	public void usado() {
		usado = true;
	}

	public Posicion destino(Posicion pos) {
		this.usado();
		System.out.println("Misil disparo en la posicion " + pos.toString());
		return pos;
	}

}
