
public class Caballero extends Personaje{
	
	private static final int distanciaMinimaAtaque=1;
	private static final int distanciaMaximaAtaque=2;
	private Caballo caballo = new Caballo(this);
	
	public Caballero(Punto posicion) {
		super(posicion,200,50);
	}

	@Override
	public void atacar(Personaje a) {
		if(this.puedeAtacar(a)) {
			a.recibirAtaque(this);
			caballo.setFuria(caballo.getFuria()+1);
			System.out.println("Caballero infligio un daño de "+this.getDaño()+" puntos!");
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
	public void recibirAtaque(Personaje a) {
		this.setSalud(this.getSalud()-a.getDaño());
		
	}
	
	@Override
	public boolean puedeAtacar(Personaje a) {
		
		return (a.estaVivo()&&this.estadoLoco(caballo)==false && this.estaVivo() && this.distancia(a)>=Caballero.distanciaMinimaAtaque && this.distancia(a)<= Caballero.distanciaMaximaAtaque);
			 
	}
	
	@Override
	public String toString() {
		return super.toString().concat("TIPO CABALLERO").concat("\t").concat("CABALLO ").concat(String.valueOf(this.caballo));
	}
	
}