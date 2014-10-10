package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GeradorDeSerie {
	/**
	  * Serve para ajudar a fazer os testes.
	  * 
	  * Recebe uma sequência de valores e cria candles com abertura, fechamento, 
	  * minimo e maximo iguais, mil de volume e data de hoje. Finalmente, devolve
	  * tais candles encapsuladas em uma Serie Temporal.
	  **/
	 public static SerieTemporal criaSerie(double... valores) {
	   List<Candle> candles = new ArrayList<Candle>();
	   for (double d : valores) {
	     candles.add(new Candle(d, d, d, d, 1000, 
	                     Calendar.getInstance()));
	   }
	   return new SerieTemporal(candles);
	 }
}
