import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Logica.GerenciadorPersistence;
import Modelo.AgenciaDeTaxi;
import Modelo.Cidade;
import Modelo.Endereco;
import Modelo.GuiaTuristico;
import Modelo.Hospedagem;
import Modelo.Persistence;
import Modelo.PontoTuristico;
import Modelo.Turista;
import Excecao.*;

public class TesteFachada {

	private Persistence persist;
	private Fachada f;
	private Turista t;
	private GuiaTuristico gt;
	private AgenciaDeTaxi agencia;
	private Hospedagem h;
	private Cidade c;
	private PontoTuristico p;
	private Endereco e;
	private TuristaInvalidoException tu;
	private GuiaTuristicoInvalidoException gui;
	private HospedagemInvalidaException hsp;
	private AgenciaDeTaxiInvalidaException agte;
	private PontoTuristicoInvalidoException Ptrst;
	private GerenciadorPersistence ger;

	@Before
	public void setUp(){
		// toda vez cria uma nova fachada para testar
		f = new Fachada();
		t = new Turista("João", "123");
		gt = new GuiaTuristico();
		agencia = new AgenciaDeTaxi();
		h = new Hospedagem();
		c = new Cidade();
		p = new PontoTuristico();
		e = new Endereco();
		persist = new Persistence();
		tu = new TuristaInvalidoException(null);
		gui = new GuiaTuristicoInvalidoException(null);
		hsp = new HospedagemInvalidaException(null);
		agte = new AgenciaDeTaxiInvalidaException(null);
		Ptrst = new PontoTuristicoInvalidoException(null);
		ger = new GerenciadorPersistence();
		persist.reset();

	}
	
	// Teste cadastros Inexistente

	@Test
	public void testCadastrarTuristaInexistente()
			throws TuristaInvalidoException {

		f.cadastrarTurista(t);
		Turista turista = f.pesquisarTuristaPorCpf("123");
		Assert.assertEquals("João", turista.getNome());
		Assert.assertEquals("123", turista.getCpf());// minha expectativa eh
		// "123", vou pesquisar
		// ver se tenho pelo get
	}

	@Test
	public void testCadastrarGuiaTuristaInexistente() {

		gt.setNome("Zico");
		gt.setCpf("121");
		f.cadastrarGuiaTuristico(gt);
		GuiaTuristico guia = f.pesquisarGuiaTuristicoPorNome("Zico");
		Assert.assertEquals("Zico", guia.getNome());
	}

	@Test
	public void testCadastrarAgenciaDeTaxiInexistente() {

		agencia.setNome("Taxi da praca");
		agencia.setId(1);
		f.cadastrarAgenciaDeTaxi(agencia);
		AgenciaDeTaxi aux = f.pesquisarAgenciaDeTaxiPorNome("Taxi da praca");
		Assert.assertEquals("Taxi da praca", aux.getNome());
		Assert.assertEquals(1, aux.getId());

	}

	@Test
	public void testCadastrarHospedagemInexistente()
			throws HospedagemInvalidaException {

		h.setNome("Pousada Miramar");
		h.setId(1);
		f.cadastrarHospedagem(h);
		Hospedagem h = f.pesquisarHospedagemPorNome("Pousada Miramar");
		Assert.assertEquals("Pousada Miramar", h.getNome());
		Assert.assertEquals(h.getId(), 1);
	}

	@Test
	public void testCadastrarCidadeInexistente() throws CidadeInvalidaException {

		c.setNome("Natal");
		f.cadastrarCidade(c);
		Cidade c = f.pesquisarCidadePorNome("Natal");
		Assert.assertEquals("Natal", c.getNome());
	}

	@Test
	public void testCadastrarPontoTuristicoInexistente() {

		c.setNome("Natal");
		p.setCidade(c);
		p.setNome("Morro do Carreca");
		e.setPais("Brasil");
		e.setEstado("Rio Grande do Norte");
		e.setBairro("Centro");
		e.setLogradouro("Rua Projetada");
		e.setNumero("512");
		p.setEndereco(e);
		f.cadastrarPontoTuristico(p);
		PontoTuristico p = f.pesquisarPontoTuristicoPorNome("Morro do Carreca");
		// f.pesquisarPontoTuristicoPorCidade("Natal");
		Assert.assertEquals("Morro do Carreca", p.getNome());
		// Assert.assertEquals("Natal", p.getNomeCidade());
	}

	// Testes Pesquisar existente
	
	@Test
	public void testPesquisarTuristaExistentePorNome()
			throws TuristaInvalidoException {

		f.cadastrarTurista(t);
		Turista aux = f.pesquisarTuristaPorNome("João");
		Assert.assertEquals("João", aux.getNome());

	}

	@Test
	public void testPesquisarTuristaExistentePorCpf()
			throws TuristaInvalidoException {

		f.cadastrarTurista(t);
		Turista aux = f.pesquisarTuristaPorCpf("123");
		Assert.assertEquals("123", aux.getCpf());

	}

	@Test
	public void testPesquisarGuiaTuristicoExistentePorNome() {

		GuiaTuristico guia = new GuiaTuristico();
		guia.setNome("Maciel");
		f.cadastrarGuiaTuristico(guia);
		GuiaTuristico gt1 = f.pesquisarGuiaTuristicoPorNome("Maciel");
		Assert.assertEquals("Maciel", gt1.getNome());
	}

	@Test
	public void testPesquisarGuiaTuristicoExistentePorCpf() {

		GuiaTuristico guia1 = new GuiaTuristico();
		guia1.setNome("Jose");
		guia1.setCpf("12");
		f.cadastrarGuiaTuristico(guia1);
		GuiaTuristico gt8 = f.pesquisarGuiaTuristicoPorCpf("12");
		Assert.assertEquals("12", gt8.getCpf());

	}

	@Test
	public void testPesquisarAgenciaDeTaxiExistentePorNome() {

		agencia.setNome("Rio Grande");
		agencia.setId(12);
		agencia.setCnpj("1233");
		e.setEstado("Rio Grande do Norte");
		e.setBairro("Centro");
		e.setLogradouro("Rua dos Amores");
		e.setNumero("89");
		e.setPais("Brasil");
		agencia.setEndereco(e);
		f.cadastrarAgenciaDeTaxi(agencia);
		AgenciaDeTaxi agt = f.pesquisarAgenciaDeTaxiPorNome("Rio Grande");
		Assert.assertEquals("Rio Grande", agt.getNome());

	}

	@Test
	public void testPesquisarAgenciaDeTaxiExistentePorId() {

		AgenciaDeTaxi agi = new AgenciaDeTaxi();
		agi.setId(19090);
		f.cadastrarAgenciaDeTaxi(agi);
		AgenciaDeTaxi aux = f.pesquisarAgenciaDeTaxiPorId(19090);
		Assert.assertEquals(19090, aux.getId());

	}

	@Test
	public void testPesquisarCidadeExistentePorNome()
			throws CidadeInvalidaException {

		c.setNome("Rio Tinto");
		f.cadastrarCidade(c);
		Cidade ci = f.pesquisarCidadePorNome("Rio Tinto");
		Assert.assertEquals("Rio Tinto", ci.getNome());

	}

	@Test
	public void testPesquisarHospedagemExistentePorNome()
			throws HospedagemInvalidaException {

		h.setNome("Pousada das Ocas");
		f.cadastrarHospedagem(h);
		Hospedagem h1 = f.pesquisarHospedagemPorNome("Pousada das Ocas");
		Assert.assertEquals("Pousada das Ocas", h1.getNome());

	}

	// Remover existente
	@Test
	public void testRemoverTuristaExistentePorNome()
			throws TuristaInvalidoException {

		Turista turista = new Turista("Jose", "12345");
		f.cadastrarTurista(turista);
		Turista t1 = f.pesquisarTuristaPorNome("Jose");
		Assert.assertEquals("Jose", t1.getNome());// blz
		f.removerTuristaPorNome("Jose");
		Assert.assertFalse(f.removerTuristaPorNome("Jose"));
		Turista t2 = f.pesquisarTuristaPorNome("Jose");
		Assert.assertNull(t2);

	}

	public void testRemoverTursitaExistentePorCpf()
			throws TuristaInvalidoException {

		Turista turistaT = new Turista("Flamengo", "999");
		f.cadastrarTurista(turistaT);
		Turista tr1 = f.pesquisarTuristaPorCpf("999");
		Assert.assertEquals("999", tr1.getCpf());// blz
		f.removerTuristaPorCpf("999");
		Assert.assertFalse(f.removerTuristaPorCpf("999"));
		Turista tr2 = f.pesquisarTuristaPorCpf("999");
		Assert.assertNull(tr2);

	}

	@Test
	public void testRemoverGuiaTuristaExistente() {

		GuiaTuristico gt = new GuiaTuristico();
		gt.setNome("Manuel");
		gt.setIdade(34);
		f.cadastrarGuiaTuristico(gt);
		GuiaTuristico gt1 = f.pesquisarGuiaTuristicoPorNome("Manuel");
		Assert.assertEquals("Manuel", gt1.getNome());
		f.removerGuiaTuristicoPorNome("Manuel");
		Assert.assertFalse(f.removerGuiaTuristicoPorNome("Manuel"));
		GuiaTuristico gt2 = f.pesquisarGuiaTuristicoPorNome("Manuel");
		Assert.assertNull(gt2);
	}

	@Test
	public void testRemoverAgenciaDeTaxiExistente() {

		AgenciaDeTaxi agT = new AgenciaDeTaxi();
		agT.setNome("Jurubeba");
		agT.setCnpj("123490");
		e.setEstado("Rio Grande do Norte");
		e.setBairro("Varzea Nova");
		agT.setEndereco(e);
		f.cadastrarAgenciaDeTaxi(agT);
		AgenciaDeTaxi agt1 = f.pesquisarAgenciaDeTaxiPorNome("Jurubeba");
		Assert.assertEquals("Jurubeba", agt1.getNome());
		f.removerAgenciaDeTaxiPorNome("Jurubeba");
		Assert.assertFalse(f.removerAgenciaDeTaxiPorNome("Jurubeba"));
		AgenciaDeTaxi agt2 = f.pesquisarAgenciaDeTaxiPorNome("Jurubeba");
		Assert.assertNull(agt2);

	}

	@Test
	public void testRemoverHospedagemExistente()
			throws HospedagemInvalidaException {

		Hospedagem hp = new Hospedagem();
		hp.setNome("Pousada Mirabi");
		hp.setId(5432);
		hp.setQteQuartos(13);
		hp.setQteSuite(6);
		hp.setValorDiaria(100);
		hp.setValorOrcamento(500);
		f.cadastrarHospedagem(hp);
		Hospedagem hp1 = f.pesquisarHospedagemPorNome("Pousada Mirabi");
		Assert.assertEquals("Pousada Mirabi", hp1.getNome());
		f.removerHospedagemPorId(5432);
		Assert.assertTrue(f.removerHospedagemPorId(5432));
		Hospedagem hp2 = f.pesquisarHospedagemPorNome("Pousada Mirabi");
		Assert.assertNull(hp2);

	}

	@Test
	public void testRemoverCidadeExistente() throws CidadeInvalidaException {

		Cidade c = new Cidade();
		c.setNome("Baia da Traição");
		f.cadastrarCidade(c);
		Cidade c1 = f.pesquisarCidadePorNome("Baia da Traição");
		Assert.assertEquals("Baia da Traição", c1.getNome());
		f.removerCidadePorNome("Baia da Traição");
		Assert.assertFalse(f.removerCidadePorNome("Baia da Traição"));
		Cidade c2 = f.pesquisarCidadePorNome("Baia da Traição");
		Assert.assertNull(c2);

	}

	@Test
	public void testRemoverPontoTuristicoExistente() {

		p.setNome("Ponta do Seixas");
		f.cadastrarPontoTuristico(p);
		PontoTuristico pt = f.pesquisarPontoTuristicoPorNome("Ponta do Seixas");
		Assert.assertEquals("Ponta do Seixas", pt.getNome());
		f.removerPontoTuristicoPorNome("Ponta do Seixas");
		Assert.assertFalse(f.removerPontoTuristicoPorNome("Ponta do Seixas"));
		PontoTuristico pt1 = f.pesquisarPontoTuristicoPorNome("PontoTuristico");
		Assert.assertNull(pt1);

	}

	// Cadastros invalidos
	@Test
	public void testCadastrarTuristaInvalido() throws TuristaInvalidoException {

		Turista t4 = new Turista("Antoin Jurema", null);
		f.cadastrarTurista(t4);
	}

	@Test
	public void testCadastrarHospedagemInvalida() throws HospedagemInvalidaException {

		Hospedagem hp = new Hospedagem();
		hp.setNome("Pousada Alinaça");
		hp.setId(000);
		f.cadastrarHospedagem(hp); 
	}

	@Test
	public void testCadastrarGuiaTuristicoInvalido() throws TuristaInvalidoException {

		GuiaTuristico guiaturististico = new GuiaTuristico("Antoin", null);
		f.cadastrarGuiaTuristico(guiaturististico);
	}

	@Test
	public void testCadastrarPontoTuristicoInvalido() throws PontoTuristicoInvalidoException{

		PontoTuristico pontoturistico= new PontoTuristico();
		pontoturistico.setNome("Cachoeira do Curralim");
		e.setCidade(null);
		e.setEstado(null);
		e.setPais(null);
		pontoturistico.setEndereco(e);
		f.cadastrarPontoTuristico(pontoturistico);

	}

	@Test
	public void testCadastrarCidadeInvalida() throws CidadeInvalidaException{

		Cidade cidade = new Cidade();
		c.setNome(null);
		c.setPontosTuristicos(null);
		f.cadastrarCidade(cidade);

	}

	//Pesquisas Invalidas
	@Test
	public void testPesquisarTuristaInvalidoPorNome() throws TuristaInvalidoException{

		Turista t = new Turista("Jose", "111111-10");
		f.cadastrarTurista(t);
		Turista t1 = f.pesquisarTuristaPorNome(null);
		Assert.assertEquals(tu.getMessage(),t1 );
	}

	@Test
	public void testPesquisarGuiaTuristicoInvaldioPorNome() throws GuiaTuristicoInvalidoException{

		GuiaTuristico guia = new GuiaTuristico();
		guia.setNome("João");
		f.cadastrarGuiaTuristico(guia);
		GuiaTuristico guia1 = f.pesquisarGuiaTuristicoPorNome(null);
		Assert.assertEquals(gui.getMessage(), guia1);
	}

	@Test
	public void testPesquisarHospedagemInvalidaPorNome() throws HospedagemInvalidaException{

		Hospedagem hospede = new Hospedagem();
		hospede.setNome("Zezinho");
		hospede.setDescricao("Localizado ao lado da mata");
		hospede.setQteQuartos(2);
		f.cadastrarHospedagem(hospede);
		Hospedagem hospede1 = f.pesquisarHospedagemPorNome(null);
		Assert.assertEquals(hsp.getMessage(), hospede1);
	}

	@Test
	public void testPesquisarAgenciaDeTaxiInvalidaPorNome() throws AgenciaDeTaxiInvalidaException {

		AgenciaDeTaxi agencia = new AgenciaDeTaxi();
		agencia.setNome("Deus nos Acuda");
		agencia.setId(99999);
		agencia.setCnpj("333333-3");
		f.cadastrarAgenciaDeTaxi(agencia);
		AgenciaDeTaxi agencia1 = f.pesquisarAgenciaDeTaxiPorNome(null);
		Assert.assertEquals(agte.getMessage(), agencia1);

	}

	//Remover Invalidos
	@Test
	public void testRemoverTuristaInvalidoPorNome() throws TuristaInvalidoException{

		Turista t = new Turista("Sebastião", "1234567-90");
		f.cadastrarTurista(t);
		boolean b = f.removerTuristaPorNome(null);

	}

	@Test
	public void testRemoverGuiaTuristicoInvalidoPorNome() throws GuiaTuristicoInvalidoException{

		GuiaTuristico guiaturististico = new GuiaTuristico("josefina", "11111111");
		f.cadastrarGuiaTuristico(guiaturististico);
		boolean b1 = f.removerGuiaTuristicoPorNome(null);

	}

	@Test
	public void testRemoverHospedagemInvalidaPorId() throws HospedagemInvalidaException{

		Hospedagem hp = new Hospedagem();
		hp.setNome("Pousda por do Sol");
		hp.setId(98776);
		f.cadastrarHospedagem(hp);
		f.removerHospedagemPorId(0000);

	}

	@Test
	public void testRemoverAgenciaDeTaxiInvalidaPorNome(){

		AgenciaDeTaxi agT = new AgenciaDeTaxi();
		agT.setNome("Campos dos colorios");
		agT.setCnpj("9999999");
		e.setEstado("Rio Grande do Sul");
		e.setBairro("Varzea Nova do Sul");
		agT.setEndereco(e);
		f.cadastrarAgenciaDeTaxi(agT);
		boolean b3 = f.removerAgenciaDeTaxiPorNome(null);

	}

	@Test
	public void testRemoverPontoTuristaInvalidoPorNome(){

		PontoTuristico pontoturistico= new PontoTuristico();
		pontoturistico.setNome("Pedra da boca");
		e.setCidade("Araruna");
		e.setEstado("PB");
		e.setPais("Brasil");
		pontoturistico.setEndereco(e);
		f.cadastrarPontoTuristico(pontoturistico);
		boolean b4 = f.removerPontoTuristicoPorNome(null);

	}

	// Listar Existentes
	@Test
	public void testListarTuristas() throws TuristaInvalidoException {

		Turista t1 = new Turista("Paulo", "123");
		Turista t2 = new Turista("Antoin Jurema", "456");
		Turista t3 = new Turista("bastiana", "768");
		f.cadastrarTurista(t1);
		f.cadastrarTurista(t2);
		f.cadastrarTurista(t3);
		ArrayList<Turista> aux = f.listarTuristas();
		Assert.assertEquals(3, aux.size());
		Assert.assertEquals(t1, aux.get(0));
		Assert.assertEquals(t2, aux.get(1));
		Assert.assertEquals(t3, aux.get(2));

	}

	@Test
	public void testListarCidades() throws CidadeInvalidaException {

		Cidade c2 = new Cidade();
		Cidade c1 = new Cidade();
		Cidade c3 = new Cidade();
		c1.setNome("Natal");
		c2.setNome("Mamanguape");
		c3.setNome("João Pessoa");
		f.cadastrarCidade(c1);
		f.cadastrarCidade(c2);
		f.cadastrarCidade(c3);
		ArrayList<Cidade> aux = f.listarCidade();
		Assert.assertEquals(3, aux.size());
		Assert.assertEquals(c1, aux.get(0));
		Assert.assertEquals(c2, aux.get(1));
		Assert.assertEquals(c3, aux.get(2));
	}

	@Test
	public void testListarHospedagem() throws HospedagemInvalidaException {

		Hospedagem h1 = new Hospedagem();
		Hospedagem h2 = new Hospedagem();
		h1.setNome("Hotel Grande");
		h2.setNome("Hotel Pousada");
		f.cadastrarHospedagem(h1);
		f.cadastrarHospedagem(h2);
		ArrayList<Hospedagem> aux = f.listarHospedagem();
		Assert.assertEquals(2, aux.size());
		Assert.assertEquals(h1, aux.get(0));
		Assert.assertEquals(h2, aux.get(1));
	}

	@Test 
	public void testListarGuiaTuristo() throws GuiaTuristicoInvalidoException{

		GuiaTuristico guia = new GuiaTuristico();
		GuiaTuristico guia1 = new GuiaTuristico();
		GuiaTuristico guia2 = new GuiaTuristico();
		guia.setNome("Jose");
		guia.setIdade(25);
		guia1.setNome("Jefferson");
		guia1.setIdade(80);
		guia2.setNome("Catatau");
		guia2.setIdade(24);
		f.cadastrarGuiaTuristico(guia);
		f.cadastrarGuiaTuristico(guia1);
		f.cadastrarGuiaTuristico(guia2);
		ArrayList<GuiaTuristico> guiasTuristicos = f.listarGuiasTuristicos();
		Assert.assertEquals(3,guiasTuristicos.size());
		Assert.assertEquals(guia, guiasTuristicos.get(0));
		Assert.assertEquals(guia1, guiasTuristicos.get(1));
		Assert.assertEquals(guia2, guiasTuristicos.get(2));
	}

	@Test
	public void testListarPontoTuristico() throws PontoTuristicoInvalidoException{

		PontoTuristico p = new PontoTuristico();
		PontoTuristico p1 = new PontoTuristico();
		Cidade c = new Cidade();
		p.setNome("Morro do Careca");
		c.setNome("Natal");
		p.setCidade(c);
		p1.setNome("Cajueiro");
		c.setNome("Ceará");
		p1.setCidade(c);
		f.cadastrarPontoTuristico(p);
		f.cadastrarPontoTuristico(p1);
		ArrayList<PontoTuristico> auxPt= f.listarPontosTuristicos();
		Assert.assertEquals(2, auxPt.size());
		Assert.assertEquals(p,auxPt.get(0));
		Assert.assertEquals(p1, auxPt.get(1));
	}

	@Test
	public void testLitarAgenciaDeTaxi() throws AgenciaDeTaxiInvalidaException{

		AgenciaDeTaxi agencia1 = new AgenciaDeTaxi();
		AgenciaDeTaxi agencia2 = new AgenciaDeTaxi();
		agencia1.setNome("Volte Sempre");
		agencia1.setCnpj("123456-1");
		e.setCidade("João Pessoa");
		agencia1.setEndereco(e);
		agencia2.setNome("Volta ao Inicio");
		agencia2.setCnpj("54321-0");
		e.setCidade("Natal");
		agencia2.setEndereco(e);
		f.cadastrarAgenciaDeTaxi(agencia1);
		f.cadastrarAgenciaDeTaxi(agencia2);
		ArrayList<AgenciaDeTaxi> auxAgt = f.listarAgenciaDeTaxi();
		Assert.assertEquals(2, auxAgt.size());
		Assert.assertEquals(agencia1, auxAgt.get(0));
		Assert.assertEquals(agencia2, auxAgt.get(1));
	}
    
}
