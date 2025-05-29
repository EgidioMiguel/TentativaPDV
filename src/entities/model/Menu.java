package entities.model;

import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import entities.Produto;

public interface Menu {
	
	void mostrarMenuPrincipal(Scanner sc, App app,List<Produto> estoque, List<Cliente> cliente);
	
	void menuCadastro(Scanner sc, App app,List<Cliente> cliente, List<Produto> estoque);

}
