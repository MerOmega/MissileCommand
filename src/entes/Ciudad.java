package entes;

public class Ciudad extends Entidad {

	private int puntajeCiudad;

	public Ciudad(int nivel, double x, double y) {
		// setea en false que la ciudad esta destruida
		super(x, y);
		setPuntajesCiudad(nivel);
		this.setPuntaje(100);
		// TODO Auto-generated constructor stub
	}

	public void entidadDestuida() {
		// completar con lo que pase si se destruye
		super.entidadDestruida();
		// elimino imagen de la ciudad
		super.setMostrar(false);
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

}
