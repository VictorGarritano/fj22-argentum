package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class CandleFactory {

	public Candle constroiCandleParaData(Calendar data,
			List<Negociacao> negociacoes) {

		double maximo = 0;
		double minimo = Double.MAX_VALUE;
		double volume = 0;

		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();

			double preco = negociacao.getPreco();
			if (preco > maximo) {
				maximo = preco;
			} else if (preco < minimo) {
				minimo = preco;
			}
		}

		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0)
				.getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(
				negociacoes.size() - 1).getPreco();

		return new Candle(abertura, fechamento, minimo, maximo, volume,
				data);
	}

	public List<Candle> constroiCandles(List<Negociacao> todosNegocios) {

		Collections.sort(todosNegocios);
		
		List<Candle> candles = new ArrayList<Candle>();

		List<Negociacao> negociosDoDia = new ArrayList<Negociacao>();
		Calendar dataAtual = todosNegocios.get(0).getData();

		for (Negociacao negocio : todosNegocios) {

			if (negocio.getData().before(dataAtual)) {
				throw new IllegalStateException("negocios em ordem errada");
			}
			// se nao for mesmo dia, fecha candle e reinicia variaveis
			if (!negocio.isMesmoDia(dataAtual)) {
				criaEGuardaCandle(candles, negociosDoDia, dataAtual);
				negociosDoDia = new ArrayList<Negociacao>();
				dataAtual = negocio.getData();
			}
			negociosDoDia.add(negocio);
		}
		// adiciona ultimo candle
		criaEGuardaCandle(candles, negociosDoDia, dataAtual);

		return candles;
	}

	private void criaEGuardaCandle(List<Candle> candles,
			List<Negociacao> negociosDoDia, Calendar dataAtual) {
		Candle candleDoDia = constroiCandleParaData(dataAtual,
				negociosDoDia);
		candles.add(candleDoDia);
	}
}
