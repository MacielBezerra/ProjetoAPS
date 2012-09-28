package Modelo;


import java.io.Serializable;

import java.util.*;

public class Persistence implements Serializable {

	private static Persistence instance = null;

	ArrayList<Turista> listaTuristas;
	ArrayList<Cidade> cidades;
	ArrayList<AgenciaDeTaxi> agencias;
	ArrayList<PontoTuristico> pontosTuristicos;
	ArrayList<GuiaTuristico> guias;
	ArrayList<Hospedagem> listaHospedagem;
	
	
	public Persistence() {
		listaTuristas = new ArrayList<Turista>();
		cidades = new ArrayList<Cidade>();
		agencias = new ArrayList<AgenciaDeTaxi>();
		pontosTuristicos = new ArrayList<PontoTuristico>();
		guias = new ArrayList<GuiaTuristico>();
		listaHospedagem = new ArrayList<Hospedagem>();
	}

	public static void setInstance(Persistence instance) {
		
		Persistence.instance = instance;
	}
    public static void reset(){
    	instance = null;
    }
    
	public static Persistence getInstance() {
		if (instance == null) {
			instance = new Persistence();
		}
		return instance;
	}

	public ArrayList<Turista> getListaTuristas() {
		return listaTuristas;
	}

	public ArrayList<Cidade> getCidades() {
		return cidades;
	}

	public ArrayList<AgenciaDeTaxi> getAgencias() {
		return agencias;
	}

	public ArrayList<PontoTuristico> getPontosTuristicos() {
		return pontosTuristicos;
	}

	public ArrayList<GuiaTuristico> getGuias() {
		return guias;
	}

	public ArrayList<Hospedagem> getListaHospedagem() {
		return listaHospedagem;
	}

}
