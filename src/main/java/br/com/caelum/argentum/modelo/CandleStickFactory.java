package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CandleStickFactory {
	public CandleStick constroiCandleParaData(Calendar data,
			List<Negociacao> negociacoes) {
		double maximo = 0;
		double minimo = Double.MAX_VALUE;
		double volume = 0;

		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();

			if (negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();
			} else if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			}
		}

		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0)
				.getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(
				negociacoes.size() - 1).getPreco();

		return new CandleStick(abertura, fechamento, minimo, maximo, volume,
				data);
	}

	public List<CandleStick> constroiCandles(List<Negociacao> todosNegocios) {
		   List<CandleStick> candles = new ArrayList<CandleStick>();
		 
		   List<Negociacao> negociosDoDia = new ArrayList<Negociacao>();
		   Calendar dataAtual = todosNegocios.get(0).getData();
		 
		   for (Negociacao negocio : todosNegocios) {
		     // se não for mesmo dia, fecha candle e reinicia variáveis
		     if (!negocio.isMesmoDia(dataAtual)) {
		       CandleStick candleDoDia = constroiCandleParaData(dataAtual, negociosDoDia);
		       candles.add(candleDoDia);
		       negociosDoDia = new ArrayList<Negociacao>();
		       dataAtual = negocio.getData();
		     }
		     negociosDoDia.add(negocio);
		   }
		   // adiciona último candle
		   CandleStick candleDoDia = constroiCandleParaData(dataAtual, negociosDoDia);
		   candles.add(candleDoDia);
		 
		   return candles;
		 }
}
