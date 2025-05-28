package entities.func;

import java.util.List;

import entities.Cliente;
import entities.Endereco;
import entities.Produto;
import entities.model.App;

public class Funcao implements App {

	@Override
	public Produto newPdt(long id, String nome, int quantidade) {

		return new Produto(id, nome, quantidade);
	}

	@Override
	public Endereco newEd(String bairro, String rua, int numero) {
		return new Endereco(bairro,rua, numero);
	}

	@Override
	public Cliente newCt(long idCliente, String nomeCliente, Endereco endereco) {
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
			System.out.println("== Estoque vazio ==");
			return;
		}

		System.out.println("== = ==");
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
	public void filtroEstoque(List<Produto> list, String busca) {

		for (Produto e : list) {
			if (e.getNome().toLowerCase().contains(busca.toLowerCase())) {
				System.out.println(e);
			}
		}

	}

	@Override
	public void filtroCliente(List<Cliente> list, String busca) {
		
		for (Cliente e : list) {
			if (e.getNomeCliente().toLowerCase().contains(busca.toLowerCase())) {
				System.out.println(e);
			}
			
		}
	}

	

}
