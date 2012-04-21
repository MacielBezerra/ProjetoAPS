package Gerenciador;
import java.util.ArrayList;
import Excecao.*;
import Logica.Hospedagem;


public class GerenciadorHospedagem {
private ArrayList<Hospedagem> listaHospedagem = new ArrayList<Hospedagem>();
	
	public void cadastrarHospedagem(Hospedagem h) throws HospedagemInvalidaException{
		if(h.getNome().equals(null)){
			throw new HospedagemInvalidaException("informação invalida");
		}else
		listaHospedagem.add(h);		
	}
	
	public ArrayList<Hospedagem> listarHospedagens(){
		return listaHospedagem;
	}

	public boolean removerHospedagemPorId(int id) throws NullPointerException{
		for (int i=0; i < listaHospedagem.size(); i++){
			if (listaHospedagem.get(i).getId()==id){
				listaHospedagem.remove(listaHospedagem.get(i));
				return true;
			} 
		}
		return true;
	}
	
	public Hospedagem pesquisarHospedagemPorNome(String nome) throws NullPointerException{
		for (int i=0; i < listaHospedagem.size(); i++){
			if (listaHospedagem.get(i).getNome().equals(nome))
				return listaHospedagem.get(i);
		}
		return null;
	}
	
	
	public double valorHospedagem (String nome){
		Hospedagem aux = pesquisarHospedagemPorNome(nome);
		double d = aux.getValorOrcamento();
		return d;
	}

}
