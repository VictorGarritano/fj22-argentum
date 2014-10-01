package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public class CandleBuilder {
	
	private double abertura;
	private double fechamento;
	private double minimo;
	private double maximo;
	private double volume;
	private Calendar data;
	private boolean b1;
	private boolean b2;
	private boolean b3;
	private boolean b4;
	private boolean b5;
	private boolean b6;
	
	public CandleBuilder comAbertura(double abertura) {
	    this.abertura = abertura;
	    b1 = true;
	    return this;
	  }
	
	public CandleBuilder comFechamento(double fechamento) {
	    this.fechamento = fechamento;
	    b2 = true;
	    return this;
	  }
	
	public CandleBuilder comMinimo(double minimo) {
	    this.minimo = minimo;
	    b3 = true;
	    return this;
	  }
	
	public CandleBuilder comMaximo(double maximo) {
	    this.maximo = maximo;
	    b4 = true;
	    return this;
	  }
	
	public CandleBuilder comVolume(double volume) {
	    this.volume = volume;
	    b5 = true;
	    return this;
	  }
	
	public CandleBuilder comData(Calendar data) {
		this.data = data;
		b6 = true;
		return this;
	}
	
	public CandleStick geraCandle() {
		if (!(b1 || b2 || b3 || b4 || b5 || b6)) {
			throw new IllegalStateException("Some method wasn't invoked.");
		}
		return new CandleStick(abertura, fechamento, minimo, maximo, volume, data);
	}
}
