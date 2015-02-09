package br.com.caelum.argentum.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import br.com.caelum.argentum.modelo.Negociacao;

public class FiltradorPorData {

	private Calendar dataInicial;

	public FiltradorPorData(String dataDigitada) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			dataInicial = Calendar.getInstance();
			dataInicial.setTime(sdf.parse(dataDigitada));
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public void filtra(List<Negociacao> lista) {
		// TODO Auto-generated method stub
		if (dataInicial == null)
			return;
		Iterator<Negociacao> it = lista.iterator();
		while (it.hasNext()) {
			if (it.next().getData().before(dataInicial))
				it.remove();
		}
	}
}
