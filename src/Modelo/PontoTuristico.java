package Modelo;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PontoTuristico other = (PontoTuristico) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
	
}
