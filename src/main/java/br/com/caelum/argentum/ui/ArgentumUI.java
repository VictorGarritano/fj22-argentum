package br.com.caelum.argentum.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.MaskFormatter;

import br.com.caelum.argentum.graficos.GeradorDeGrafico;
import br.com.caelum.argentum.indicadores.IndicadorFechamento;
import br.com.caelum.argentum.indicadores.MediaMovelPonderada;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandleFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class ArgentumUI {

	private JFrame janela;
	private JPanel painelPrincipal;
	private JTable tabela;
	private JPanel painelBotoes;
	private JTabbedPane abas;
	private JFormattedTextField campoData;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new ArgentumUI().montaTela();
	}

	public void montaTela() {

		preparaJanela();
		preparaPainelPrincipal();
		preparaAbas();
		preparaTitulo();
		preparaTabela();
		preparaPainelBotoes();
		preparaCampoData();
		preparaBotaoCarregar();
		preparaBotaoSair();
		mostraJanela();

	}

	private void preparaCampoData() {
		// TODO Auto-generated method stub
		JLabel labelData = new JLabel("Apenas a partir de:");
		try {
			MaskFormatter mascara = new MaskFormatter("##/##/####");
			mascara.setPlaceholderCharacter('_');
			campoData = new JFormattedTextField(mascara);

			painelBotoes.add(labelData);
			painelBotoes.add(campoData);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void preparaAbas() {
		// TODO Auto-generated method stub
		abas = new JTabbedPane();
		abas.addTab("Tabela", null);
		abas.addTab("Grafico", null);
		painelPrincipal.add(abas);

	}

	private void preparaPainelBotoes() {
		// TODO Auto-generated method stub
		painelBotoes = new JPanel(new GridLayout());
		painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
	}

	private void preparaTabela() {
		// TODO Auto-generated method stub
		tabela = new JTable();

		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().add(tabela);
		abas.setComponentAt(0, scroll);
	}

	private void mostraJanela() {
		// TODO Auto-generated method stub
		janela.pack();
		janela.setSize(540, 540);
		janela.setVisible(true);
	}

	private void preparaPainelPrincipal() {
		painelPrincipal = new JPanel();
		painelPrincipal.setLayout(new BorderLayout());
		janela.add(painelPrincipal);
	}

	private void preparaBotaoSair() {
		// TODO Auto-generated method stub
		JButton botaoSair = new JButton("Sair");
		botaoSair.setMnemonic(KeyEvent.VK_S);

		// Action Listener
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		painelBotoes.add(botaoSair);
	}

	private void preparaBotaoCarregar() {
		// TODO Auto-generated method stub
		JButton botaoCarregar = new JButton("Carregar XML");
		botaoCarregar.setMnemonic(KeyEvent.VK_C);

		// Action Listener
		botaoCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregaDados();
			}
		});

		painelBotoes.add(botaoCarregar);
	}

	private void preparaJanela() {
		// TODO Auto-generated method stub
		janela = new JFrame("Argentum");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void preparaTitulo() {
		JLabel titulo = new JLabel("Lista de Negocios", SwingConstants.CENTER);
		titulo.setFont(new Font("Verdana", Font.BOLD, 25));
		painelPrincipal.add(titulo, BorderLayout.NORTH);
	}

	private void carregaDados() {
		List<Negociacao> lista = new EscolhedorDeXML().escolhe();
		if (campoData.getValue() != null) {
			new FiltradorPorData(campoData.getText()).filtra(lista);
		}
		ArgentumTableModel ntm = new ArgentumTableModel(lista);
		tabela.setModel(ntm);
		janela.requestFocus();

		CandleFactory fabrica = new CandleFactory();
		List<Candle> candles = fabrica.constroiCandles(lista);
		SerieTemporal serie = new SerieTemporal(candles);

		GeradorDeGrafico gerador = new GeradorDeGrafico(serie, 2,
				serie.getTotal() - 1);
		gerador.plotaIndicador(new MediaMovelSimples(new IndicadorFechamento()));
		gerador.plotaIndicador(new IndicadorFechamento());
		gerador.plotaIndicador(new MediaMovelPonderada());

		abas.setComponentAt(1, gerador.getPanel());

	}
}