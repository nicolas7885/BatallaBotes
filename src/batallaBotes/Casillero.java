package batallaBotes;

public class Casillero {

	public Coordenada coordenada;
	public Object contenido;

	public Casillero(Coordenada unaCoordenada) {
		coordenada=unaCoordenada;
		contenido=null;
	}

	public boolean estaVacio() {
		return (contenido==null);
	}

	public void vaciar() {
		contenido=null;
	}

	public void almacenar(Object o) {
		contenido= o;		
	}
	
}
