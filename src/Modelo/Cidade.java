package Modelo;

import java.util.ArrayList;

public class Cidade {
	private String nome;
	private ArrayList<PontoTuristico> pontosTuristicos = new ArrayList<PontoTuristico>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<PontoTuristico> getPontosTuristicos() {
		return pontosTuristicos;
	}

	public void setPontosTuristicos(ArrayList<PontoTuristico> pontosTuristicos) {
		this.pontosTuristicos = pontosTuristicos;
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
		Cidade other = (Cidade) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
