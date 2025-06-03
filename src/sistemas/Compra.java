package sistemas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import entities.Produto;

public class Compra {
	
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");	
	
	private LocalDate data;
	private Produto produto;
	private int quantidadeComprada;
	private Double precoCompra;
	
	public Compra(LocalDate data, Produto produto, int quantidadeComprada, Double precoCompra) {
		this.data = data;
		this.produto = produto;
		this.quantidadeComprada = quantidadeComprada;
		this.precoCompra = precoCompra;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidadeComprada() {
		return quantidadeComprada;
	}
	public void setQuantidadeComprada(int quantidadeComprada) {
		this.quantidadeComprada = quantidadeComprada;
	}
	public Double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(Double precoCompra) {
		this.precoCompra = precoCompra;
	}
	public Double getTotal() {
		double total = quantidadeComprada * precoCompra;
		return total;
	}

	@Override
	public String toString() {
		return "Data: " + data.format(dtf)  
		+ " / Produto Id: " + produto.getId() 
		+ " / Produto : " + produto.getNome() 
		+ " / Quantidade Comprada: " + quantidadeComprada 
		+ String.format(" / Valor Pago: R$%.2f", precoCompra) 
		+ String.format(" / Total: R$%.2f", getTotal());
	}
	
	
	
	
	
	

}
