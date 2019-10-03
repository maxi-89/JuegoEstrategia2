
public class MiException extends Exception {

	private int codeError;
	/**
	 * Constructor de clase MiException
	 * 
	 * 
	 * **/
	
	public MiException(int codeError) {
		
		super();
		this.codeError=codeError;
		
	}
	
	public String getMensaje() {
		
		String msj="";
		
		switch(codeError){
		case 001:
			System.out.println("El personaje a atacar esta muerto");
			break;
		case 002:
			System.out.println("El personaje a atacar esta fuera de rango");
			break;
		case 003:
			System.out.println("No tienes flechas, debes recargar");
			break;
		case 004:
			System.out.println("El caballo esta rebelde, debe tomar posion");
			break;
		case 005:
			System.out.println("Un personaje muerto ya no puede atacar");
			break;
		case 006:
			System.out.println("No posee energia suficiente para atacar, puede tomar posion");
			break;
		case 007:
			System.out.println("El arquero no posee flechas, puede recargar flechas ");
			break;
	
		}
		return msj;
		
		
	}
	
}
