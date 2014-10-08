package br.com.caelum.argentum.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ArgentumUI {

	private JFrame janela;
	private JPanel painelPrincipal;

	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                ArgentumUI ui = new ArgentumUI();
	                ui.montaTela();
	                UIManager.setLookAndFeel("napkin.NapkinLookAndFeel");
	                SwingUtilities.updateComponentTreeUI(ui.janela);
	                ui.mostraJanela();
	            } catch (Exception ex) {
	                Logger.getLogger(ArgentumUI.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    });
	}


	public void montaTela() {
		preparaJanela();
		preparaPainelPrincipal();
		preparaBotaoCarregar();
		preparaBotaoSair();
//		mostraJanela();
	}

	private void mostraJanela() {
		// TODO Auto-generated method stub
		janela.pack();
		janela.setSize(540, 540);
		janela.setVisible(true);
	}

	private void preparaBotaoSair() {
		// TODO Auto-generated method stub
		JButton botaoSair = new JButton("Sair");
		botaoSair.setMnemonic(KeyEvent.VK_S);
		botaoSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		painelPrincipal.add(botaoSair);
	}

	private void preparaBotaoCarregar() {
		// TODO Auto-generated method stub
		JButton botaoCarregar = new JButton("Carregar XML");
		botaoCarregar.setMnemonic(KeyEvent.VK_C);
		botaoCarregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EscolhedorDeXML().escolhe();
			}
		});
		painelPrincipal.add(botaoCarregar);

	}

	private void preparaPainelPrincipal() {
		// TODO Auto-generated method stub
		painelPrincipal = new JPanel();
		janela.add(painelPrincipal);
	}

	private void preparaJanela() {
		// TODO Auto-generated method stub
		janela = new JFrame("Argentum");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}