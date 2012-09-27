package Logica;

import java.util.ArrayList;

import Modelo.Persistence;
import Modelo.Turista;

public class GerenciadorTurista {
	private Persistence per = Persistence.getInstance();
	private GerenciadorPersistence ger = new GerenciadorPersistence();

	public void cadastrarTurista(Turista t) {

		per.getListaTuristas().add(t);
		ger.persistir();
	}

	public ArrayList<Turista> listarTuristas() {
		ger.persistir();
		return per.getListaTuristas();
	}

	public boolean removerTuristaPorNome(String nome)
			throws NullPointerException {
		for (int i = 0; i < per.getListaTuristas().size(); i++) {
			if (per.getListaTuristas().get(i).getNome().equals(nome)) {
				per.getListaTuristas().remove(per.getListaTuristas().get(i));
				return true;
			}
		}
		ger.persistir();
		return false;

	}

	public boolean removerTuristaPorCpf(String cpf) throws NullPointerException {
		for (int i = 0; i < per.getListaTuristas().size(); i++) {
			if (per.getListaTuristas().get(i).getCpf().equals(cpf)) {
				per.getListaTuristas().remove(per.getListaTuristas().get(i));
				return true;
			}
		}
		ger.persistir();
		return false;
	}

	public Turista pesquisarTuristaPorCpf(String cpf)
			throws NullPointerException {
		for (int i = 0; i < per.getListaTuristas().size(); i++) {
			if (per.getListaTuristas().get(i).getCpf().equals(cpf))
				return per.getListaTuristas().get(i);
		}
		ger.persistir();
		return null;
	}

	public Turista pesquisarTuristaPorNome(String nome)
			throws NullPointerException {
		for (int i = 0; i < per.getListaTuristas().size(); i++) {
			if (per.getListaTuristas().get(i).getNome().equals(nome))
				return per.getListaTuristas().get(i);
		}
		ger.persistir();
		return null;
	}

}
