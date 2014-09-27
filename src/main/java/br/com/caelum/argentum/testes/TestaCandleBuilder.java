package br.com.caelum.argentum.testes;

import java.util.GregorianCalendar;
import br.com.caelum.argentum.modelo.CandleBuilder;
import br.com.caelum.argentum.modelo.CandleStick;

public class TestaCandleBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CandleStick candle = new CandleBuilder().comAbertura(40.5)
			    .comFechamento(42.3).comMinimo(39.8).comMaximo(45.0)
			    .comVolume(145234.20).comData(
			    new GregorianCalendar(2014, 9, 27, 0, 0, 0)).geraCandle();
	}

}
