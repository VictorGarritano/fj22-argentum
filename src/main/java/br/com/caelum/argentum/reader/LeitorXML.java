package br.com.caelum.argentum.reader;

import java.io.Reader;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.caelum.argentum.modelo.Negociacao;

public class LeitorXML {

	@SuppressWarnings("unchecked")
	public List<Negociacao> carrega(Reader fonte) {
		XStream stream = new XStream(new DomDriver());
		stream.alias("negocio", Negociacao.class);
		return (List<Negociacao>) stream.fromXML(fonte);
	}

}
