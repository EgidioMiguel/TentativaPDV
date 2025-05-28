package entities;

public class Endereco {
	
	
	private String bairro;
	private String rua;	
	private Integer numero;
	
	
	public Endereco( String bairro, String rua, Integer numero) {
		this.bairro = bairro;
		this.rua = rua;		
		this.numero = numero;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}	


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	@Override
	public String toString() {
		return "Bairro: " + bairro + " / Rua: " +  rua +" / Numero: " + numero ;
	}
	
	
	
	
	

}
