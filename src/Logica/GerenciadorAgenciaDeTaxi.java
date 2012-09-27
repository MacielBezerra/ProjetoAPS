package Logica;

import java.util.ArrayList;
import Modelo.AgenciaDeTaxi;
import Modelo.GuiaTuristico;
import Modelo.Persistence;

public class GerenciadorAgenciaDeTaxi {

	private Persistence per = Persistence.getInstance();
	private GerenciadorPersistence ger = new GerenciadorPersistence();

	public void cadastrarAgenciaDeTaxi(AgenciaDeTaxi agencia){

		per.getAgencias().add(agencia);
		ger.persistir();		
	}
	public ArrayList<AgenciaDeTaxi> listarAgenciaDeTaxi(){
		ger.persistir();
		return per.getAgencias();
	}

	public AgenciaDeTaxi pesquisarAgenciaDeTaxiPorNome(String nome) throws NullPointerException  {

		for (int i = 0; i < per.getAgencias().size(); i++) {
			if (per.getAgencias().get(i).getNome().equals(nome))
				return per.getAgencias().get(i);
		}
		ger.persistir();
		return null;
	}

	public AgenciaDeTaxi pesquisarAgenciaDeTaxiPorId(int id)throws NullPointerException {
		for (int i = 0; i < per.getAgencias().size(); i++) {
			if (per.getAgencias().get(i).getId() == id)
				return per.getAgencias().get(i);
		}
		ger.persistir();
		return null;
	}

	public boolean removerAgenciaDeTaxiPorNome(String nome)
			throws NullPointerException {
		for (int i = 0; i < per.getAgencias().size(); i++) {
			if (per.getAgencias().get(i).getNome().equals(nome)) {
				per.getAgencias().remove(per.getAgencias().get(i));
				return true;
			} else
				return false;
		}
		ger.persistir();
		return false;
	}

	public boolean removerAgenciaDeTaxiPorId(int id)
			throws NullPointerException {
		for (int i = 0; i < per.getAgencias().size(); i++) {
			if (per.getAgencias().get(i).getId() == id) {
				per.getAgencias().remove(per.getAgencias().get(i));
				return true;
			} else
				return false;
		}
		ger.persistir();
		return false;
	}
}
