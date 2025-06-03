package entities.model;

import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import entities.Produto;
import sistemas.Compra;
import sistemas.Pedido;

public interface Menu {
	
	void mostrarMenuPrincipal(Scanner sc,AppSistema apc, App app,List<Produto> estoque, List<Cliente> cliente,List<Compra> compra, List<Pedido> venda);
	
	void menuCadastro(Scanner sc, App app,List<Cliente> cliente, List<Produto> estoque);
	
	void menuProcura(Scanner sc, App app, List<Produto> estoque,List<Cliente> cliente,List<Compra> compra, List<Pedido> venda);
	
	void menuCompra(Scanner sc, AppSistema apc, App app, List<Produto> estoque, List<Compra> compra);
	
	
}
