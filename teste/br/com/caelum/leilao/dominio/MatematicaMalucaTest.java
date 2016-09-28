package br.com.caelum.leilao.dominio;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class MatematicaMalucaTest {
	
	
	@Test
	public void testaMaiorQueTrinta(){
		MatematicaMaluca maluca = new MatematicaMaluca();
		
		assertEquals(200, maluca.contaMaluca(50));
		assertEquals(60, maluca.contaMaluca(20));
		assertEquals(10, maluca.contaMaluca(5));
		
	}
	
}
