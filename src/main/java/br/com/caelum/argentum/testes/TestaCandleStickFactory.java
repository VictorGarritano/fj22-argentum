package br.com.caelum.argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negocio;

public class TestaCandlestickFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar hoje = Calendar.getInstance();

		Negocio negociacao1 = new Negocio(40.5, 100, hoje);
		Negocio negociacao2 = new Negocio(45.0, 100, hoje);
		Negocio negociacao3 = new Negocio(39.8, 100, hoje);
		Negocio negociacao4 = new Negocio(42.3, 100, hoje);

		List<Negocio> negociacoes = Arrays.asList(negociacao1, negociacao2,
				negociacao3, negociacao4);
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		
		System.out.println(candle.toString());
	}

}

