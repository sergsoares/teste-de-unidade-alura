package br.com.caelum.leilao.dominio;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
 
public class AvaliadorTest {
	
	@Test
	public void entenderLancesEmOrdemCrescente(){
		Usuario joao = new Usuario("joao");
		Usuario pedro = new Usuario("pedro");
		Usuario maria = new Usuario("maria");
		
		Leilao leilao = new Leilao("Play 4");
		
		leilao.propoe(new Lance(maria, 500.0));
		leilao.propoe(new Lance(pedro, 500.0));
		leilao.propoe(new Lance(joao, 500.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorLance = 500.0;
		double menorLance = 500.0;
		double valorMedio = 500.0;
		
		assertEquals(maiorLance, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorLance, leiloeiro.getMenorLance(), 0.0001);
		}
	
	public void testaLeilaoComApenasUmLance(){
		Usuario joao = new Usuario("Joao");
		Leilao judia = new Leilao("Play 4");
		
		judia.propoe(new Lance(joao,400.0));
		
		Avaliador sergio = new Avaliador();
		sergio.avalia(judia);
		
		assertEquals(400.0, sergio.getMaiorLance(),400.0);
		assertEquals(400.0, sergio.getMenorLance(),400.0);
	}

	@Test
	public void testaLeilaoOrdemAleatorio(){
		
		Usuario joao = new Usuario("joao");
		Usuario pedro = new Usuario("pedro");
		Usuario maria = new Usuario("maria");
		
		Leilao leilao = new Leilao("Play 4");
		
		leilao.propoe(new Lance(maria, 330.0));
		leilao.propoe(new Lance(pedro, 700.0));
		leilao.propoe(new Lance(joao, 120.0));
		leilao.propoe(new Lance(maria, 587.0));
		leilao.propoe(new Lance(joao, 180.0));
		leilao.propoe(new Lance(pedro, 500.0));
		
		Avaliador sergio = new Avaliador();
		sergio.avalia(leilao);
		
		assertEquals(700.0, sergio.getMaiorLance(), 0.0001);
		assertEquals(120.0, sergio.getMenorLance(), 0.0001);		
	}
	
	@Test
	public void testaLeilaoOrdemDescrecente(){
		Usuario joao = new Usuario("joao");
		Usuario pedro = new Usuario("pedro");
		Usuario maria = new Usuario("maria");
		
		Leilao leilao = new Leilao("Play 4");
		
		leilao.propoe(new Lance(maria, 700.0));
		leilao.propoe(new Lance(pedro, 500.0));
		leilao.propoe(new Lance(joao, 300.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorLance = 700.0;
		double menorLance = 300.0;
		double valorMedio = 500.0;
		
		assertEquals(maiorLance, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorLance, leiloeiro.getMenorLance(), 0.0001);
	}
	
	@Test
	public void testaLeilaoCom5Lances(){
		Usuario joao = new Usuario("joao");
		Usuario pedro = new Usuario("pedro");
		Usuario maria = new Usuario("maria");
		
		Leilao leilao = new Leilao("Play 4");
		
		leilao.propoe(new Lance(maria, 1700.0));
		leilao.propoe(new Lance(pedro, 500.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(pedro, 1500.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 100.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(3, leiloeiro.getTresMaiores().size());
	}	

	
	@Test
	public void testaLeilaoComDoisLances(){
		Usuario pedro = new Usuario("pedro");
		Usuario maria = new Usuario("maria");
		
		Leilao leilao = new Leilao("Play 4");
		
		leilao.propoe(new Lance(maria, 1700.0));
		leilao.propoe(new Lance(pedro, 500.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(2, leiloeiro.getTresMaiores().size());
		
	}
	
	@Test
	public void testaLeilaoSemLance(){
		Leilao leilao = new Leilao("Play 4");

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(0, leiloeiro.getTresMaiores().size());
	}
}

