package Modelo;

import java.util.ArrayList;

public class Turista extends Pessoa {
	private String numPassaPorte;
	private ArrayList<Hospedagem> hospedagem;

	public Turista(String nome, String cpf) {
		this.setNome(nome);
		this.setCpf(cpf);
	}

	public String getNumPassaPorte() {
		return numPassaPorte;
	}

	public void setNumPassaPorte(String numPassaPorte) {
		this.numPassaPorte = numPassaPorte;
	}

	public ArrayList<Hospedagem> getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(ArrayList<Hospedagem> hospedagem) {
		this.hospedagem = hospedagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((hospedagem == null) ? 0 : hospedagem.hashCode());
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
		Turista other = (Turista) obj;
		if (hospedagem == null) {
			if (other.hospedagem != null)
				return false;
		} else if (!hospedagem.equals(other.hospedagem))
			return false;
		return true;
	}

}
