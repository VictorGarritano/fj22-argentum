package br.com.caelum.argentum.ui;

import java.awt.AWTEvent;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import br.com.caelum.argentum.modelo.Negociacao;

public class ArgentumUI {

	private JFrame janela;
	private JPanel painelPrincipal;
	private JTable tabela;

	public static void main(String[] args) {
		new ArgentumUI().montaTela();
	}

	public void montaTela() {
		preparaJanela();
		preparaPainelPrincipal();
		preparaTitulo();
		preparaTabela();
		preparaBotaoCarregar();
		preparaBotaoSair();
		mostraJanela();
	}

	private void preparaTabela() {
		// TODO Auto-generated method stub
		tabela = new JTable();

		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().add(tabela);

		painelPrincipal.add(scroll);
	}

	private void mostraJanela() {
		// TODO Auto-generated method stub
		janela.pack();
		janela.setSize(540, 540);
		janela.setVisible(true);
	}

	private void preparaPainelPrincipal() {
		painelPrincipal = new JPanel();
		janela.add(painelPrincipal);
	}

	private void preparaBotaoSair() {
		// TODO Auto-generated method stub
		JButton botaoSair = new JButton("Sair");
		botaoSair.setMnemonic(KeyEvent.VK_S);

		// Action Listener
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonActionSair(e);
			}
		});

		// Key Listener para o Frame
		botaoSair.addKeyListener(new KeyListener() {

			// Quando soltar a tecla
			public void keyReleased(KeyEvent e) {

				// Se a tecla pressionada for igual a F2
				if (e.getKeyCode() == KeyEvent.VK_S) {
					buttonActionSair(e);
				}
			}

			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
			}
		});

		painelPrincipal.add(botaoSair);
	}

	private void preparaBotaoCarregar() {
		// TODO Auto-generated method stub
		JButton botaoCarregar = new JButton("Carregar XML");
		botaoCarregar.setMnemonic(KeyEvent.VK_C);

		// Action Listener
		botaoCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonActionCarregar(e);
			}
		});

		// Key Listener para o Frame
		botaoCarregar.addKeyListener(new KeyListener() {

			// Quando soltar a tecla
			public void keyReleased(KeyEvent e) {

				// Se a tecla pressionada for igual a F2
				if (e.getKeyCode() == KeyEvent.VK_C) {
					buttonActionCarregar(e);
				}
			}

			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
			}
		});

		painelPrincipal.add(botaoCarregar);
	}

	private void preparaJanela() {
		// TODO Auto-generated method stub
		janela = new JFrame("Argentum");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void buttonActionSair(AWTEvent e) {
		if (e instanceof KeyEvent || e instanceof ActionEvent) {
			System.exit(0);
		}
	}

	private void buttonActionCarregar(AWTEvent e) {
		if (e instanceof KeyEvent || e instanceof ActionEvent) {
			List<Negociacao> lista = new EscolhedorDeXML().escolhe();
			NegociosTableModel ntm = new NegociosTableModel(lista);
			tabela.setModel(ntm);
			janela.requestFocus();
		}
	}
	
	private void preparaTitulo() {
		  JLabel titulo = new JLabel("Lista de Negócios", SwingConstants.CENTER);
		  titulo.setFont(new Font("Verdana", Font.BOLD, 25));
		  painelPrincipal.add(titulo);  
		}
}