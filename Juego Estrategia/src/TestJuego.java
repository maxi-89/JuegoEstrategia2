
public class TestJuego {

	public static void main(String[] args) {
	
		Personaje arquerito = new Arquero(new Punto(0,0));
		System.out.println(arquerito);
		Personaje arquerazo = new Arquero(new Punto(3,1));
		System.out.println(arquerazo);
		Personaje caballerito = new Caballero(new Punto(3,5));
		System.out.println(caballerito);
		Personaje caballerazo = new Caballero(new Punto(4,6));
		System.out.println(caballerazo);
		Personaje soldadito = new Soldado(new Punto(4,0));
		System.out.println(soldadito);
		Personaje soldadon = new Soldado(new Punto(5,0));
		System.out.println(soldadon);
		Personaje lancerito = new Lancero(new Punto(0,3));
		System.out.println(lancerito);
		Personaje lancerazo = new Lancero(new Punto(2,4));
		System.out.println(lancerazo);
		
		
		
		arquerito.atacar(arquerazo);
		System.out.println();
		arquerito.atacar(arquerazo);
		System.out.println();
		arquerito.atacar(arquerazo);
		System.out.println();
		arquerito.atacar(arquerazo);
		System.out.println();
		arquerito.atacar(arquerazo);
		System.out.println();
		
		caballerito.atacar(caballerazo);
		System.out.println();
		caballerito.atacar(caballerazo);
		System.out.println();
		caballerito.atacar(caballerazo);
		System.out.println();
		caballerito.atacar(caballerazo);
		System.out.println();
		caballerito.atacar(caballerazo);
		System.out.println();
		caballerito.atacar(caballerazo);
		System.out.println();
		
		soldadito.atacar(soldadon);
		System.out.println();
		soldadito.atacar(soldadon);
		System.out.println();
		soldadito.atacar(soldadon);
		System.out.println();
		soldadito.atacar(soldadon);
		System.out.println();
		soldadito.atacar(soldadon);
		System.out.println();
		soldadito.atacar(soldadon);
		System.out.println();
		soldadito.atacar(soldadon);
		System.out.println();
		
		lancerito.atacar(lancerazo);
		System.out.println();
		lancerito.atacar(lancerazo);
		System.out.println();
		lancerito.atacar(lancerazo);
		System.out.println();
		lancerito.atacar(lancerazo);
		System.out.println();
		lancerito.atacar(lancerazo);
		System.out.println();
		
		
		System.out.println(arquerazo);
		System.out.println(arquerito);
		System.out.println(caballerito);
		System.out.println(caballerazo);
		System.out.println(soldadito);
		System.out.println(soldadon);
		System.out.println(lancerito);
		System.out.println(lancerazo);
		
	}
}
