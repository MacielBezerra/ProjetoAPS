package Gerenciador;

import java.util.ArrayList;

import Logica.AgenciaDeTaxi;

public class GerenciadorAgenciaDeTaxi {
private ArrayList<AgenciaDeTaxi> listaAgencias = new ArrayList<AgenciaDeTaxi>();
	
	public void cadastrarAgenciaDeTaxi(AgenciaDeTaxi agencia){
		listaAgencias.add(agencia);
	}

	public AgenciaDeTaxi pesquisarAgenciaDeTaxiPorNome(String nome) {
		for (int i=0; i<listaAgencias.size();i++){
			if (listaAgencias.get(i).getNome().equals(nome))
				return listaAgencias.get(i);				
		} return null;
	}
	
	public AgenciaDeTaxi pesquisarAgenciaDeTaxiPorId(int id) throws NullPointerException {
		for (int i=0; i<listaAgencias.size();i++){
			if (listaAgencias.get(i).getId()==id)
				return listaAgencias.get(i);				
		} return null;
	}
	
	public boolean removerAgenciaDeTaxiPorNome(String nome) throws NullPointerException{
		for (int i=0; i < listaAgencias.size(); i++){
			if (listaAgencias.get(i).getNome().equals(nome)){
				listaAgencias.remove(listaAgencias.get(i));
				return true;
			} else return false;
		}
		return false;
	}
	
	public boolean removerAgenciaDeTaxiPorId(int id) throws NullPointerException{
		for (int i=0; i < listaAgencias.size(); i++){
			if (listaAgencias.get(i).getId()==id){
				listaAgencias.remove(listaAgencias.get(i));
				return true;
			} else return false;
		}
		return false;
	}
}
