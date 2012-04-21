package Gerenciador;

import java.util.ArrayList;
import Excecao.ExcecaoFachada;
import Excecao.TuristaInvalidoException;
import Logica.Turista;

public class GerenciadorTurista {
 ArrayList<Turista> listaTuristas = new ArrayList<Turista>();



	public void cadastrarTurista(Turista t) throws TuristaInvalidoException{
		if(t.getCpf() == null ||t.getNome() == null){
			throw new TuristaInvalidoException("informação invalida");
		}else
		listaTuristas.add(t);
	}
	

	public ArrayList<Turista> listarTuristas(){
		return listaTuristas;
	}
		
	public boolean removerTuristaPorNome(String nome) throws NullPointerException{
		for (int i=0; i < listaTuristas.size(); i++){
			if (listaTuristas.get(i).getNome().equals(nome)){
				listaTuristas.remove(listaTuristas.get(i));
				return true;
			} 
		}
		return false;
	}
	
	public boolean removerTuristaPorCpf(String cpf) throws NullPointerException{
		for (int i=0; i < listaTuristas.size(); i++){
			if (listaTuristas.get(i).getCpf().equals(cpf)){
				listaTuristas.remove(listaTuristas.get(i));
				return true;
			} 
		}
		return false;
	}

	public Turista pesquisarTuristaPorCpf(String cpf) throws NullPointerException {
		for (int i=0; i<listaTuristas.size();i++){
			if (listaTuristas.get(i).getCpf().equals(cpf))
				return listaTuristas.get(i);
		} return null;
	}
	
	public Turista pesquisarTuristaPorNome(String nome) throws NullPointerException {
		for (int i=0; i<listaTuristas.size();i++){
			if (listaTuristas.get(i).getNome().equals(nome))
				return listaTuristas.get(i);
		} return null;
	}
	
}
