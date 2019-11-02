
public class NoTieneEnergiaException extends Exception{
public NoTieneEnergiaException(String msj) {
		
		super(msj);
	}
	
	public NoTieneEnergiaException() {
		this(null);
	}
}
