import java.util.ArrayList;


import Excecao.*;

import Logica.GerenciadorAgenciaDeTaxi;
import Logica.GerenciadorCidades;
import Logica.GerenciadorGuiaTuristico;
import Logica.GerenciadorHospedagem;
import Logica.GerenciadorPontoTuristico;
import Logica.GerenciadorTurista;
import Modelo.*;

public class Fachada {
	private GerenciadorGuiaTuristico ggt = new GerenciadorGuiaTuristico();
	private GerenciadorTurista gt = new GerenciadorTurista();
	private GerenciadorAgenciaDeTaxi gtax = new GerenciadorAgenciaDeTaxi();
	private GerenciadorPontoTuristico gpt = new GerenciadorPontoTuristico();
	private GerenciadorCidades gc = new GerenciadorCidades();
	private GerenciadorHospedagem gh = new GerenciadorHospedagem();

	// Gerenciador Guia Turístico
	public void cadastrarGuiaTuristico(GuiaTuristico guia) {
		ggt.cadastrarGuiaTuristico(guia);
	}

	public GuiaTuristico pesquisarGuiaTuristicoPorNome(String nome) {
		return ggt.pesquisarGuiaTuristicoPorNome(nome);
	}

	public GuiaTuristico pesquisarGuiaTuristicoPorCpf(String cpf) {
		return ggt.pesquisarGuiaTuristicoPorCpf(cpf);
	}

	public boolean removerGuiaTuristicoPorNome(String nome) {
		return ggt.removerGuiaTuristicoPorNome(nome);
	}

	public boolean removerGuiaTuristicoPorCpf(String cpf) {
		return ggt.removerGuiaTuristicoPorCpf(cpf);
	}

	// Gerenciador Ponto Turístico
	public void cadastrarPontoTuristico(PontoTuristico pt) {
		gpt.cadastrarPontoTuristico(pt);
	}

	public boolean removerPontoTuristicoPorNome(String nome) {
		return gpt.removerPontoTuristicoPorNome(nome);
	}

	public PontoTuristico pesquisarPontoTuristicoPorNome(String nome) {
		return gpt.pesquisarPontoTuristicoPorNome(nome);
	}

	public PontoTuristico pesquisarPontoTuristicoPorCidade(String nomeCidade) {
		return gpt.pesquisarPontoTuristicoPorCidade(nomeCidade);
	}

	// Gerenciador de Agência de Taxi
	public void cadastrarAgenciaDeTaxi(AgenciaDeTaxi agencia) {
		gtax.cadastrarAgenciaDeTaxi(agencia);
	}

	public boolean removerAgenciaDeTaxiPorNome(String nome) {
		return gtax.removerAgenciaDeTaxiPorNome(nome);
	}

	public boolean removerAgenciaDeTaxiPorId(int id) {
		return gtax.removerAgenciaDeTaxiPorId(id);
	}

	public AgenciaDeTaxi pesquisarAgenciaDeTaxiPorId(int id) {
		return gtax.pesquisarAgenciaDeTaxiPorId(id);
	}

	public AgenciaDeTaxi pesquisarAgenciaDeTaxiPorNome(String nome) {
		return gtax.pesquisarAgenciaDeTaxiPorNome(nome);
	}

	// Gerenciador de Cidades
	public void cadastrarCidade(Cidade c) throws CidadeInvalidaException {
		gc.cadastrarCidade(c);
	}

	public boolean removerCidadePorNome(String nome) {
		return gc.removerCidadePorNome(nome);
	}

	public Cidade pesquisarCidadePorNome(String nome) {
		return gc.pesquisarCidadePorNome(nome);
	}

	// Gerenciador Turísta
	public void cadastrarTurista(Turista t) throws TuristaInvalidoException {
		gt.cadastrarTurista(t);
	}

	public Turista pesquisarTuristaPorCpf(String cpf) {

		return gt.pesquisarTuristaPorCpf(cpf);
	}

	public Turista pesquisarTuristaPorNome(String nome) {
		return gt.pesquisarTuristaPorNome(nome);
	}

	public boolean removerTuristaPorNome(String nome) {
		return gt.removerTuristaPorNome(nome);
	}

	public boolean removerTuristaPorCpf(String cpf) {
		return gt.removerTuristaPorCpf(cpf);
	}

	// Gerenciador Hospedagem
	public void cadastrarHospedagem(Hospedagem h)
			throws HospedagemInvalidaException {
		gh.cadastrarHospedagem(h);
	}

	public Hospedagem pesquisarHospedagemPorNome(String nome) {
		return gh.pesquisarHospedagemPorNome(nome);
	}

	public boolean removerHospedagemPorId(int id) {
		return gh.removerHospedagemPorId(id);
	}

	public ArrayList<Turista> listarTuristas() {
		return gt.listarTuristas();
	}

	public ArrayList<Cidade> listarCidade() {
		return gc.listarCidades();
	}

	public ArrayList<Hospedagem> listarHospedagem() {
		return gh.listarHospedagens();
	}
	public ArrayList<GuiaTuristico> listarGuiasTuristicos(){
		return ggt.listarGuiasTuristicos();
	}
	public ArrayList<PontoTuristico> listarPontosTuristicos(){
		return gpt.listarPontoTuristico();
	}
	public ArrayList<AgenciaDeTaxi> listarAgenciaDeTaxi(){
		return gtax.listarAgenciaDeTaxi();
	}
}
