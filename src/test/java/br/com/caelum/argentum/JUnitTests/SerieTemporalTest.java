package br.com.caelum.argentum.JUnitTests;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

import br.com.caelum.argentum.modelo.CandleStick;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class SerieTemporalTest {

	@Test(expected=IllegalArgumentException.class)
	public void SerieTemporalNaoPodeReceberListaNula() {
		
		ArrayList<CandleStick> c = new ArrayList<>();
		SerieTemporal st = new SerieTemporal(c);
		
	}

}
