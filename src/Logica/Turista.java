package Logica;

public class Turista extends Pessoa{
	private String numPassaPorte;
	private Hospedagem hospedagem;
	
	public Turista(String nome, String cpf){
		this.setNome(nome);
		this.setCpf(cpf);
	}
	public String getNumPassaPorte() {
		return numPassaPorte;
	}
	public void setNumPassaPorte(String numPassaPorte) {
		this.numPassaPorte = numPassaPorte;
	}
	public Hospedagem getHospedagem() {
		return hospedagem;
	}
	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}
	
	
	

}
