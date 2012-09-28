package Logica;

import java.util.ArrayList;

import Modelo.Cidade;
import Modelo.Persistence;

public class GerenciadorCidades {

	private Persistence per = Persistence.getInstance();
	private GerenciadorPersistence ger = new GerenciadorPersistence();

	public void cadastrarCidade(Cidade c) {

		per.getCidades().add(c);
		ger.persistir();
	}

	public ArrayList<Cidade> listarCidades() {
		ger.persistir();
		return per.getCidades();
	}

	public Cidade pesquisarCidadePorNome(String nome)
			throws NullPointerException {
		for (int i = 0; i < per.getCidades().size(); i++) {
			if (per.getCidades().get(i).getNome().equals(nome))
				return per.getCidades().get(i);
		}
		ger.persistir();
		return null;
	}

	public boolean removerCidadePorNome(String nome)
			throws NullPointerException {
		for (int i = 0; i < per.getCidades().size(); i++) {
			if (per.getCidades().get(i).getNome().equals(nome)) {
				per.getCidades().remove(per.getCidades().get(i));
				return true;
			}
		}
		ger.persistir();
		return false;

	}

}
