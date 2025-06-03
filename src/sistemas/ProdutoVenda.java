package sistemas;

import entities.Produto;

public class ProdutoVenda {

	private Produto produto;
	private Integer quantia;
	private Double valorVenda;
	

	public ProdutoVenda(Produto produto, Integer quantia, Double valorVenda) {
		this.produto = produto;
		this.quantia = quantia;
		this.valorVenda = valorVenda;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Integer getQuantia() {
		return quantia;
	}
	
	public void setQuantia(Integer quantia) {
		this.quantia = quantia;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Double getTotalVenda() {
		double totalVenda = quantia * valorVenda;
		return totalVenda;
	}
	

	@Override
	public String toString() {
		return "ID: " + produto.getId()
		+ " | Produto: " + produto.getNome()
		+ " | Quantia: " + quantia
		+ String.format(" | Valor R$%.2f", valorVenda)
		+ String.format(" | Total: R$%.2f", getTotalVenda());
	}
	
	
	
}
