package entes;

public class Silo extends Entidad {
	final private int cantMisiles;
	private int puntajeMisil;
	private int cantMisActual;
	private Posicion rangoVision;
	private MBA [] mAntibalistico;
	
	public Silo(double x, double y, double rx, double ry) {
		//seteo cant de misiles por silo y ubicacion del silo
		super(x,y);
		this.cantMisiles=3;
		//vector
		MBA [] mAntibalistico = new MBA[cantMisiles];
		
		this.cantMisActual=this.cantMisiles;
		seteoMisiles(mAntibalistico);
		setRangoVision(rx,ry);
	}
	
	public void setRangoVision(double x, double y) {
		rangoVision = new Posicion(x,y);
	}
	
	public void seteoMisiles(MBA[] m) {
		for (int i=0; i>m.length;i++) {
			//desde donde a donde pueden ir
			m[i]= new MBA(500,rangoVision.getX(),rangoVision.getY());
		}
	}
	
	public void disparar(MBA[] m) {
		for (int i=0; i>m.length;i++) {
			m[i].usado();
			m[i].destino(posDeDisparo());
		}
	}
	
	//Devuelve la posicion de disparo
	public Posicion posDeDisparo() {
		Posicion posicion = new Posicion(Math.random() * this.rangoVision.getX(),Math.random() * this.rangoVision.getY());
		return posicion;
	}
	
	public void isDestruido() {
		super.entidadDestuida();
		System.out.println("Silo" + this.getClass().getSimpleName() + " ha sido destruido!");
	}
	
	public int Puntaje(int puntajeXMisil) {
		return cantMisActual*puntajeXMisil;
	}
	
	public void soloCuandoTermina() {
		this.reset();
	}
	
	public void reset() {
		super.setDestruida();
	}
	
	public void actualizar() {
		if (super.isDestruida()) {
			cantMisActual=0;
		}
		
		
	}
	
}
