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
	
	Pedido newPedido(Scanner sc,List<Cliente> cliente, List<Produto> estoque,List<Pedido> venda, App app);
	
	void cancelarPedido(Scanner sc, List<Pedido> venda, List<Pedido> cancelado, List<Produto> estoque, App app);
	
	Pedido acharPedidoPorId(Scanner sc, List<Pedido> venda, App app);
	
	Pedido acharPedidoPorNome(Scanner sc, List<Pedido> venda, App app);
}
