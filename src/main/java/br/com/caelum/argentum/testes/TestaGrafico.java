package br.com.caelum.argentum.testes;

import java.io.FileOutputStream;
import java.io.IOException;

import br.com.caelum.argentum.graficos.GeradorDeGrafico;
import javax.swing.JFrame;
import br.com.caelum.argentum.modelo.GeradorDeSerie;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class TestaGrafico {
	public static void main(String[] args) throws IOException {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 5, 6, 7, 8,
				8, 9, 9, 4, 3, 2, 1, 2, 2, 4, 5, 6, 7, 8, 9, 10, 11, 10, 6, 3,
				2, 6, 7, 8, 9);
		GeradorDeGrafico g = new GeradorDeGrafico(serie, 3, 32);
		g.plotaMediaMovelSimples();
		g.salva(new FileOutputStream("grafico.png"));
		
		JFrame frame = new JFrame("Minha janela");
		frame.add(g.getPanel());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
