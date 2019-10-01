
public class Caballero extends Personaje{
	
	private static final int distanciaMinimaAtaque=1;
	private static final int distanciaMaximaAtaque=2;
	private Caballo caballo = new Caballo(this);
	
	public Caballero(Punto posicion) {
		super(posicion,200,50);
	}

	@Override
	public void atacar(Personaje otroPersonaje) {
		if(this.puedeAtacar(otroPersonaje)) {
			otroPersonaje.recibirAtaque(this);
			caballo.setFuria(caballo.getFuria()+1);
			System.out.println("Caballero infligio un danio de "+this.getDanio()+" puntos!");
		}
		else {
			System.out.println("EL CABALLO SE A VUELTO REBELDE!");
			caballo.tomarPocion();
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
	public boolean puedeAtacar(Personaje otroPersonaje) {
		
		return (otroPersonaje.estaVivo()&&this.estadoLoco(caballo)==false && this.estaVivo() && this.distancia(otroPersonaje)>=Caballero.distanciaMinimaAtaque && this.distancia(otroPersonaje)<= Caballero.distanciaMaximaAtaque);
			 
	}
	
	@Override
	public String toString() {
		return super.toString().concat("TIPO CABALLERO").concat("\t").concat("CABALLO ").concat(String.valueOf(this.caballo));
	}
	
}