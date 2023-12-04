package Farmacia;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import Farmacia.controller.ProdutoController;
import Farmacia.model.Produto;
import Farmacia.model.cosmetico;
import Farmacia.model.medicamento;

public class menu {

	public static void main(String[] args) {
		
		ProdutoController produtos = new ProdutoController();
		Scanner leia = new Scanner(System.in);

		int opcao, id, tipo;
		String generico, nome, fragancia;
		float preco;

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                Mais Vida - Drogaria                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Produto                        ");
			System.out.println("            2 - Listar todos os Produtos             ");
			System.out.println("            3 - Buscar Produto por Numero            ");
			System.out.println("            4 - Atualizar Dados de um Produto        ");
			System.out.println("            5 - Apagar Produto                       ");
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			opcao = leia.nextInt();

			if (opcao == 6) {
				System.out.println("\nMais vida agradece sua preferência!");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar Produto\n\n");
			
			
				System.out.println("Produto: ");
				leia.skip("\\R");
				nome = leia.nextLine();
				
				System.out.println("Digite o tipo do Produto (1 - Medicamentos) (2 - Cosmetico) ");
				tipo = leia.nextInt();
				
				System.out.println("Digite o Preço do Produto: ");
				preco = leia.nextFloat();
				
				switch(tipo) {
				case 1:
					System.out.print("Digite o nome do generico do medicamento: ");
					leia.skip("\\R?");
					generico = leia.nextLine();
					produtos.cadastrar(new medicamento(produtos.gerarId(), nome, tipo, preco, generico));
					break;
				case 2:
					System.out.print("Digite o nome da fragancia do cosmetico: ");
					leia.skip("\\R?");
					fragancia = leia.nextLine();
					produtos.cadastrar(new cosmetico(produtos.gerarId(), nome, tipo, preco, fragancia));
					break;
					
				}			
				keyPress();
                break;
                
			case 2:
				System.out.println("Listar todos os Produtos\n\n");

				produtos.listarTodas();
				
				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados de um Produto - por id\n\n");

				System.out.println("Digite o Id do Produto: ");
				id = leia.nextInt();
				
				produtos.procurarPorNumero(id);
				
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados de um Produto\n\n");

				System.out.println("Digite o Id do Produto: ");
				id = leia.nextInt();
				
				Optional<Produto> produto = produtos.buscarNaCollection(id);
				
				if(produto.isPresent()) {
					
					System.out.println("Digite o nome do Produto: ");
					leia.skip("\\R");
					nome = leia.nextLine();
					
					tipo = produto.get().getTipo();
					
					System.out.println("Digite o Preço do Produto: ");
					preco = leia.nextFloat();
					
					System.out.println("Digite o nome Genérico: ");
					leia.skip("\\R");
					generico = leia.nextLine();

					produtos.atualizar(new medicamento(id, nome, tipo, preco, generico));
					
					
				}else
					System.out.println("O Produto não foi encontrado!");
				
				keyPress();
				break;
			case 5:
				System.out.println("Apagar Produto\n\n");

				System.out.println("Digite o Id do Produto: ");
				id = leia.nextInt();
				
				produtos.deletar(id);
				
				keyPress();
				break;
				
			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		}
	}
	public static void keyPress() {

		try {

			System.out.println("\n\nPressione a tecla Enter para continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla inválida!");
		}

	}

}
