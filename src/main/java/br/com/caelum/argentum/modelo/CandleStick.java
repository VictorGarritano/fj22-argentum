package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class CandleStick {
	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public CandleStick(double abertura, double fechamento, double minimo,
			double maximo, double volume, Calendar data) {
		if(abertura < 0 || fechamento < 0 || minimo < 0 || maximo < 0 || volume < 0) {
			throw new IllegalArgumentException("None of the values can be negative.");
		}
		if (minimo > maximo) {
			throw new IllegalArgumentException(
					"The minimum value can't be higher than the maximum one.");
		}
		if(data == null) {
			throw new IllegalArgumentException("The date can't be null.");
		}
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}

	public boolean isAlta() {
		return this.abertura < this.fechamento;
	}

	public boolean isBaixa() {
		return this.abertura > this.fechamento;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + "Abertura: " + this.getAbertura() + ", Fechamento: "
				+ this.getFechamento() + ", Mínimo: " + this.getMinimo()
				+ ", Máximo: " + this.getMaximo() + ", Volume: "
				+ this.getVolume() + ", Data: "
				+ sdf.format(this.getData().getTime()) + "]";
	}
}
