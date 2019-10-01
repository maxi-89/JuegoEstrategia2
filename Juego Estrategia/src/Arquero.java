
public class Arquero extends Personaje{
	
	private int flechas;
	public static final int distanciaMinimaAtaque = 2;
	public static final int distanciaMaximaAtaque = 5;
	
	public Arquero(Punto posicion) {
		super(posicion, 50, 5);
		this.flechas = 20;
	}

	@Override
	public void atacar(Personaje otroPersonaje) {
		if(this.puedeAtacar(otroPersonaje)) {
			this.flechas --;
			otroPersonaje.recibirAtaque(this);
			System.out.println("Arquero infligio un danio de "+this.getDanio()+" puntos!");
		}else if(this.flechas == 0){
			System.out.println("SIN FLECHAS.");
		}
		else {
			System.out.println("fUERA DE RANGO O MUERTO.");
		}
		
	}
	@Override
	public void recibirAtaque(Personaje otroPersonaje) {
		this.setSalud(this.getSalud()-otroPersonaje.getDanio());
		
	}
	
	@Override
	public boolean puedeAtacar(Personaje otroPersonaje) {
		
		return (this.flechas > 0 && this.estaVivo() && this.distancia(otroPersonaje)>=Arquero.distanciaMinimaAtaque && this.distancia(otroPersonaje)<= Arquero.distanciaMaximaAtaque);
			 
	}
	
	public void cargarFlechas() {
		this.flechas+=6;
	}
	
	@Override
	public String toString() {
		return super.toString().concat("TIPO ARQUERO").concat("\t").concat("Flechas ").concat(String.valueOf(this.flechas));
	}
	
}
