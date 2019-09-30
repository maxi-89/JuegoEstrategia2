
public abstract class Personaje {

	private Punto posicion;
	private double salud;
	private int daño;
	
	public Personaje(Punto posicion, double salud, int daño) {
		this.daño = daño;
		this.posicion = posicion;
		this.salud = salud;
	}
	
	public abstract void atacar(Personaje a);
	public abstract void recibirAtaque(Personaje a);
	public abstract boolean puedeAtacar(Personaje a);
	
	protected void setSalud(double salud) {
		this.salud = salud;
	}

	protected double getSalud() {
		return salud;
	}

	protected int getDaño() {
		return daño;
	}

	public boolean estaVivo() {
		return (this.salud>0);
	}
	
	public void moverse(Punto posicion) {
		this.posicion = posicion;
	}
	
	public double distancia(Personaje a) {
		return this.posicion.distancia(a.posicion);
	}

	@Override
	public String toString() {
		return "INFO Personaje: ".toString().concat("POSICION ").concat(String.valueOf(this.posicion)).concat("\t").concat("SALUD ").concat(String.valueOf(this.salud)).concat("\t").concat("DAÑO ").concat(String.valueOf(this.daño)).concat("\t\t");
	}
}
