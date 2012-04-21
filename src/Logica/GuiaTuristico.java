package Logica;

import java.util.*;

public class GuiaTuristico extends Pessoa{
	public GuiaTuristico(String nome, String cpf) {
		super(nome, cpf); 
	}
	public GuiaTuristico(){}
	
	private double preco;
	private ArrayList<Idioma> linguasFaladas;
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public ArrayList<Idioma> getLinguasFaladas() {
		return linguasFaladas;
	}
	public void setLinguasFaladas(ArrayList<Idioma> linguasFaladas) {
		this.linguasFaladas = linguasFaladas;
	}
	
}
