
public class Soldado extends Personaje implements Bebible{
	
	public static final int distanciaAtaque = 1;
	private int energia;
	/**
	 * contructor clase soldado
	 * @param Punto Posicion
	 * 
	 * **/
	public Soldado(Punto posicion) {
		super(posicion, 200, 10);
		this.energia = 100;
	}
/**
 * metodo atacar
 * @param Personaje otro personaje
 * inflinge dato a otro personaje y descuenta la energia del soldado en 10
 * **/
	@Override
	public void atacar(Personaje otroPersonaje) {
		if(this.puedeAtacar(otroPersonaje)) {
			otroPersonaje.recibirAtaque(this);
			this.energia-=10;
			System.out.println("Soldado infligio un danio de "+this.getDanio()+" puntos!");
		}
	
	}
	/**
	 * metodo recibir ataque
	 * @param Personaje otroPersonaje
	 * reduce la salud segun el daño obtenido del oponente
	 * **/
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
			if (this.energia<0) {
				throw new MiException (006);
				
			}
			if (this.estaVivo()==false) {
				throw new MiException (005);
				
			}
			if (this.distancia(otroPersonaje)!=Soldado.distanciaAtaque) {
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
	public void tomarPocion() {
		
		this.energia=100;
	}
	
	@Override
	public String toString() {
		return super.toString().concat("TIPO SOLDADO").concat("\t").concat("ENERGIA ").concat(String.valueOf(this.energia));
	}
	
}