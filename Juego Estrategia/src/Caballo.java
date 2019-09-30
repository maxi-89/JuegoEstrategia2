
public class Caballo implements Bebible{
	
	private int furia = 0;
	private Personaje ginete;
	
	public Caballo(Personaje personaje) {
		this.ginete = personaje;
	}

	public int getFuria() {
		return furia;
	}

	public void setFuria(int furia) {
		this.furia = furia;
	}
	
	public String toString() {
		if(furia<3) {
			return "CALMADO";
		}
		else {
			return "REBELDE";
		}
	}
	
	public void tomarPocion() {
			this.furia = 0;
	}

}
