package batallaBotes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;

public class Tablero {
	
	private HashMap<Coordenada,Casillero> casilleros;
	private int cantFilas;
	private char[] columnas;
	private int cantidadElementos;
	
	Tablero(){
		cantFilas=8;
		columnas= ("abcdefgh").toCharArray();
		cantidadElementos=0;
		casilleros= new HashMap<Coordenada,Casillero>();
				
		for(int i=1; i<=cantFilas ; i++ ){
			for(int j=0 ; j<columnas.length ; j++ ){
				Coordenada nuevaCoordenada= new Coordenada(i,columnas[j]);
				Casillero nuevoCasillero= new Casillero(nuevaCoordenada);
				casilleros.put(nuevaCoordenada, nuevoCasillero);				
			}
		}
	}
	
	
	public boolean estaVacio(){
		return cantidadElementos==0;
	}
	
	
	public Casillero obtenerCasillero(int i, char c) {
		return casilleros.get(new Coordenada(i,c) );		
	}
	

	public void agregarBote(int i, char c) {
		Casillero unCasillero = casilleros.get(new Coordenada(i,c));
		unCasillero.almacenar( new Bote() );
		cantidadElementos++;
	}


	public void hundirBote(int i, char c) {
		Casillero unCasillero = casilleros.get(new Coordenada(i,c));
		unCasillero.vaciar();
		cantidadElementos--;
	}


	public int getCantidadElementos() {
		return cantidadElementos;
	}


	public void ubicarBotesAleatoriamente(int cantidadBotesNuevos) {
		int i=1;
		while(i<=cantidadBotesNuevos){
			Coordenada coordenada=this.randomCoordenada();
			Casillero unCasillero= this.obtenerCasillero(coordenada.x, coordenada.y);
			if( unCasillero.estaVacio() ){
				this.agregarBote(coordenada.x, coordenada.y);
				i++;
			}
		}		
	}


	private Coordenada randomCoordenada() {
		Random randomGenerator= new Random();
		int i= randomGenerator.nextInt(cantFilas) + 1;
		char c= (char) ( (randomGenerator.nextInt(columnas.length) ) + 65) ;
		return new Coordenada(i,c);
	}


	public void reiniciar() {
		Iterator< Entry<Coordenada, Casillero> > it= casilleros.entrySet().iterator();
		while( !this.estaVacio() && it.hasNext() ){
			Casillero unCasillero= it.next() .getValue();
			if( !unCasillero.estaVacio() ){
				Coordenada unaCoordenada= unCasillero.coordenada;
				this.hundirBote(unaCoordenada.x, unaCoordenada.y);
			}
		}		
	}

	
}
