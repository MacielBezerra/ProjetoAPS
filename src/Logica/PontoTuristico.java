package Logica;

public class PontoTuristico {
	private String nome;
	private double precoBilhete;
	private Endereco endereco;
	private Cidade cidade;
	
	 	

	public Cidade getNomeCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade=cidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoBilhete() {
		return precoBilhete;
	}

	public void setPrecoBilhete(double precoBilhete) {
		this.precoBilhete = precoBilhete;
	}
	
	
	
}
