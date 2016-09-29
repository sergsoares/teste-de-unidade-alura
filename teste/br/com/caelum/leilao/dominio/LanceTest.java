package br.com.caelum.leilao.dominio;

import org.junit.Before;
import org.junit.Test;

public class LanceTest {
	
	
	private Usuario steve;
	private Usuario carlos;
	@Before
	public void criaUsuarios(){
		this.steve = new Usuario("Steve");
		this.carlos = new Usuario("carlos");		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void paraLancesMenoresQue0(){
		Lance lance = new Lance(steve, -100);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void paraaLancesIguaisA0(){
		Lance lance = new Lance(carlos, 0);
	}
}
