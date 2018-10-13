package entes.Estructuras;

import entes.Entidad;
import taller2.grafico.Dibujable;
import taller2.grafico.InformacionDibujable;

public class Ciudad extends Entidad implements Dibujable {

	private int puntajeCiudad;

	public Ciudad(double x, double y) {
		// setea en false que la ciudad esta destruida
		super(x, y);
		this.setPuntaje(100);
		// TODO Auto-generated constructor stub
	}

	public void entidadDestuida() {
		// completar con lo que pase si se destruye
		super.entidadDestruida();
		System.out.println("Ciudad" + this.getClass().getSimpleName() + " Destruida!");
	}

	public void setPuntajesCiudad(int puntaje) {
		puntajeCiudad = puntaje;
	}

	public int getPuntajeCiudad() {
		int puntaje = 0;
		if (!super.isDestruida()) {
			puntaje = this.puntajeCiudad;
			return puntaje;
		} else {
			return puntaje;
		}
	}

	// Decremento de misiles
	public void Actualizar() {
		if (this.isDestruida()) {
			
		}

	}

	public InformacionDibujable Dibujar() {
		return super.dibujar();
	}

}
