package batallaBotes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;

public class Tablero {
	
	private HashMap<Coordenada,Casillero> casilleros;
	private int cantFilas;
	private int cantColumnas;
	private int cantidadElementos;
	
	Tablero(){
		cantFilas=8;
		cantColumnas= 8;
		cantidadElementos=0;
		casilleros= new HashMap<Coordenada,Casillero>();
				
		for(int i=1; i<=cantFilas ; i++ ){
			for(int j=0 ; j<cantColumnas ; j++ ){
				Coordenada nuevaCoordenada= new Coordenada(i,j);
				Casillero nuevoCasillero= new Casillero(nuevaCoordenada);
				casilleros.put(nuevaCoordenada, nuevoCasillero);				
			}
		}
	}
	
	
	public boolean estaVacio(){
		return cantidadElementos==0;
	}
	
	
	public Casillero obtenerCasillero(int i, int j) {
		return casilleros.get(new Coordenada(i,j) );		
	}
	

	public void agregarObject(int i,int j) {
		Casillero unCasillero = casilleros.get(new Coordenada(i,j));
		unCasillero.almacenar( new Object() );
		cantidadElementos++;
	}


	public void hundirBote(int i, int j) {
		Casillero unCasillero = casilleros.get(new Coordenada(i,j));
		
		cantidadElementos--;
	}


	public int getCantidadElementos() {
		return cantidadElementos;
	}


	public void ubicarObjetosAleatoriamente(int cantidadBotesNuevos) {
		int i=1;
		while(i<=cantidadBotesNuevos){
			Coordenada coordenada=this.randomCoordenada();
			Casillero unCasillero= this.obtenerCasillero(coordenada.x, coordenada.y);
			if( unCasillero.estaVacio() ){
				this.agregarObject(coordenada.x, coordenada.y);
				i++;
			}
		}		
	}


	private Coordenada randomCoordenada() {
		Random randomGenerator= new Random();
		int i= randomGenerator.nextInt(cantFilas) + 1;
		int j= randomGenerator.nextInt(cantColumnas)+1 ;
		return new Coordenada(i,j);
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
