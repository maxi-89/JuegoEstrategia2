
public class Soldado extends Personaje implements Bebible{
	
	public static final int distanciaAtaque = 1;
	private int energia;
	
	public Soldado(Punto posicion) {
		super(posicion, 200, 10);
		this.energia = 100;
	}

	@Override
	public void atacar(Personaje a) {
		if(this.puedeAtacar(a)) {
			a.recibirAtaque(this);
			this.energia--;
			System.out.println("Soldado infligio un daño de "+this.getDaño()+" puntos!");
		}
		else {
			System.out.println("SIN ENERGIAS PARA ATACAR.");
			this.tomarPocion();
		}
		
	}
	@Override
	public void recibirAtaque(Personaje a) {
		this.setSalud(this.getSalud()-a.getDaño());
		
	}
	
	@Override
	public boolean puedeAtacar(Personaje a) {
		
		return (a.estaVivo()&&this.energia>0 && this.estaVivo() && this.distancia(a)>=Soldado.distanciaAtaque && this.distancia(a)<= Soldado.distanciaAtaque);
			 
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