package Gerenciador;

import java.util.ArrayList;

import Logica.Cidade;
import Excecao.*;
public class GerenciadorCidades {
	
private ArrayList<Cidade> cidades = new ArrayList<Cidade>();
	
	public void cadastrarCidade(Cidade c)throws CidadeInvalidaException{
		if(c.getNome().equals(null)){
			throw new CidadeInvalidaException("Informação Invalida");
		}else
		cidades.add(c);
	}
	
	public ArrayList<Cidade> listarCidades(){
		return cidades;
	}

	public Cidade pesquisarCidadePorNome(String nome) throws NullPointerException{
		for (int i=0; i<cidades.size();i++){
			if (cidades.get(i).getNome().equals(nome))
				return cidades.get(i);				
		} return null;
	}

	
	public boolean removerCidadePorNome (String nome) throws NullPointerException{
		for (int i=0; i < cidades.size(); i++){
			if (cidades.get(i).getNome().equals(nome)){
				cidades.remove(cidades.get(i));
				return true;
			}
		}  return false;
		
	}
	

}
