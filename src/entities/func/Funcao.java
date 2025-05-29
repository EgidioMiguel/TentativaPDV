package entities.func;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import entities.Endereco;
import entities.Produto;
import entities.model.App;

public class Funcao implements App {

	@Override
	public Produto newPdt(List<Produto>  estoque ,Scanner sc) {
		System.out.print("Id: ");
		long id = sc.nextLong();
		while ((idConfere(estoque, id)) == true) {
			System.out.println("===ID JA CADASTRADO===");
			System.out.print("Cadastre novo  Id: ");
			id = sc.nextLong();
		}
		System.out.print("Nome: ");			
		String nome = sc.nextLine();
		System.out.print("Quantidade: ");
		int quantidade = sc.nextInt();

		return new Produto(id, nome, quantidade);
	}

	@Override
	public Cliente newCliente (List<Cliente> cliente, Scanner sc) {
		
		System.out.println("=Cadastre o endreço=");
		System.out.print("Bairro : ");
		sc.nextLine();
		String bairro = sc.nextLine();
		System.out.print("Rua : ");		
		String rua = sc.nextLine();
		System.out.print("Numero: ");
		int numero = sc.nextInt();	
		
		Endereco endereco =  new Endereco(bairro,rua, numero);
		
		System.out.print("ID : ");
		long idCliente = sc.nextLong();
		while((idClientConfere(cliente, idCliente))) {
			System.out.println("===ID JA CADASTRADO===");
			System.out.print("Cadastre novo  Id: ");
			idCliente = sc.nextLong();
		}
		System.out.print("Nome: ");
		sc.nextLine();
		String nomeCliente = sc.nextLine();
		return new Cliente(idCliente, nomeCliente, endereco);
	}
	

	@Override
	public boolean idConfere(List<Produto> estoque, long id) {

		for (Produto e : estoque) {
			if (e.getId() == id)
				return true;
		}
		return false;
	}

	@Override
	public <t> void confereList(List<t> list) {
		if (list.isEmpty()) {
			System.out.println("== Lista vazio ==");
			return;
		}

		System.out.println("== Lista ==");
		for (t e : list) {
			System.out.println(e);
		}

	}

	@Override
	public boolean idClientConfere(List<Cliente> cliente, long idCliente) {
		for (Cliente e : cliente) {
			if (e.getIdCliente() == idCliente)
				return true;
		}
		return false;
	}

	@Override
	public Produto filtroEstoque(Scanner sc, List<Produto> estoque) {
		System.out.print("Digite um nome: ");
		sc.nextLine();
		String busca = sc.nextLine();
		
		List<Produto> encontrados = new ArrayList<>();
		
		for (Produto e : estoque) {
			if (e.getNome().toLowerCase().contains(busca.toLowerCase())) {
				encontrados.add(e);
			}			
		}
		if(encontrados.isEmpty()) {
			System.out.println("Nenhum produto encontrado");
			return null;
		}
		
		System.out.println("Produto encontrados: ");
		for(Produto c : encontrados) {
			System.out.println(c);
		}
		if(encontrados.size()==1) {
			return encontrados.get(0);
		}
		
		else {
			System.out.println("Digite ID do produto desejado: ");
			long idSelecionado = sc.nextLong();
			for(Produto a : encontrados) {
				if(a.getId() == idSelecionado) {
					return a;
				}
			}
			System.out.println("ID invalido. Nenhum produto selecionado.");
			return null;
		}
		
	
	}	

	@Override
	public Cliente filtroCliente(Scanner sc, List<Cliente> cliente) {
		System.out.print("Digite um nome: ");
		sc.nextLine();
		String busca = sc.nextLine();
		
		List<Cliente> encontrados = new ArrayList<>();
		
		for (Cliente e : cliente) {
			if (e.getNomeCliente().toLowerCase().contains(busca.toLowerCase())) {
				encontrados.add(e);
			}			
		}
		if(encontrados.isEmpty()) {
			System.out.println("Nenhum cliente encontrado");
			return null;
		}
		
		System.out.println("Clientes encontrados: ");
		for(Cliente c : encontrados) {
			System.out.println(c);
		}
		if(encontrados.size()==1) {
			return encontrados.get(0);
		}
		
		else {
			System.out.println("Digite ID do cliente desejado: ");
			long idSelecionado = sc.nextLong();
			for(Cliente a : encontrados) {
				if(a.getIdCliente() == idSelecionado) {
					return a;
				}
			}
			System.out.println("ID invalido. Nenhum cliente selecionado.");
			return null;
		}
		
	
	}	

}
