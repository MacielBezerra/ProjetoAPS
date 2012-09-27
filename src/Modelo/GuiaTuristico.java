package Modelo;

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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GuiaTuristico other = (GuiaTuristico) obj;
		if (Double.doubleToLongBits(preco) != Double
				.doubleToLongBits(other.preco))
			return false;
		return true;
	}
	
	
}
