
public class Soldado extends Personaje implements Bebible{
	
	public static final int distanciaAtaque = 1;
	private int energia;
	
	public Soldado(Punto posicion) {
		super(posicion, 200, 10);
		this.energia = 100;
	}

	@Override
	public void atacar(Personaje otroPersonaje) {
		if(this.puedeAtacar(otroPersonaje)) {
			otroPersonaje.recibirAtaque(this);
			this.energia--;
			System.out.println("Soldado infligio un danio de "+this.getDanio()+" puntos!");
		}
		else {
			System.out.println("SIN ENERGIAS PARA ATACAR.");
			this.tomarPocion();
		}
		
	}
	@Override
	public void recibirAtaque(Personaje otroPersonaje) {
		this.setSalud(this.getSalud()-otroPersonaje.getDanio());
		
	}
	
	@Override
	public boolean puedeAtacar(Personaje otroPersonaje) {
		
		return (otroPersonaje.estaVivo()&&this.energia>0 && this.estaVivo() && this.distancia(otroPersonaje)>=Soldado.distanciaAtaque && this.distancia(otroPersonaje)<= Soldado.distanciaAtaque);
			 
	}
	
	@Override
	public void tomarPocion() {
		if(this.energia<=0)
		this.energia=100;
	}
	
	@Override
	public String toString() {
		return super.toString().concat("TIPO SOLDADO").concat("\t").concat("ENERGIA ").concat(String.valueOf(this.energia));
	}
	
}