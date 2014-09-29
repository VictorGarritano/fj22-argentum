package br.com.caelum.argentum.reader;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Assert;
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
	     Assert.assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
	   }
	 }
