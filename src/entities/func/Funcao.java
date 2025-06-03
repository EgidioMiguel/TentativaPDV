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
	public Produto newPdt(List<Produto> estoque, Scanner sc) {
		System.out.print("Produto Id: ");
		long id = lerLong(sc);
		while ((idConfere(estoque, id)) == true) {
			System.out.println("==ID JA CADASTRADO==");
			System.out.print("Cadastre novo  Id: ");
			id = lerLong(sc);
		}
		
		System.out.print("Produto nome : ");
		String nome = lerString(sc);
		System.out.print("Quantidade: ");
		int quantidade = lerInteiro(sc);
		Produto newPDT = new Produto(id, nome, quantidade);
		estoque.add(newPDT);
		
		return newPDT;
	}

	@Override
	public Cliente newCliente(List<Cliente> cliente, Scanner sc) {

		System.out.println("=Cadastre o endereço= ");
		System.out.print("Bairro : ");
		String bairro = lerString(sc);
		System.out.print("Rua : ");
		String rua = lerString(sc);
		System.out.print("Numero: ");
		int numero = lerInteiro(sc);

		Endereco endereco = new Endereco(bairro, rua, numero);

		System.out.print("Cliente ID : ");
		long idCliente = lerLong(sc);
		while ((idClientConfere(cliente, idCliente))) {
			System.out.println("===ID JA CADASTRADO===");
			System.out.print("Cadastre novo  Id: ");
			idCliente = lerLong(sc);
		}
		System.out.print("Nome  do cliente: ");
		String nomeCliente = lerString(sc);
		Cliente newCLT = new Cliente(idCliente, nomeCliente, endereco);
		cliente.add(newCLT);
		return newCLT;
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
			System.out.println("==Lista vazio==");
			return;
		}		
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
		System.out.print("Produto: ");
		String busca = lerString(sc);

		List<Produto> encontrados = new ArrayList<>();

		for (Produto e : estoque) {
			if (e.getNome().toLowerCase().contains(busca.toLowerCase())) {
				encontrados.add(e);
			}
		}
		if (encontrados.isEmpty()) {
			System.out.println("Nenhum produto encontrado");
			return null;
		}

		System.out.println("Produtos encontrados:");
		for (Produto c : encontrados) {
			System.out.println(c);
		}
		if (encontrados.size() == 1) {
			return encontrados.get(0);
		}

		else {
			System.out.println("Digite ID do produto desejado: ");
			long idSelecionado = lerLong(sc);
			for (Produto a : encontrados) {
				if (a.getId() == idSelecionado) {
					return a;
				}
			}
			System.out.println("ID invalido. Nenhum produto selecionado.");
			return null;
		}

	}

	@Override
	public Cliente filtroCliente(Scanner sc, List<Cliente> cliente) {
		System.out.print("Procure um nome: ");
		String busca = lerString(sc);

		List<Cliente> encontrados = new ArrayList<>();

		for (Cliente e : cliente) {
			if (e.getNomeCliente().toLowerCase().contains(busca.toLowerCase())) {
				encontrados.add(e);
			}
		}
		if (encontrados.isEmpty()) {
			System.out.println("Nenhum cliente encontrado");
			return null;
		}

		System.out.println("Clientes encontrados:");
		for (Cliente c : encontrados) {
			System.out.println(c);
		}
		if (encontrados.size() == 1) {
			return encontrados.get(0);
		}

		else {
			System.out.print("Digite ID do cliente desejado: ");
			long idSelecionado = lerLong(sc);
			for (Cliente a : encontrados) {
				if (a.getIdCliente() == idSelecionado) {
					return a;
				}
			}
			System.out.println("ID invalido. Nenhum cliente selecionado.");
			return null;
		}

	}

	@Override
	public int lerInteiro(Scanner sc) {

		int valor;

		while (!sc.hasNextInt()) {
			System.out.print("Digite um número válido: ");
			sc.next();
		}
		valor = sc.nextInt();
		sc.nextLine();
		return valor;

	}

	@Override
	public String lerString(Scanner sc) {

		String valor;
	    do {
	        valor = sc.nextLine().trim();
	        if (valor.isEmpty()) {
	            System.out.print("Digite um texto válido: ");
	        }
	    } while (valor.isEmpty());
	    return valor;

	}

	@Override
	public double lerDouble(Scanner sc) {
		double valor;

		while (!sc.hasNextDouble()) {
			System.out.println("Digite um número válido: ");
			sc.next();
		}
		valor = sc.nextDouble();
		sc.nextLine();

		return valor;
	}

	@Override
	public long lerLong(Scanner sc) {
		long valor;

		while (!sc.hasNextLong()) {
			System.out.println("Digite um número válido: ");
			sc.next();
		}
		valor = sc.nextLong();
		sc.nextLine();

		return valor;
	}

}
