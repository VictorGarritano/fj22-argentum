package br.com.caelum.argentum.modelo;

import java.util.List;

public class SerieTemporal {
	private final List<CandleStick> candles;

	public SerieTemporal(List<CandleStick> candles) {
		if(candles.size() == 0) {
			throw new IllegalArgumentException();
		}
		this.candles = candles;
	}

	public CandleStick getCandle(int i) {
		return this.candles.get(i);
	}

	public int getTotal() {
		return this.candles.size();
	}
}
