package Logica;

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
}
	