package entes;

public class Entidad {
	Posicion posicion;
	private boolean destruida;
	// Mostrar es proximamente para la visualizacion en pantalla de la imagen
	private boolean mostrar;
	private int puntaje;

	public Entidad(double x, double y) {
		this.posicion = new Posicion(x, y);
		destruida = false;
	}

	public Entidad() {
		destruida = false;
	}

	public void setDestruida() {
		destruida = false;
	}

	public void entidadDestruida() {
		destruida = true;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public void setPosicion(double x, double y) {
		Posicion posicion = new Posicion(x, y);
		this.posicion = posicion;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public boolean isDestruida() {
		return destruida;
	}

	public boolean isMostrar() {
		return mostrar;
	}

	public void setMostrar(boolean mostrar) {
		this.mostrar = mostrar;
	}

	public void Actualizar() {

	}

	public void Mostrar() {

	}

}
