package br.com.caelum.argentum.ui;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import javax.swing.JFileChooser;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.reader.LeitorXML;

public class EscolhedorDeXML {

	public void escolhe() {
		try {
			JFileChooser chooser = new JFileChooser(
					"/home/victorge/git/fj22-argentum");
			chooser.setFileFilter(new FileNameExtensionFilter("Apenas XML",
					"xml"));
			int retorno = chooser.showOpenDialog(null);

			if (retorno == JFileChooser.APPROVE_OPTION) {
				FileReader reader = new FileReader(chooser.getSelectedFile());
				List<Negociacao> negocios = new LeitorXML().carrega(reader);

				Negociacao primeiroNegocio = negocios.get(0);
				String mensagem = "Primeiro negocio: "
						+ primeiroNegocio.getPreco();
				JOptionPane.showMessageDialog(null, mensagem);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new EscolhedorDeXML().escolhe();
	}
}
