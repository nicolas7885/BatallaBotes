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
		
		Object casillero= tablero.obtenerCasillero(3,'c');		
		Assert.assertEquals( Casillero.class,casillero.getClass());
	}
	
	@Test
	public void testAgregarBotePoneUnBoteEnDichoCasillero(){
		Tablero tablero = new Tablero();
		
		tablero.agregarBote(3,'c');
		
		Casillero unCasillero = tablero.obtenerCasillero(3,'c');		
		Assert.assertEquals(false, unCasillero.estaVacio());		
	}
	
	@Test
	public void testAlHundirUnBoteElCasilleroQuedaVacio(){
		Tablero tablero = new Tablero();
		tablero.agregarBote(3,'c');
		
		tablero.hundirBote(3,'c');
		
		Casillero unCasillero = tablero.obtenerCasillero(3,'c');		
		Assert.assertEquals(true, unCasillero.estaVacio());
	}
	
	@Test
	public void testCantidadDeElementosCuentaCasillerosOcupados(){
		Tablero tablero= new Tablero();
		tablero.agregarBote(1, 'c');
		tablero.agregarBote(2, 'c');
		tablero.agregarBote(3, 'c');
		tablero.agregarBote(4, 'c');
		
		int cantElementos = tablero.getCantidadElementos();
		
		Assert.assertEquals(4,cantElementos);
	}
	
	@Test
	public void testUbicarBotesAleatoriamente_Aniade_N_Botes(){
		Tablero tablero = new Tablero();
		
		tablero.ubicarBotesAleatoriamente(8);
		
		Assert.assertEquals(8, tablero.getCantidadElementos() );
	}
	
	
	
	@Test
	public void testReiniciar_VaciaElTablero(){
		Tablero tablero = new Tablero();
		tablero.ubicarBotesAleatoriamente(10);
		
		tablero.reiniciar();
		
		Assert.assertEquals(true, tablero.estaVacio());
	}
	
}
