package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Test;

public class CandleStickTest {

	@Test(expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		new CandleStick(10, 20, 20, 10, 10000, Calendar.getInstance());
	}

}
