
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
		
		
	}
	@Override
	public void recibirAtaque(Personaje otroPersonaje) {
		this.setSalud(this.getSalud()-otroPersonaje.getDanio());
		
	}
	
	@Override
	public boolean puedeAtacar(Personaje otroPersonaje) {
		boolean puedeAtacar=true;
		
		try {
			if (otroPersonaje.estaVivo()==false) {
				throw new MiException(001);
				
			}
		
			if (this.estaVivo()==false) {
				throw new MiException (005);
				
			}
			if (this.distancia(otroPersonaje)<Lancero.distanciaMinimaAtaque 
					&& this.distancia(otroPersonaje)> Lancero.distanciaMaximaAtaque) {
				throw new MiException (002);
				
			}
			
		}
		catch (MiException fail) {
			System.out.println(fail.getMensaje());
			puedeAtacar=false;
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