
public class Lancero extends Personaje{
	
	public static final int distanciaMinimaAtaque = 1;
	public static final int distanciaMaximaAtaque = 3;
	
	public Lancero(Punto posicion) {
		super(posicion, 150, 25);
	}

	@Override
	public void atacar(Personaje otroPersonaje) {
		if(this.puedeAtacar(otroPersonaje)) {
			otroPersonaje.recibirAtaque(this);
			System.out.println("Lancero infligio un danio de "+this.getDanio()+" puntos!");
		}
		else {
			System.out.println("FUERA DE RANGO O MUERTO.");
		}
		
	}
	@Override
	public void recibirAtaque(Personaje otroPersonaje) {
		this.setSalud(this.getSalud()-otroPersonaje.getDanio());
		
	}
	
	@Override
	public boolean puedeAtacar(Personaje otroPersonaje) {
		
		return (otroPersonaje.estaVivo()&&this.estaVivo() && this.distancia(otroPersonaje)>=Lancero.distanciaMinimaAtaque && this.distancia(otroPersonaje)<= Lancero.distanciaMaximaAtaque);
			 
	}
	
	@Override
	public String toString() {
		return super.toString().concat("TIPO LANCERO");
	}
}