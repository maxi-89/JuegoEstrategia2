
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
 * @throws FueraRangoException 
 * @throws PersonajeMuertoNoAtacaException 
 * @throws NoTieneEnergiaException 
 * @throws PersonajeAtacadoMuertoException 
 * **/
	@Override
	public void atacar(Personaje otroPersonaje) throws PersonajeAtacadoMuertoException, NoTieneEnergiaException, PersonajeMuertoNoAtacaException, FueraRangoException {
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
	/**
	 * Metodo puede atacar
	 * @param Personaje otroPersonaje
	 * @return si puedeAtacar es true o false
	 * manejo de excepsiones para saber si puede o no puede atacar
	 * @throws PersonajeAtacadoMuertoException 
	 * @throws NoTieneEnergiaException 
	 * @throws PersonajeMuertoNoAtacaException 
	 * @throws FueraRangoException 
	 *
	 **/
	@Override
	public boolean puedeAtacar(Personaje otroPersonaje) throws PersonajeAtacadoMuertoException, NoTieneEnergiaException, PersonajeMuertoNoAtacaException, FueraRangoException {
		boolean puedeAtacar=false;
	
			if (otroPersonaje.estaVivo()==false) {
				throw new PersonajeAtacadoMuertoException("El personaje a atacar esta muerto");
				
			}
			else if (this.energia<0) {
				throw new NoTieneEnergiaException ("No posee energia suficiente para atacar, puede tomar posion");
				
			}
			else if (this.estaVivo()==false) {
				throw new PersonajeMuertoNoAtacaException ("Un personaje muerto ya no puede atacar");
				
			}
			else if (this.distancia(otroPersonaje)!=Soldado.distanciaAtaque) {
				throw new FueraRangoException ("El personaje a atacar esta fuera de rango");
				
			}
			else {
				puedeAtacar=true;
			}
			
		
	
			return puedeAtacar; 
	}
	/**
	 * metodo tomar pocion
	 * devuelve el nivel de energia a 100
	 * **/
	@Override
	public void tomarPocion() {
		
		this.energia=100;
	}
	
	/**
	 * metodo hashcode
	 * @return result
	 * **/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + energia;
		return result;
	}
	/**
	 * metodo equals 
	 * @return si es igual o no
	 * **/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Soldado other = (Soldado) obj;
		if (energia != other.energia)
			return false;
		return true;
	}
	/**
	 * Metodo toString
	 * 
	 * **/
	@Override
	public String toString() {
		return super.toString().concat("TIPO SOLDADO").concat("\t").concat("ENERGIA ").concat(String.valueOf(this.energia));
	}
	
}