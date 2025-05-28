package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import entities.Endereco;
import entities.Produto;
import entities.func.Funcao;
import entities.model.App;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		App app = new Funcao();
		
		List<Produto> estoque = new ArrayList<>();
		List<Cliente> cliente = new ArrayList<>();

		System.out.println("===Menu===");
		System.out.print("0-Desligar / 1-Cadastro / 2-Estoque / 3-Clientes /  == ");

		int menu = sc.nextInt();

		while (menu != 0) {

			if (menu == 1) {
				
				int menuCadastro=1;

				while (menuCadastro != 0) {
					
					System.out.print("1-Cliente / 2-Produto / 0-Menu Inicial  == ");
					int cadastro = sc.nextInt();
					
					if(cadastro == 1) {
						//cadastro de endereço e cliente
						System.out.println("=Cadastre o endreço=");
						System.out.print("Bairro : ");
						sc.nextLine();
						String bairro = sc.nextLine();
						System.out.print("Rua : ");
						String rua = sc.nextLine();
						System.out.print("Numero: ");
						int numero = sc.nextInt();
						Endereco endereco = app.newEd(bairro, rua, numero);
						System.out.print("ID : ");
						long idCliente = sc.nextLong();
						while((app.idClientConfere(cliente, idCliente))) {
							System.out.println("===ID JA CADASTRADO===");
							System.out.print("Cadastre novo  Id: ");
							idCliente = sc.nextLong();
						}
						System.out.print("Nome: ");
						sc.nextLine();
						String nomeCliente = sc.nextLine();
						cliente.add(app.newCt(idCliente, nomeCliente, endereco));				
						
						System.out.print("Fazer um novo cadastro? 0-Nao / 1-Sim: ");
						menuCadastro = sc.nextInt();						
						
					}
					
					if(cadastro == 2) {
					//cadastro produto	
					System.out.print("Id: ");
					long id = sc.nextLong();
					while ((app.idConfere(estoque, id)) == true) {
						System.out.println("===ID JA CADASTRADO===");
						System.out.print("Cadastre novo  Id: ");
						id = sc.nextLong();
					}
					System.out.print("Nome: ");
					sc.nextLine();
					String nome = sc.nextLine();
					System.out.print("Quantidade: ");
					int quantidade = sc.nextInt();

					estoque.add(app.newPdt(id, nome, quantidade));

					System.out.print("Fazer um novo cadastro? 0-Nao / 1-Sim: ");
					menuCadastro = sc.nextInt();
					}

				}
			}
			// menu estoque
			
			
			if(menu==2) {				
			
				
				System.out.println("Estoque : ");
				app.confereList(estoque);				
			}
			
			if(menu==3) {
				System.out.println("Clientes : ");
				app.confereList(cliente);
			}
		
			System.out.println("===Menu===");
			System.out.print("0-Desligar / 1-Cadastro / 2-Estoque / 3-Clientes == ");
			menu = sc.nextInt();

		}

		sc.close();
	}

}
