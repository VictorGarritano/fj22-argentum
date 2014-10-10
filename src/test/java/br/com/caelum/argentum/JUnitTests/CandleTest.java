package br.com.caelum.argentum.JUnitTests;

import java.util.Calendar;

import org.junit.Test;

import br.com.caelum.argentum.modelo.Candle;

import static org.junit.Assert.*;

public class CandleTest {

	@Test(expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		new Candle(10, 20, 20, 10, 10000, Calendar.getInstance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nenhumValorPodeSerNegativo() {
		new Candle(-1, 20, -2, -8, 1000, Calendar.getInstance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaCandleStickComDataNula() {
		new Candle(10 ,20, 30, 40, 5000, null);
	}

	@Test
	public void quandoAberturaIgualFechamentoEhAlta() {
		Candle candle = new Candle(40, 40, 20, 20, 100, Calendar.getInstance());
		assertEquals(true, candle.isAlta());
	}
}
