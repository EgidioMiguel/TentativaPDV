package entities;

public class Produto {

	private Long id;
	private String nome;
	private Integer quantidade;

	public Produto(Long id, String nome, Integer quantidade) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Id: " + id + " / Produto: " + nome + " / Quantidade: " + quantidade;
	}

}
