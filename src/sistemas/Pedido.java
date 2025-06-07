package sistemas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.Cliente;

public class Pedido {
	
	private static long sequencia = 1;
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");	
	private long id;
	private Cliente cliente;
	private LocalDate data;
	private List<ProdutoVenda> venda =  new ArrayList<>();
	
	
	public Pedido(Cliente cliente, LocalDate data) {
		this.id = sequencia++;
		this.cliente = cliente;
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public long getId() {
		return id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}	
	
	public List<ProdutoVenda> getVenda() {
		return venda;
	}

	public Double getTotal() {
		double total = 0;
		for(ProdutoVenda pv : venda) {
			total+= pv.getTotalVenda();
		}
		return total;
	}

	public void addItem(ProdutoVenda vendas) {
		venda.add(vendas);
	}
	
	public void  removeItem(ProdutoVenda vendas) {
		venda.remove(vendas);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Pedido nº: " + id );
		sb.append(" |Data: " + data.format(dtf));
		sb.append(" | Cliente: " + cliente.getNomeCliente());
		sb.append("\nPedido: ");
		for(ProdutoVenda pv : venda) {
			sb.append("\n" + pv);			
		}
		sb.append("\nTotal: " + String.format("R$ %.2f", getTotal()));
		
		
		return sb.toString();
	}


	
	
	
	
	
	

	
	
	
	
	

}
