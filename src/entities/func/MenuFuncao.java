package entities.func;

import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import entities.Produto;
import entities.model.App;
import entities.model.AppSistema;
import entities.model.Menu;
import sistemas.Compra;
import sistemas.Pedido;

public class MenuFuncao implements Menu {
	

	@Override
	public void mostrarMenuPrincipal(Scanner sc, AppSistema apc, App app, List<Produto> estoque, List<Cliente> cliente,
			List<Compra> compra,List<Pedido> venda) {
		int menu;

		do {
			System.out.println("\n==Menu Inicial==");
			System.out.print("1 - Cadastro | 2 - Procurar | 3 - Compra | 4 - Venda | 0 - Desligar  == ");
			
			menu = app.lerInteiro(sc);
		

			switch (menu) {
			case 1:
				menuCadastro(sc, app, cliente, estoque);
				break;

			case 2:
				System.out.println("Procurar: ");
				menuProcura(sc, app, estoque, cliente, compra, venda);
				break;
			case 3:
				menuCompra(sc, apc, app, estoque, compra);
				break;
			case 4: 
				
				break;
			case 0:
				System.out.println("Desligando...");
				break;
			default:
				System.out.println("Opção inválida.");
			}

		} while (menu != 0);

	}

	@Override
	public void menuCadastro(Scanner sc, App app, List<Cliente> cliente, List<Produto> estoque) {
		int menuCadastro = 1;

		while (menuCadastro != 0) {
			System.out.println("\n==Menu Cadastro==");
			System.out.print("1 - Cliente | 2 - Produto | 0 - Voltar | ===> ");

			int cadastro = app.lerInteiro(sc);

			switch (cadastro) {
			case 1:
				app.newCliente(cliente, sc);				
				break;
			case 2:
				app.newPdt(estoque, sc);				
				break;
			case 0:
				return;
			default:
				System.out.println("Opção inválida.");
			}

			System.out.print("Fazer novo cadastro? 0 - Não / 1 - Sim: ");
			menuCadastro = app.lerInteiro(sc);
			
		}
	}

	@Override
	public void menuProcura(Scanner sc, App app, List<Produto> estoque, List<Cliente> cliente, List<Compra> compra,List<Pedido> venda) {
		int menuProcura = 1;

		while (menuProcura != 0) {
			System.out.println("\n==Menu Procurar==");
			System.out.print("1-Cliente | 2-Produto | 3-Compra | 4-Venda | 0-Voltar  ==> ");
			
			int procura = app.lerInteiro(sc);

			switch (procura) {

			case 1:
				System.out.println("==Lista Cliente==");
				app.confereList(cliente);
				System.out.print("Procurar um cliente ?1-Sim | 0-Não ==> ");
				int find = app.lerInteiro(sc);
				if (find == 1) {
					app.filtroCliente(sc, cliente);
					break;
				} else {
					break;
				}
			case 2:
				System.out.println("==Lista Estoque==");
				app.confereList(estoque);
				System.out.print("Procurar um produto ? 1-Sim |0-Não ==> ");
				int findEstoque = app.lerInteiro(sc);
				if (findEstoque == 1) {
					app.filtroEstoque(sc, estoque);
					break;
				} else {
					break;
				}
			case 3: 
				System.out.println("Todas Compras:");
				app.confereList(compra);
				break;
			case 4:
				System.out.println("Todas  Vendas:");
				app.confereList(venda);
				break;
				

			case 0:
				return;
				
			default:
				System.out.println("Opção Invalida");
			}

			System.out.print("Fazer nova procura? 0 - Não / 1 - Sim: ");
			menuProcura = app.lerInteiro(sc);
			
		}
	}

	@Override
	public void menuCompra(Scanner sc, AppSistema apc, App app, List<Produto> estoque, List<Compra> compra) {

		int menuCompra = 1;

		while (menuCompra != 0) {
			System.out.println("\n==Menu Compra==");
			System.out.print("1-Lançar | 0-Voltar  ==> ");
			
			int lancarCompra = app.lerInteiro(sc);

			switch (lancarCompra) {
			case 1:
				apc.newCompra(sc, estoque, compra, app);			
				break;
			case 0:
				return;
			default:
				System.out.println("Opção Invalida");
			
			}
			
			System.out.print("Fazer nova compra? 0 - Não / 1 - Sim: ");
			menuCompra = app.lerInteiro(sc);
			
		}
	}

	

}
