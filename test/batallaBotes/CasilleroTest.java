package batallaBotes;

import org.junit.Assert;
import org.junit.Test;

public class CasilleroTest {

	@Test
	public void testCasilleroEmpiezaVacio(){
		Casillero c= new Casillero(new Coordenada(1,'a') );
		
		Assert.assertEquals(true, c.estaVacio());
	}
	
	
	@Test
	public void testCasilleroSeCreaConUnaCoordenada(){
		Coordenada unaCoordenada= new Coordenada(1,'a');
		Casillero casillero = new Casillero(unaCoordenada);
		
		Assert.assertEquals(unaCoordenada, casillero.coordenada );
	}
	
	
	@Test
	public void testPonerAlgoEnElCasilleroLoHaceNoVacio(){
		Casillero c= new Casillero( new Coordenada(1,'c') );
		c.contenido= "algo";
		
		Assert.assertEquals(false,c.estaVacio());
	}
	
}
