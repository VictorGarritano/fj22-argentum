package br.com.caelum.argentum.JUnitTests;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.reader.LeitorXML;

public class LeitorXMLTest {

	@Test
	public void carregaXmlComUmNegocioEmListaUnitaria() {
		String xmlDeTeste = "<list>" + "  <negocio>"
				+ "    <preco>43.5</preco>"
				+ "    <quantidade>1000</quantidade>" + "    <data>"
				+ "      <time>1322233344455</time>" + "    </data>"
				+ "  </negocio>" + "</list>"; // o XML vai aqui!

		LeitorXML leitor = new LeitorXML();
		List<Negociacao> negocios = leitor
				.carrega(new StringReader(xmlDeTeste));

		assertEquals(1, negocios.size(), 0.00001);
		assertEquals(43.5, negocios.get(0).getPreco(), 0.00001);
		assertEquals(1000, negocios.get(0).getQuantidade(), 0.0001);
	}

	@Test
	public void carregaXmlComZeroNegocios() {
		String xmlDeTeste = "<list>" + "</list>"; // o XML vai aqui!

		LeitorXML leitor = new LeitorXML();
		List<Negociacao> negocios = leitor
				.carrega(new StringReader(xmlDeTeste));

		assertEquals(0, negocios.size(), 0.00001);

	}
	
	@Test
	public void carregaXmlComTresNegocios() {
		String xmlDeTeste1 = "<list>" + "  <negocio>"
				+ "    <preco>43.5</preco>"
				+ "    <quantidade>1000</quantidade>" + "    <data>"
				+ "      <time>1322233344455</time>" + "    </data>"
				+ "  </negocio>" + "</list>";
		
		String xmlDeTeste2 = "<list>" + "  <negocio>"
				+ "    <preco>50.6</preco>"
				+ "    <quantidade>1020</quantidade>" + "    <data>"
				+ "      <time>1322233344455</time>" + "    </data>"
				+ "  </negocio>" + "</list>";
		
		String xmlDeTeste3 = "<list>" + "  <negocio>"
				+ "    <preco>66.59</preco>"
				+ "    <quantidade>870</quantidade>" + "    <data>"
				+ "      <time>1322233344455</time>" + "    </data>"
				+ "  </negocio>" + "</list>";
	
		LeitorXML leitor = new LeitorXML();
		List<Negociacao> negocios = leitor.carrega(new StringReader(xmlDeTeste1));
		negocios.addAll(leitor.carrega(new StringReader(xmlDeTeste2)));
		negocios.addAll(leitor.carrega(new StringReader(xmlDeTeste3)));
		
		assertEquals(3, negocios.size(), 0.00001);
		assertEquals(43.5, negocios.get(0).getPreco(), 0.00001);
		assertEquals(1000.0, negocios.get(0).getQuantidade(), 0.0001);
		assertEquals(43500.0, negocios.get(0).getVolume(), 0.0001);
		assertEquals(50.6, negocios.get(1).getPreco(), 0.00001);
		assertEquals(1020.0, negocios.get(1).getQuantidade(), 0.0001);
		assertEquals(51612.0, negocios.get(1).getVolume(), 0.0001);
		assertEquals(66.59, negocios.get(2).getPreco(), 0.00001);
		assertEquals(870.0, negocios.get(2).getQuantidade(), 0.0001);
		assertEquals(57933.3,negocios.get(2).getVolume(), 0.0001);
		
		
		
	}

}
