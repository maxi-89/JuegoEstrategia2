
public class Arquero extends Personaje{
	
	private int flechas;
	public static final int distanciaMinimaAtaque = 2;
	public static final int distanciaMaximaAtaque = 5;
	
	public Arquero(Punto posicion) {
		super(posicion, 50, 5);
		this.flechas = 20;
	}

	@Override
	public void atacar(Personaje otroPersonaje) throws PersonajeAtacadoMuertoException, NoPoseeFlechasException, PersonajeMuertoNoAtacaException, FueraRangoException {
		if(this.puedeAtacar(otroPersonaje)) {
			this.flechas --;
			otroPersonaje.recibirAtaque(this);
			System.out.println("Arquero infligio un danio de "+this.getDanio()+" puntos!");
		}
		
	}
	@Override
	public void recibirAtaque(Personaje otroPersonaje) {
		this.setSalud(this.getSalud()-otroPersonaje.getDanio());
		
	}
	
	@Override
	public boolean puedeAtacar(Personaje otroPersonaje) throws PersonajeAtacadoMuertoException, NoPoseeFlechasException, PersonajeMuertoNoAtacaException, FueraRangoException {
		
		boolean puedeAtacar=false;
		
			if (otroPersonaje.estaVivo()==false) {
				throw new PersonajeAtacadoMuertoException("El personaje a atacar esta muerto");
				
			}
			else if (this.flechas<=0) {
				throw new NoPoseeFlechasException ("No tienes flechas, debes recargar");
				
			}
			else if (this.estaVivo()==false) {
				throw new PersonajeMuertoNoAtacaException ("Un personaje muerto ya no puede atacar");
				
			}
			else if (this.distancia(otroPersonaje)<Arquero.distanciaMinimaAtaque && this.distancia(otroPersonaje)> Arquero.distanciaMaximaAtaque) {
				throw new FueraRangoException ("El personaje a atacar esta fuera de rango");
				
			}
			else{
				puedeAtacar=true;
				
			}
		
	
			return puedeAtacar; 
		
	//	return (this.flechas > 0 && this.estaVivo() &&
	//this.distancia(otroPersonaje)>=Arquero.distanciaMinimaAtaque && 
			//this.distancia(otroPersonaje)<= Arquero.distanciaMaximaAtaque);
			 
	}
	
	public void cargarFlechas() {
		this.flechas+=6;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + flechas;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arquero other = (Arquero) obj;
		if (flechas != other.flechas)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString().concat("TIPO ARQUERO").concat("\t").concat("Flechas ").concat(String.valueOf(this.flechas));
	}
	
}
