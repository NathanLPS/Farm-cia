package Farmacia.controller;

import java.util.ArrayList;
import java.util.Optional;

import Farmacia.model.Produto;
import Farmacia.repository.produtoRepository;

public class ProdutoController implements produtoRepository{

	// Criar a Collection
		private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

		// Variável para receber o id da Produto
		int id = 0;

		@Override
		public void procurarPorNumero(int id) {

			Optional<Produto> produto = buscarNaCollection(id);

			if (produto.isPresent())
				produto.get().visualizar();
			else
				System.out.println("O Produto id: " + id + " não foi encontrado!");
		}

		@Override
		public void listarTodas() {
			for (var produto : listaProdutos) {
				produto.visualizar();
			}

		}

		@Override
		public void cadastrar(Produto produto) {
			listaProdutos.add(produto);
			System.out.println("O Produto id: " + produto.getId() + " foi criado com Sucesso!");

		}

		@Override
		public void atualizar(Produto produto) {
			
			Optional<Produto> buscaProduto = buscarNaCollection(produto.getId());

			if (buscaProduto.isPresent()) {
				listaProdutos.set(listaProdutos.indexOf(buscaProduto.get()), produto);
				System.out.println("O Produto id: " + produto.getId() + " foi atualizado com sucesso!");
			} else
				System.out.println("O Produto id: " + produto.getId() + " não foi encontrado!");

		}

		@Override
		public void deletar(int id) {

			Optional<Produto> produto = buscarNaCollection(id);

			if (produto.isPresent()) {
				if (listaProdutos.remove(produto.get()) == true)
					System.out.println("O Produto id: " + id + " foi excluído com sucesso!");
			} else
				System.out.println("O Produto id: " + id + " não foi encontrado!");

		}
		
		/* Métodos Auxiliares */

		public int gerarNumero() {
			return ++id;
		}

		public Optional<Produto> buscarNaCollection(int id) {

			for (var produto : listaProdutos) {
				if (produto.getId() == id)
					return Optional.of(produto);
			}

			return Optional.empty();
		}

}