package entities.model;

import java.util.List;

import entities.Cliente;
import entities.Endereco;
import entities.Produto;

public interface App {

	Produto newPdt(long id, String nome, int quantidade);

	Endereco newEd(String bairro, String rua,  int numero);

	Cliente newCt(long idCliente, String nomeCliente, Endereco endereco);

	boolean idConfere(List<Produto> estoque, long id);

	boolean idClientConfere(List<Cliente> cliente, long idCliente);

	<t>void confereList(List<t> list);
	
	void filtroEstoque(List<Produto> list, String busca);
	
	void filtroCliente(List<Cliente> list, String busca);
	
	
}
