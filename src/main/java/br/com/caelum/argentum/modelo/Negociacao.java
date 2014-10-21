package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public final class Negociacao implements Comparable<Negociacao>{

	private final double preco;
	private final int quantidade;
	private final Calendar data;

	public Negociacao(double preco, int quantidade, Calendar data) {
		if(data == null) {
			throw new IllegalArgumentException("The date can't be null.");
		}
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return (Calendar) this.data.clone();
	}

	public double getVolume() {
		return preco * quantidade;

	}

	public boolean isMesmoDia(Calendar outraData) {
		return this.data.get(Calendar.DATE) == outraData.get(Calendar.DATE) &&
				this.data.get(Calendar.MONTH) == outraData.get(Calendar.MONTH) &&
				this.data.get(Calendar.YEAR) == outraData.get(Calendar.YEAR);
	}

	@Override
	public int compareTo(Negociacao outroNegocio) {
		// TODO Auto-generated method stub
		if (this.data.getTimeInMillis() < outroNegocio.getData().getTimeInMillis()) {
			return -1;
		}
		else if(this.data.getTimeInMillis() > outroNegocio.getData().getTimeInMillis()) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
