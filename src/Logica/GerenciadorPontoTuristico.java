package Logica;

import java.util.*;

import Modelo.Persistence;
import Modelo.PontoTuristico;

public class GerenciadorPontoTuristico {

	private Persistence per = Persistence.getInstance();
	private GerenciadorPersistence ger = new GerenciadorPersistence();

	public void cadastrarPontoTuristico(PontoTuristico pt) {

		per.getPontosTuristicos().add(pt);
		ger.persistir();
	}

	public ArrayList<PontoTuristico> listarPontoTuristico() {
		ger.persistir();
		return per.getPontosTuristicos();
	}

	public PontoTuristico pesquisarPontoTuristicoPorNome(String nome)
			throws NullPointerException {
		for (int i = 0; i < per.getPontosTuristicos().size(); i++) {
			if (per.getPontosTuristicos().get(i).getNome().equals(nome))
				return per.getPontosTuristicos().get(i);
		}
		ger.persistir();
		return null;
	}

	public PontoTuristico pesquisarPontoTuristicoPorCidade(String nomeCidade)
			throws NullPointerException {
		for (int i = 0; i < per.getPontosTuristicos().size(); i++) {
			if (per.getPontosTuristicos().get(i).getNomeCidade()
					.equals(nomeCidade))
				return per.getPontosTuristicos().get(i);
		}
		ger.persistir();
		return null;
	}

	public boolean removerPontoTuristicoPorNome(String nome)
			throws NullPointerException {
		for (int i = 0; i < per.getPontosTuristicos().size(); i++) {
			if (per.getPontosTuristicos().get(i).getNome().equals(nome)) {
				per.getPontosTuristicos().remove(
						per.getPontosTuristicos().get(i));
				return true;
			}
		}
		ger.persistir();
		return false;

	}

}
