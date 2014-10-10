package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.CandleStick;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada {
	public double calcula(int posicao, SerieTemporal serie) {
	     double soma = 0.0;
	     byte peso = 1;
	     for (int i = posicao - 2; i <= posicao; i++) {
	       CandleStick c = serie.getCandle(i);
	       soma += (c.getFechamento() * peso);
	       peso++;
	     }
	     return soma / 6;
	   }
}
