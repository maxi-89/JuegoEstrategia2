
public class Lancero extends Personaje{
	
	public static final int distanciaMinimaAtaque = 1;
	public static final int distanciaMaximaAtaque = 3;
	
	public Lancero(Punto posicion) {
		super(posicion, 150, 25);
	}

	@Override
	public void atacar(Personaje otroPersonaje) throws PersonajeAtacadoMuertoException, FueraRangoException, PersonajeMuertoNoAtacaException {
		if(this.puedeAtacar(otroPersonaje)) {
			otroPersonaje.recibirAtaque(this);
			System.out.println("Lancero infligio un danio de "+this.getDanio()+" puntos!");
		}
		
		
	}
	@Override
	public void recibirAtaque(Personaje otroPersonaje) {
		this.setSalud(this.getSalud()-otroPersonaje.getDanio());
		
	}
	
	@Override
	public boolean puedeAtacar(Personaje otroPersonaje) throws PersonajeAtacadoMuertoException, FueraRangoException, PersonajeMuertoNoAtacaException {
		boolean puedeAtacar=false;
		
		
			if (otroPersonaje.estaVivo()==false) {
				throw new PersonajeAtacadoMuertoException("El personaje a atacar esta muerto");
				
			}
		
			else if (this.estaVivo()==false) {
				throw new PersonajeMuertoNoAtacaException ("Un personaje muerto ya no puede atacar");
				
			}
			else if (this.distancia(otroPersonaje)<Lancero.distanciaMinimaAtaque 
					&& this.distancia(otroPersonaje)> Lancero.distanciaMaximaAtaque) {
				throw new FueraRangoException ("El personaje a atacar esta fuera de rango");
				
			}
			else {
				puedeAtacar=true;
			}	
		
			return puedeAtacar; 
	}
	
	
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString().concat("TIPO LANCERO");
	}
}