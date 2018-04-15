import java.util.ArrayList;

public class Caracteristica {

	private String nome;
	private Prato prato;
	private ArrayList<Caracteristica> listaCaracteristicas;

	public String getNome() {
		return this.nome;
	}
	
	public Prato getPrato() {
		return this.prato;
	}

	public ArrayList<Caracteristica> getListaCaracteristicas() {
		return this.listaCaracteristicas;
	}

	void setPrato(Prato prato) {
		this.prato = prato;
	}

	void addCaracteristica(Caracteristica caracteristica) {
		this.listaCaracteristicas.add(caracteristica);
	}

	Caracteristica(String nome) {
		this.nome = nome;
		listaCaracteristicas = new ArrayList<Caracteristica>();
	}

}
