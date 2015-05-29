package batallaBotes;

public class Coordenada {

	public int x;
	public char y;

	public Coordenada(int i, char c) {
		x= i;
		y= Character.toLowerCase(c);
	}
	
	
	@Override
	public boolean equals(Object otroObjeto){
		
		if(otroObjeto==null || !(otroObjeto instanceof Coordenada)) return false;
		Coordenada otraCoordenada= (Coordenada) otroObjeto;
		return ( ( x == otraCoordenada.x) && (y == otraCoordenada.y) ) ;
	}

	@Override
	public int hashCode() {
		return ( x + Character.getNumericValue( y )  ) ;
	}
	

}
