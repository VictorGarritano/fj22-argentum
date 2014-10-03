package br.com.caelum.argentum.JUnitTests;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;

public class NegociacaoTest {
	@Test
	public void dataDoNegocioEhImutavel() {
		// se criar um negocio no dia 15...
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		Negociacao n = new Negociacao(10, 5, c);

		// ainda que eu tente mudar a data para 20...
		n.getData().set(Calendar.DAY_OF_MONTH, 20);

		// ele continua no dia 15.
		assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegocioComDataNula() {
	  new Negociacao(10, 5, null);
	}
	
	@Test
	public void mesmoMilissegundoEhDoMesmoDia() {
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar) agora.clone();

		Negociacao negocio = new Negociacao(40.0, 100, agora);
		assertTrue(negocio.isMesmoDia(mesmoMomento));
	}

	@Test
	public void mesmoDiaHorasDiferentesEhDoMesmoDia() {
		// usando GregorianCalendar(ano, mes, dia, hora, minuto)
		Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
		Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);

		Negociacao negocio = new Negociacao(40.0, 100, manha);
		assertTrue(negocio.isMesmoDia(tarde));
	}

	@Test
	public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia() {
		Calendar manha = new GregorianCalendar(2011, 12, 20, 8, 30);
		Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);

		Negociacao negocio = new Negociacao(40.0, 100, manha);
		assertFalse(negocio.isMesmoDia(tarde));
	}
	
	@Test
	public void mesmoDiaEMesMasAnosDiferentesNaoSaoDoMesmoDia() {
		Calendar manha = new GregorianCalendar(2001, 12, 20, 8, 30);
		Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);

		Negociacao negocio = new Negociacao(40.0, 100, manha);
		assertFalse(negocio.isMesmoDia(tarde));
	}
	
}
