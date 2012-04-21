package Gerenciador;
import java.util.*;


import Logica.GuiaTuristico;

public class GerenciadorGuiaTuristico {
	private ArrayList<GuiaTuristico> guias = new ArrayList<GuiaTuristico>();
	
	public void cadastrarGuiaTuristico(GuiaTuristico guia){
			guias.add(guia);	   
	}

	public ArrayList<GuiaTuristico> listarGuiasTuristicos(){
		ArrayList<GuiaTuristico> aux = new ArrayList<GuiaTuristico>() ;
		for (int i=0; i<guias.size();i++){
			aux.set(i, guias.get(i));
		}
		return aux;
	}

	public GuiaTuristico pesquisarGuiaTuristicoPorNome(String nome)throws NullPointerException {
		for (int i=0; i<guias.size();i++){
			if (guias.get(i).getNome().equals(nome))
				return guias.get(i);				
		} return null;
	}

	public GuiaTuristico pesquisarGuiaTuristicoPorCpf(String cpf) throws NullPointerException{
		for (int i=0; i<guias.size();i++){
			if (guias.get(i).getCpf().equals(cpf))
				return guias.get(i);				
		} return null;
	}
	
	public boolean removerGuiaTuristicoPorNome(String nome) throws NullPointerException{
		for (int i=0; i < guias.size(); i++){
			if (guias.get(i).getNome().equals(nome)){
				guias.remove(guias.get(i));
				return true;
			} 
		}
	      return false; 
	}
	
	public boolean removerGuiaTuristicoPorCpf(String cpf) throws NullPointerException{
		for (int i=0; i < guias.size(); i++){
			if (guias.get(i).getCpf().equals(cpf)){
				guias.remove(guias.get(i));
				return true;
			} 
		}
	      return false; 
	}
}
