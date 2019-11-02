
public class Caballero extends Personaje{
	
	private static final int distanciaMinimaAtaque=1;
	private static final int distanciaMaximaAtaque=2;
	private Caballo caballo = new Caballo(this);
	
	public Caballero(Punto posicion) {
		super(posicion,200,50);
	}

	@Override
	public void atacar(Personaje otroPersonaje) throws PersonajeAtacadoMuertoException, PersonajeMuertoNoAtacaException, FueraRangoException, CaballoRebeldeException {
		if(this.puedeAtacar(otroPersonaje)) {
			otroPersonaje.recibirAtaque(this);
			caballo.setFuria(caballo.getFuria()+1);
			System.out.println("Caballero infligio un danio de "+this.getDanio()+" puntos!");
		}
		
	}
	
	public boolean estadoLoco(Caballo caballo) {
		return (caballo.getFuria()>3);
	}
	
	@Override
	public void recibirAtaque(Personaje otroPersonaje) {
		this.setSalud(this.getSalud()-otroPersonaje.getDanio());
		
	}
	
	@Override
	public boolean puedeAtacar(Personaje otroPersonaje) throws PersonajeAtacadoMuertoException, PersonajeMuertoNoAtacaException, FueraRangoException, CaballoRebeldeException {
		boolean puedeAtacar=false;
		
		if (otroPersonaje.estaVivo()) {
			throw new PersonajeAtacadoMuertoException("El personaje a atacar esta muerto");
		}
		else if(this.estadoLoco(caballo)==false ){
			throw new CaballoRebeldeException("El caballo esta rebelde, debe tomar posion");
		}
		else if(this.estaVivo()) {
			throw new PersonajeMuertoNoAtacaException ("Un personaje muerto ya no puede atacar");
		}
		else if(this.distancia(otroPersonaje)>=Caballero.distanciaMinimaAtaque && this.distancia(otroPersonaje)<= Caballero.distanciaMaximaAtaque){
			throw new FueraRangoException ("El personaje a atacar esta fuera de rango");
		}
		else {
			puedeAtacar=true;
		}
		return puedeAtacar;
			 
	}
	
	@Override
	public String toString() {
		return super.toString().concat("TIPO CABALLERO").concat("\t").concat("CABALLO ").concat(String.valueOf(this.caballo));
	}
	
}