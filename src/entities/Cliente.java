package entities;

public class Cliente {
	
	private Long idCliente;
	private String nomeCliente;	
	private Endereco endereco;
	
	
	public Cliente(Long idCliente, String nomeCliente, Endereco endereco) {
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.endereco = endereco;
	}


	public Long getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	@Override
	public String toString() {
		return "Cliente ID: " + idCliente + " / Nome: " + nomeCliente + " / Endereço: " + endereco;
	}
	
	
	
	
	
	

}
