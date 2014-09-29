package br.com.caelum.argentum.testes;

import java.util.Calendar;
import br.com.caelum.argentum.modelo.CandleBuilder;
import br.com.caelum.argentum.modelo.CandleStick;

public class TestaCandleBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar hoje = Calendar.getInstance();

		CandleStick candle = new CandleBuilder().comAbertura(40.5)
				.comFechamento(42.3).comMinimo(39.8).comMaximo(45.0)
				.comVolume(145234.20).comData(hoje).geraCandle();
		
		System.out.println(candle.toString());
	}

}
