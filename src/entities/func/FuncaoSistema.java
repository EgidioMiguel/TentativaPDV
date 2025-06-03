package entities.func;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import entities.Produto;
import entities.model.App;
import entities.model.AppSistema;
import sistemas.Compra;
import sistemas.Pedido;
import sistemas.ProdutoVenda;

public class FuncaoSistema implements AppSistema {

	@Override
	public Compra newCompra(Scanner sc, List<Produto> estoque,List<Compra> compra, App app) {

		LocalDate data = LocalDate.now();
		Produto pdt = checkProduto(sc, estoque, app);
		if (pdt == null) {
			System.out.println("==Operação cancelada==");
			return null;
		}
		System.out.print("Quantidade: ");
		int quantidadeCompra = app.lerInteiro(sc);
		System.out.print("Valor: ");
		double precoCompra = app.lerDouble(sc);
		pdt.setQuantidade(pdt.getQuantidade() + quantidadeCompra);
		
		Compra cmp = new Compra(data, pdt, quantidadeCompra, precoCompra);
		compra.add(cmp);
		
		return cmp;

	}

	@Override
	public Produto checkProduto(Scanner sc, List<Produto> estoque, App app) {
		System.out.print("ID produto: ");
		long id = app.lerLong(sc);
		for (Produto e : estoque) {
			if (e.getId() == id) {
				System.out.println(e.getNome());
				return e;
			}
		}
		System.out.println("Produto nao encontrado");
		System.out.print("Desaja fazer Cadastro ?1-S/2-N ==> ");
		int resposta = app.lerInteiro(sc);
		if (resposta == 1) {
			System.out.print("Cadastre Id: ");
			long idNovo = app.lerLong(sc);
			System.out.print("Cadastre nome: ");
			String novoNome = app.lerString(sc);
			int novaQuantidade = 0;
			Produto newPDT = new Produto(idNovo, novoNome, novaQuantidade);
			estoque.add(newPDT);
			return newPDT;
		} else {
			System.out.println("Opção Cancelada");
			return null;
		}
	}

	@Override
	public ProdutoVenda newPdtVenda(Scanner sc, List<Produto> estoque, App app) {
		Produto pdtVenda = app.filtroEstoque(sc, estoque);
		if(pdtVenda == null) {
			System.out.print("Produto nao encontrado! Fazer cadastro ? 1-Sim|2-Não --> ");
			int fazerProduto = app.lerInteiro(sc);
			if(fazerProduto == 1) {
				pdtVenda = app.newPdt(estoque, sc);
				estoque.add(pdtVenda);
			}else {
				System.out.println("Cancelando venda...");
				return null;
			}
		}
		System.out.print("Quantidade: ");
		int quant = app.lerInteiro(sc);
		System.out.print("Valor: R$");
		double val = app.lerDouble(sc);
		
		ProdutoVenda venda = new ProdutoVenda(pdtVenda, quant, val);
		return venda;

	}

	@Override
	public Pedido newPedido(Scanner sc, List<Cliente> cliente, List<Produto> estoque, App app) {
		System.out.println("==Cliente==");
		Cliente clt = app.filtroCliente(sc, cliente);
		if (clt == null) {
			System.out.print("Fazer Cadastro do Cliente ? 1-Sim | 0-Não ==> ");
			int fazerCliente = app.lerInteiro(sc);
			if (fazerCliente == 1) {
				clt = app.newCliente(cliente, sc);
				cliente.add(clt);
			} else {
				System.out.println("Cancelando venda...");
				return null;
			}
		}
		LocalDate data = LocalDate.now();
		
		Pedido pedido = new Pedido(clt, data);
		
		System.out.println("==Produto==");
		pedido.addItem(newPdtVenda(sc, estoque, app));
		
		
		System.out.print("Add + : 1-Sim|0-Não -->");
		int itens = app.lerInteiro(sc);
		if(itens > 1 ) {
			System.out.print("Digitar opção valida: 1 ou 0");
			itens = app.lerInteiro(sc);
		}
		while(itens == 1) {
			pedido.addItem(newPdtVenda(sc, estoque, app));
			
			itens = app.lerInteiro(sc);
		}
	
		
		
		return pedido;
	}	
}	