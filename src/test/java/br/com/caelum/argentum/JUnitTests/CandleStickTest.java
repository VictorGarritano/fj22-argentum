package br.com.caelum.argentum.JUnitTests;

import java.util.Calendar;

import org.junit.Test;

import br.com.caelum.argentum.modelo.CandleStick;

public class CandleStickTest {

	@Test(expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		new CandleStick(10, 20, 20, 10, 10000, Calendar.getInstance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nenhumValorPodeSerNegativo() {
		new CandleStick(-1, 20, -2, -8, 1000, Calendar.getInstance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaCandleStickComDataNula() {
		new CandleStick(10 ,20, 30, 40, 5000, null);
	}

}
