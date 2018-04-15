import java.util.ArrayList;

public class App {

	public static void main(String[] args) {

		ControleDeJanelas janelas = new ControleDeJanelas();
		Caracteristica geral = new Caracteristica("");

		ArrayList<Caracteristica> caracteristicasDosPratos = new ArrayList<Caracteristica>();

		Caracteristica massa = new Caracteristica("Massa");

		Prato lasanha = new Prato("Lasanha");
		Prato boloDeChoocolate = new Prato("Bolo de chocolate");

		massa.setPrato(lasanha);

		geral.addCaracteristica(massa);
		geral.setPrato(boloDeChoocolate);

		caracteristicasDosPratos.add(geral);

		while (janelas.run()) {
			janelas.tentaDescobrirCaracteristica(caracteristicasDosPratos, new Caracteristica(""));
		}

	}

}
