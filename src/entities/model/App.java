package entities.model;

import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import entities.Produto;

public interface App {

	Produto newPdt(List<Produto>  estoque ,Scanner sc);

	Cliente newCliente(List<Cliente> cliente, Scanner sc);	

	boolean idConfere(List<Produto> estoque, long id);

	boolean idClientConfere(List<Cliente> cliente, long idCliente);

	<t>void confereList(List<t> list);
	
	Produto filtroEstoque(Scanner sc, List<Produto> estoque);
	
	Cliente filtroCliente(Scanner sc, List<Cliente> cliente);
	
	
	
	
}
