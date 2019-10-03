/**
 * titulo:juego de Estrategia
 * crea personajes del juego de estrategia y 
 * tiene metodos abstractos atacar recibirAtaque puede Atacar
 * @author Maximiliano Rodriguez
 * @version 01/10/2019
 * 
 * 
 * */
public abstract class Personaje {

	private Punto posicion;
	private double salud;
	private int danio;
	/**
	 * constructor clase personaje
	 * @param Posicion:da la ubicacion del personaje
	 * @param salud: valor de la salud del personage
	 * @param danio: valor del poder de daño del personaje
	 * 
	 * **/
	public Personaje(Punto posicion, double salud, int danio) {
		this.danio = danio;
		this.posicion = posicion;
		this.salud = salud;
	}
	/**
	 * Metodo abstracto atacar
	 * @param Personaje otroPersonaje: define personaje a atacar
	 * @see metodo recibir ataque
	 * **/
	public abstract void atacar(Personaje otroPersonaje);
	/**
	 * Metodo abstracto atacar
	 * @param Personaje otroPersonaje: define personaje que recibe el ataque
	 * @see metodo atacar
	 * **/
	public abstract void recibirAtaque(Personaje otroPersonaje);
	/**
	 * Metodo abstracto puedeAtacar
	 * @param Personaje otroPersonaje: define si puede atacar al objetivo
	 * @see metodo recibir ataque
	 * 
	 * **/
	public abstract boolean puedeAtacar(Personaje otroPersonaje);
	
	
	/**
	 * SETTER PROTECTED
	 * Establece el nivel de salud
	 * **/
	protected void setSalud(double salud) {
		this.salud = salud;
	}
	/**
	 * GETTER PROTECTED
	 * @return el nivel de salud
	 * **/

	protected double getSalud() {
		return salud;
	}
	/**
	 * GETTER PROTECTED
	 * @return el poder de daño
	 * **/
	protected int getDanio() {
		return danio;
	}
/**
 * Metodo boolean estaVivo
 * @return true si salud es mayor a 0
 * 
 * **/
	public boolean estaVivo() {
		return (this.salud>0);
	}
	/**
	 * metodo moverse
	 * cambia la posicion del personaje
	 * @param Punto posicion- le da al metodo la posicion a la que debe moverse
	 * **/
	public void moverse(Punto posicion) {
		this.posicion = posicion;
	}
	/**
	 * metodo distancia
	 * @return la distancia entre un personaje y otro
	 * **/
	
	public double distancia(Personaje otroPersonaje) {
		return this.posicion.distancia(otroPersonaje.posicion);
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + danio;
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salud);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personaje other = (Personaje) obj;
		if (danio != other.danio)
			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		if (Double.doubleToLongBits(salud) != Double.doubleToLongBits(other.salud))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "INFO Personaje: ".toString().concat("POSICION ").concat(String.valueOf(this.posicion)).concat("\t").concat("SALUD ").concat(String.valueOf(this.salud)).concat("\t").concat("DANIO ").concat(String.valueOf(this.danio)).concat("\t\t");
	}
}
