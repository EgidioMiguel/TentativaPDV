package entities.model;

import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import entities.Produto;
import sistemas.Compra;
import sistemas.Pedido;
import sistemas.ProdutoVenda;

public interface AppSistema {
	
	
	
	Compra newCompra(Scanner sc, List<Produto> estoque,List<Compra> compra, App app);
	
	Produto checkProduto(Scanner sc, List<Produto> estoque, App app);
	
	ProdutoVenda newPdtVenda(Scanner sc, List<Produto> estoque, App app);
	
	Pedido newPedido(Scanner sc,List<Cliente> cliente, List<Produto> estoque, App app);
	

}
