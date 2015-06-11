package batallaBotes;

import org.junit.Assert;
import org.junit.Test;

public class TableroTest {
	
	@Test
	public void testTableroEmpiezaVacio(){
		Tablero tablero= new Tablero();
		
		Assert.assertEquals(true,tablero.estaVacio());
	}
	
	@Test
	public void testObtenerCasilleroDevuelveUnCasillero(){
		Tablero tablero = new Tablero();
		
		Object casillero= tablero.obtenerCasillero(3,5);		
		Assert.assertEquals( Casillero.class,casillero.getClass());
	}
	
	@Test
	public void testAgregarBotePoneUnBoteEnDichoCasillero(){
		Tablero tablero = new Tablero();
		
		tablero.agregarObject(3,5);
		
		Casillero unCasillero = tablero.obtenerCasillero(3,5);		
		Assert.assertEquals(false, unCasillero.estaVacio());		
	}
	
	@Test
	public void testAlHundirUnBoteElCasilleroQuedaVacio(){
		Tablero tablero = new Tablero();
		tablero.agregarObject(3,5);
		
		tablero.hundirBote(3,5);
		
		Casillero unCasillero = tablero.obtenerCasillero(3,5);		
		Assert.assertEquals(true, unCasillero.estaVacio());
	}
	
	@Test
	public void testCantidadDeElementosCuentaCasillerosOcupados(){
		Tablero tablero= new Tablero();
		tablero.agregarObject(1, 5);
		tablero.agregarObject(2, 5);
		tablero.agregarObject(3, 5);
		tablero.agregarObject(4, 5);
		
		int cantElementos = tablero.getCantidadElementos();
		
		Assert.assertEquals(4,cantElementos);
	}
	
	@Test
	public void testUbicarBotesAleatoriamente_Aniade_N_Botes(){
		Tablero tablero = new Tablero();
		
		tablero.ubicarObjetosAleatoriamente(8);
		
		Assert.assertEquals(8, tablero.getCantidadElementos() );
	}
	
	
	@Test
	public void testReiniciar_VaciaElTablero(){
		Tablero tablero = new Tablero();
		tablero.ubicarObjetosAleatoriamente(10);
		
		tablero.reiniciar();
		
		Assert.assertEquals(true, tablero.estaVacio());
	}
	
}
