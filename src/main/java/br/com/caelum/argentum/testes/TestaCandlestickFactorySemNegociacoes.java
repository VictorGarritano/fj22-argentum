package br.com.caelum.argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.CandleStick;
import br.com.caelum.argentum.modelo.CandleStickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandlestickFactorySemNegociacoes {

	  public static void main(String[] args) {
	    Calendar hoje = Calendar.getInstance();
	    
	    List<Negociacao> negociacoes = Arrays.asList();
	    
	    CandleStickFactory fabrica = new CandleStickFactory();
	    CandleStick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
	    
	    System.out.println(candle.getAbertura());
	    System.out.println(candle.getFechamento());
	    System.out.println(candle.getMinimo());
	    System.out.println(candle.getMaximo());
	    System.out.println(candle.getVolume());
	  }
	}