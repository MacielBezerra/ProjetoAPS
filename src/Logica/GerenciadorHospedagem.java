package Logica;

import java.util.ArrayList;
import Modelo.Hospedagem;
import Modelo.Persistence;

public class GerenciadorHospedagem {

	private Persistence per = Persistence.getInstance();
	private GerenciadorPersistence ger = new GerenciadorPersistence();

	public void cadastrarHospedagem(Hospedagem h) {

		per.getListaHospedagem().add(h);
		ger.persistir();
	}

	public ArrayList<Hospedagem> listarHospedagens() {
		ger.persistir();
		return per.getListaHospedagem();
	}

	public boolean removerHospedagemPorId(int id) throws NullPointerException {
		for (int i = 0; i < per.getListaHospedagem().size(); i++) {
			if (per.getListaHospedagem().get(i).getId() == id) {
				per.getListaHospedagem().remove(per.getListaHospedagem().get(i));
				return true;
			}
		}
		ger.persistir();
		return true;
	}

	public Hospedagem pesquisarHospedagemPorNome(String nome)
			throws NullPointerException {
		for (int i = 0; i < per.getListaHospedagem().size(); i++) {
			if (per.getListaHospedagem().get(i).getNome().equals(nome))
				return per.getListaHospedagem().get(i);
		}
		ger.persistir();
		return null;
	}

	public double valorHospedagem(String nome) {
		Hospedagem aux = pesquisarHospedagemPorNome(nome);
		double d = aux.getValorOrcamento();
		return d;
	}

}
