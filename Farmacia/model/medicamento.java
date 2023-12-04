package Farmacia.model;

public class medicamento extends Produto {

	private String generico;

	public medicamento(int id, String nome, int tipo, float preco, String generico) {
		super(id, nome, tipo, preco);
		this.generico = generico;
	}

	public String getGenerico() {
		return generico;
	}

	public void setGenerico(String generico) {
		this.generico = generico;
	}

	public void visualizar() {
		super.visualizar();
		System.out.println("Generico: " + this.generico);
	}

}
