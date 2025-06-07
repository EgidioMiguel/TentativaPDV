package entities.func;

import java.time.LocalDate;
import java.util.ArrayList;
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
	public Compra newCompra(Scanner sc, List<Produto> estoque, List<Compra> compra, App app) {

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
		System.out.println("Produto não encontrado");
		System.out.print("Desaja fazer Cadastro ?1-Sim |0-Não --> ");
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
		if (pdtVenda == null) {
			System.out.print("Produto nao encontrado! Fazer cadastro ? 1-Sim | 0-Não --> ");
			int fazerProduto = app.lerInteiro(sc);
			if (fazerProduto == 1) {
				pdtVenda = app.newPdt(estoque, sc);
				estoque.add(pdtVenda);
			} else {
				System.out.println("Cancelando venda...");
				return null;
			}
		}
		System.out.print("Quantidade: ");
		int quant = app.lerInteiro(sc);
		if (pdtVenda.getQuantidade() < quant) {
			System.out.println("Estoque insuficiente|Quantidade em estoque: " + pdtVenda.getQuantidade());
			System.out.print("Deseja continuar ? 1-Sim | 0-Não --> ");
			int cont = app.lerInteiro(sc);
			if (cont == 1) {
				System.out.print("Nova quantidade: ");
				quant = app.lerInteiro(sc);
			} else {
				return null;
			}
		}
		System.out.print("Valor: R$");
		double val = app.lerDouble(sc);
		pdtVenda.setQuantidade(pdtVenda.getQuantidade() - quant);
		ProdutoVenda venda = new ProdutoVenda(pdtVenda, quant, val);
		return venda;

	}

	@Override
	public Pedido newPedido(Scanner sc, List<Cliente> cliente, List<Produto> estoque, List<Pedido> venda, App app) {
		
		try{
		
		System.out.println("==Cliente==");
		Cliente clt = app.filtroCliente(sc, cliente);
		if (clt == null) {
			System.out.print("Fazer Cadastro do Cliente ? 1-Sim | 0-Não --> ");
			int fazerCliente = app.lerInteiro(sc);
			if (fazerCliente == 1) {
				clt = app.newCliente(cliente, sc);
				cliente.add(clt);
			} else {
				System.out.println("Cancelando venda...");
				return null;
			}
		}

		Pedido pdd = new Pedido(clt, LocalDate.now());

		boolean adicionarMais = true;
		while (adicionarMais) {
			System.out.println("== Produto ==");
			ProdutoVenda pv = newPdtVenda(sc, estoque, app);
			if (pv != null) {
				pdd.addItem(pv);

			} else {
				System.out.println("Item não adicionado.");
			}

			int opcao;
			do {
				System.out.print("Adicionar mais um item? 1-Sim | 0-Não --> ");
				opcao = app.lerInteiro(sc);
				if (opcao != 0 && opcao != 1) {
					System.out.print("Opção inválida! Digite 1 ou 0 --> ");
				}
			} while (opcao != 0 && opcao != 1);

			adicionarMais = (opcao == 1);
		}

		System.out.println(pdd);

		venda.add(pdd);
		return pdd;
		}
		catch(Exception  e){
			System.out.println("Erro ao criar o pedido : " + e.getMessage());
			return null;
		}
		
	}

	@Override
	public void cancelarPedido(Scanner sc, List<Pedido> venda, List<Pedido> cancelado,  List<Produto> estoque, App app) {
		
		
		
		System.out.print("Forma de Procura--> 1-ID | 2-Nome Cliente: ");
		int forma = app.lerInteiro(sc);

		while (forma < 1 || forma > 2) {
			System.out.print("Opção inválida. Digite novamente (1-ID | 2-Nome Cliente): ");
			forma = app.lerInteiro(sc);
		}

		Pedido pedidoParaCancelar = null;

		if (forma == 1) {
			pedidoParaCancelar = acharPedidoPorId(sc, venda, app);
		} else {
			pedidoParaCancelar = acharPedidoPorNome(sc, venda, app);
		}
		if (pedidoParaCancelar != null) {
	        System.out.println(pedidoParaCancelar);
	        System.out.print("Deseja Cancelar esse pedido? 1-Sim --> ");
	        int desejaCancelarPedido = app.lerInteiro(sc);
	        if (desejaCancelarPedido == 1) {
	        	for (ProdutoVenda item : pedidoParaCancelar.getVenda()) {
	                Produto produto = item.getProduto();
	                int quantidadeCancelada = item.getQuantia();

	                for (Produto pdtEstoque : estoque) {
	                    if (pdtEstoque.getId() == produto.getId()) {
	                        pdtEstoque.setQuantidade(pdtEstoque.getQuantidade() + quantidadeCancelada);
	                        break;
	                    }
	                }}
	            cancelado.add(pedidoParaCancelar);
	            venda.remove(pedidoParaCancelar);
	            System.out.println("Pedido Cancelado.");
	        } else {
	            System.out.println("Cancelamento abortado.");
	        }
	    } else {
	        System.out.println("Pedido não encontrado.");
	    }

	}

	@Override
	public Pedido acharPedidoPorId(Scanner sc, List<Pedido> venda, App app) {
		System.out.print("Digite o ID da venda: ");
		long idPedido = app.lerLong(sc);
		for (Pedido p : venda) {
			if (p.getId() == idPedido) {
				return p;
			}
		}
		return null;
	}

	@Override
	public Pedido acharPedidoPorNome(Scanner sc, List<Pedido> venda, App app) {

		System.out.print("Nome do Cliente: ");
		String nomeClientePedido = app.lerString(sc);

		List<Pedido> encontradoPedido = new ArrayList<Pedido>();

		for (Pedido pNome : venda) {
			if (pNome.getCliente().getNomeCliente().toLowerCase().contains(nomeClientePedido.toLowerCase())) {
				encontradoPedido.add(pNome);
			}
		}
		if (encontradoPedido.isEmpty()) {
			System.out.println("Nenhum Pedido encontrado");
			return null;

		}
		if (encontradoPedido.size() == 1) {
			return encontradoPedido.get(0);
		} else {
			System.out.print("Selecione por Id: ");
			long pedidoID = app.lerLong(sc);
			for (Pedido pdd : encontradoPedido) {
				if (pdd.getId() == pedidoID) {
					return pdd;
				}
			}
			return null;
		}
	}
}