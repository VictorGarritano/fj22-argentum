package br.com.caelum.argentum.JUnitTests;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.argentum.modelo.CandleStick;
import br.com.caelum.argentum.modelo.CandleStickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class CandleStickFactoryTest {

	@Test
	public void sequenciaSimplesDeNegocios() {
		Calendar hoje = Calendar.getInstance();

		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);

		List<Negociacao> negocios = Arrays.asList(negociacao1, negociacao2,
				negociacao3, negociacao4);

		CandleStickFactory fabrica = new CandleStickFactory();
		CandleStick candle = fabrica.constroiCandleParaData(hoje, negocios);

		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(42.3, candle.getFechamento(), 0.00001);
		Assert.assertEquals(39.8, candle.getMinimo(), 0.00001);
		Assert.assertEquals(45.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(16760.0, candle.getVolume(), 0.00001);
	}

	@Test(expected=IllegalArgumentException.class)
	public void semNegociosGeraCandleComZeros() {
		Calendar hoje = Calendar.getInstance();

		List<Negociacao> negocios = Arrays.asList();

		CandleStickFactory fabrica = new CandleStickFactory();
		CandleStick candle = fabrica.constroiCandleParaData(hoje, negocios);

		Assert.assertEquals(0.0, candle.getVolume(), 0.00001);
		Assert.assertEquals(0.0, candle.getAbertura(), 0.00001);
		Assert.assertEquals(0.0, candle.getFechamento(), 0.00001);
		Assert.assertEquals(Double.MAX_VALUE, candle.getMinimo(), 0.00001);
		Assert.assertEquals(0.0, candle.getMaximo(), 0.00001);
	}

	@Test(expected=IllegalArgumentException.class)
	public void apenasUmNegocioGeraCandleComValoresIguais() {
		Calendar hoje = Calendar.getInstance();

		Negociacao negocio1 = new Negociacao(40.5, 100, hoje);

		List<Negociacao> negocios = Arrays.asList(negocio1);

		CandleStickFactory fabrica = new CandleStickFactory();
		CandleStick candle = fabrica.constroiCandleParaData(hoje, negocios);

		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(40.5, candle.getFechamento(), 0.00001);
		Assert.assertEquals(Double.MAX_VALUE, candle.getMinimo(), 0.00001);
		Assert.assertEquals(40.5, candle.getMaximo(), 0.00001);
		Assert.assertEquals(4050.0, candle.getVolume(), 0.00001);
		
		
	}
}
