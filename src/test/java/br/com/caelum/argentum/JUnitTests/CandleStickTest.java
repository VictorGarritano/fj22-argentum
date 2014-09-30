package br.com.caelum.argentum.JUnitTests;

import java.util.Calendar;

import org.junit.Test;

import br.com.caelum.argentum.modelo.CandleStick;

public class CandleStickTest {

	@Test(expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		new CandleStick(10, 20, 20, 10, 10000, Calendar.getInstance());
	}

}
