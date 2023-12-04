package Farmacia.repository;

import Farmacia.model.Produto;

public interface produtoRepository {
	
	public void procurarPorNumero(int numero);

	public void listarTodas();

	public void cadastrar(Produto produto);

	public void atualizar(Produto produto);

	public void deletar(int numero);

}
