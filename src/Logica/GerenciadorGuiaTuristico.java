package Logica;
import java.util.*;


import Modelo.GuiaTuristico;
import Modelo.Persistence;

public class GerenciadorGuiaTuristico {

	private Persistence per = Persistence.getInstance();
	private GerenciadorPersistence ger = new GerenciadorPersistence();

	public void cadastrarGuiaTuristico(GuiaTuristico guia){

		per.getGuias().add(guia);
		ger.persistir();
	}

	public ArrayList<GuiaTuristico> listarGuiasTuristicos(){
		ger.persistir();
		return per.getGuias();
	}

	public GuiaTuristico pesquisarGuiaTuristicoPorNome(String nome)throws NullPointerException {
		for (int i=0; i<per.getGuias().size();i++){
			if (per.getGuias().get(i).getNome().equals(nome))
				return per.getGuias().get(i);				
		}
		ger.persistir();
		return null;
	}

	public GuiaTuristico pesquisarGuiaTuristicoPorCpf(String cpf) throws NullPointerException{
		for (int i=0; i<per.getGuias().size();i++){
			if (per.getGuias().get(i).getCpf().equals(cpf))
				return per.getGuias().get(i);				
		}
		ger.persistir(); 
		return null;
	}

	public boolean removerGuiaTuristicoPorNome(String nome) throws NullPointerException{
		for (int i=0; i < per.getGuias().size(); i++){
			if (per.getGuias().get(i).getNome().equals(nome)){
				per.getGuias().remove(per.getGuias().get(i));
				return true;
			} 
		}
		ger.persistir();
		return false; 
	}

	public boolean removerGuiaTuristicoPorCpf(String cpf) throws NullPointerException{
		for (int i=0; i < per.getGuias().size(); i++){
			if (per.getGuias().get(i).getCpf().equals(cpf)){
				per.getGuias().remove(per.getGuias().get(i));
				return true;
			} 
		}
		ger.persistir();
		return false; 
	}
}
