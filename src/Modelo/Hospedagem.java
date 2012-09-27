package Modelo;

public class Hospedagem {
	private double valorDiaria;
	private double valorOrcamento;
	private int qteQuartos;
	private int qteSuite;
	private String descricao, nome;
	private int id;
	
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	public double getValorOrcamento() {
		return valorOrcamento;
	}
	public void setValorOrcamento(double valorOrcamento) {
		this.valorOrcamento = valorOrcamento;
	}
	public int getQteQuartos() {
		return qteQuartos;
	}
	public void setQteQuartos(int qteQuartos) {
		this.qteQuartos = qteQuartos;
	}
	public int getQteSuite() {
		return qteSuite;
	}
	public void setQteSuite(int qteSuite) {
		this.qteSuite = qteSuite;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Hospedagem other = (Hospedagem) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	

}
