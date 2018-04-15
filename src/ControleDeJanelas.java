
import java.util.ArrayList;

import javax.swing.*;

class ControleDeJanelas {
	JFrame showFrame;

	ControleDeJanelas() {
		showFrame = new JFrame();
	}

	boolean run() {
		int resposta = JOptionPane.showConfirmDialog(showFrame, "Pense em um prato que gosta", "Jogo Gourmet",
				JOptionPane.DEFAULT_OPTION);
		return resposta != -1;
	}

	void tentaDescobrirCaracteristica(ArrayList<Caracteristica> caracteristicasDosPratos, Caracteristica anterior) {

		int i = 0;
		boolean terminou = false;

		while (i < caracteristicasDosPratos.size() && !terminou) {

			Caracteristica atual = caracteristicasDosPratos.get(i);
			Caracteristica novaCaracteristica;

			if (atual.getNome().isEmpty()) {
				this.tentaDescobrirCaracteristica(atual.getListaCaracteristicas(), atual);
			} else {
				int resposta = JOptionPane.showConfirmDialog(showFrame, "Seu prato é um(a) " + atual.getNome() + "?",
						"Confirm", JOptionPane.YES_NO_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {

					if (atual.getPrato() == null) {
						this.mostraQueAcertou();
					} else if (atual.getListaCaracteristicas().isEmpty()) {
						novaCaracteristica = this.tentaDescobrirPrato(atual);
						if (atual != null && !novaCaracteristica.getNome().isEmpty()) {
							atual.addCaracteristica(novaCaracteristica);
						}
					} else {
						this.tentaDescobrirCaracteristica(atual.getListaCaracteristicas(), atual);
					}
					terminou = true;

				} else if (i == caracteristicasDosPratos.size() - 1) {
					if (anterior.getPrato() != null) {
						novaCaracteristica = this.tentaDescobrirPrato(anterior);
					} else {
						novaCaracteristica = this.perguntaERetornaOQuePensou(atual);
					}

					if (caracteristicasDosPratos != null && !novaCaracteristica.getNome().isEmpty()) {
						caracteristicasDosPratos.add(novaCaracteristica);
					}
					terminou = true;
				}

			}

			i++;

		}

		return;
	}

	Caracteristica tentaDescobrirPrato(Caracteristica caracteristicaDoPrato) {

		Caracteristica novaCaracteristica = new Caracteristica("");

		int resposta = JOptionPane.showConfirmDialog(showFrame,
				"Seu prato é um(a) " + caracteristicaDoPrato.getPrato().getNome() + "?", "Confirm",
				JOptionPane.YES_NO_OPTION);

		if (resposta == JOptionPane.YES_OPTION) {
			this.mostraQueAcertou();
		} else if (resposta == JOptionPane.NO_OPTION) {
			novaCaracteristica = this.perguntaERetornaOQuePensou(caracteristicaDoPrato);
		}

		return novaCaracteristica;
	}

	Caracteristica perguntaERetornaOQuePensou(Caracteristica atual) {

		Caracteristica novaCaracteristica = new Caracteristica("");

		String prato = JOptionPane.showInputDialog(showFrame, "Qual prato você pensou?", "Desisto",
				JOptionPane.INFORMATION_MESSAGE);

		if (prato != null) {
			String caracteristica = JOptionPane.showInputDialog(showFrame,
					prato + " é ________ mas "
							+ (atual.getPrato() == null ? atual.getNome() : atual.getPrato().getNome()) + " não.",
					"Complete", JOptionPane.INFORMATION_MESSAGE);

			if (caracteristica != null) {
				Prato novo = new Prato(prato);

				novaCaracteristica = new Caracteristica(caracteristica);
				novaCaracteristica.setPrato(novo);
			}

		}

		return novaCaracteristica;
	}

	void mostraQueAcertou() {
		JOptionPane.showConfirmDialog(showFrame, "Acertei de novo", "Jogo Gourmet", JOptionPane.DEFAULT_OPTION);
	}

}