package Gerenciador;

import java.util.*;

import Logica.PontoTuristico;

public class GerenciadorPontoTuristico {
	
private ArrayList<PontoTuristico> pontosTuristicos = new ArrayList<PontoTuristico>();
	
	public void cadastrarPontoTuristico(PontoTuristico pt){
		pontosTuristicos.add(pt);
	}

	public ArrayList<PontoTuristico> listarPontoTuristico(){
		ArrayList<PontoTuristico> aux = new ArrayList<PontoTuristico>() ;
		for (int i=0; i<pontosTuristicos.size();i++){
			aux.set(i, pontosTuristicos.get(i));
		}
		return aux;
	}

	public PontoTuristico pesquisarPontoTuristicoPorNome(String nome) throws NullPointerException {
		for (int i=0; i<pontosTuristicos.size();i++){
			if (pontosTuristicos.get(i).getNome().equals(nome))
				return pontosTuristicos.get(i);				
		} return null;
	}
	
	public PontoTuristico pesquisarPontoTuristicoPorCidade(String nomeCidade) throws NullPointerException {
		for (int i=0; i<pontosTuristicos.size();i++){
			if (pontosTuristicos.get(i).getNomeCidade().equals(nomeCidade))
				return pontosTuristicos.get(i);				
		} return null;
	}

	
	public boolean removerPontoTuristicoPorNome(String nome) throws NullPointerException{
		for (int i=0; i < pontosTuristicos.size(); i++){
			if (pontosTuristicos.get(i).getNome().equals(nome)){
				pontosTuristicos.remove(pontosTuristicos.get(i));
				return true;
			} 
		}
		return false;
		
	}

}
