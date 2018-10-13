package entes;

import taller2.grafico.Dibujable;
import taller2.grafico.InformacionDibujable;

public class Entidad implements Dibujable {
	Posicion posicion;
	private boolean destruida;
	// Mostrar es proximamente para la visualizacion en pantalla de la imagen
	private boolean mostrar;
	private int puntaje;

	public Entidad(double x, double y) {
		this.posicion = new Posicion(x, y);
		this.setDestruida();
	}

	public Entidad() {
		this.setDestruida();
	}

	///////////////////////////// Acciones de Destruccion
	// para mas orden
	// Si la entidad no esta destruida, por defecto se ve
	public void setDestruida() {
		mostrar = true;
		destruida = false;
	}

	// Si se destruye, no es mas visible
	public void entidadDestruida() {
		mostrar = false;
		destruida = true;
	}

	/////////////////////

	//////////////////// Corresponde a posiciones y puntajes
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

	///////////////

	public boolean isDestruida() {
		return destruida;
	}

	public boolean isMostrar() {
		return mostrar;
	}

	public void Actualizar() {

	}

	public void Mostrar() {

	}
	///////////////// Info Dibujable

	public InformacionDibujable getInformacionDibujable() {
		InformacionDibujable dibujarEnte = new InformacionDibujable((int) this.getPosicion().getX(),
				(int) this.getPosicion().getY(), 'c');
		return dibujarEnte;
	}

}
