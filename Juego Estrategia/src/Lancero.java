
public class Lancero extends Personaje{
	
	public static final int distanciaMinimaAtaque = 1;
	public static final int distanciaMaximaAtaque = 3;
	
	public Lancero(Punto posicion) {
		super(posicion, 150, 25);
	}

	@Override
	public void atacar(Personaje a) {
		if(this.puedeAtacar(a)) {
			a.recibirAtaque(this);
			System.out.println("Lancero infligio un daño de "+this.getDaño()+" puntos!");
		}
		else {
			System.out.println("FUERA DE RANGO O MUERTO.");
		}
		
	}
	@Override
	public void recibirAtaque(Personaje a) {
		this.setSalud(this.getSalud()-a.getDaño());
		
	}
	
	@Override
	public boolean puedeAtacar(Personaje a) {
		
		return (a.estaVivo()&&this.estaVivo() && this.distancia(a)>=Lancero.distanciaMinimaAtaque && this.distancia(a)<= Lancero.distanciaMaximaAtaque);
			 
	}
	
	@Override
	public String toString() {
		return super.toString().concat("TIPO LANCERO");
	}
}