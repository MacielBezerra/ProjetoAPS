package Logica;

public class Pessoa {
	private String nome;
	private int idade;
	private Endereco endereco;
	private String cpf;
	
	
	public Pessoa (String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf;
	}
	public Pessoa(){}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
