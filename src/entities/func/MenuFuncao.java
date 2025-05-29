package entities.func;

import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import entities.Produto;
import entities.model.App;
import entities.model.Menu;

public class MenuFuncao implements Menu   {

	@Override
	public void mostrarMenuPrincipal(Scanner sc, App app,List<Produto> estoque, List<Cliente> cliente) {
		int menu;

        do {
            System.out.println("=== Menu Inicial ===");
            System.out.print("0 - Desligar / 1 - Cadastro / 2 - Estoque / 3 - Clientes == ");
            
            while (!sc.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                sc.next();
            }
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    menuCadastro(sc, app, cliente, estoque);
                    break;
                case 2:
                    System.out.println("Estoque:");
                    app.confereList(estoque);
                    break;
                case 3:
                    System.out.println("Clientes:");
                    app.confereList(cliente);
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
	            System.out.println("=== Menu Cadastro ===");
	            System.out.print("1 - Cliente / 2 - Produto / 0 - Voltar == ");
	            
	            while (!sc.hasNextInt()) {
	                System.out.print("Digite um número válido: ");
	                sc.next();
	            }
	            int cadastro = sc.nextInt();	         

	            switch (cadastro) {
	                case 1:
	                    Cliente clt = app.newCliente(cliente, sc);
	                    cliente.add(clt);
	                    break;
	                case 2:
	                    Produto pdt = app.newPdt(estoque, sc);
	                    estoque.add(pdt);
	                    break;
	                case 0:
	                    return;
	                default:
	                    System.out.println("Opção inválida.");
	            }

	            System.out.print("Fazer novo cadastro? 0 - Não / 1 - Sim: ");
	            menuCadastro = sc.nextInt();
	            sc.nextLine();
	        }
	    }
		
	

}
