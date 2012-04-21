
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Logica.AgenciaDeTaxi;
import Logica.Cidade;
import Logica.Endereco;
import Logica.GuiaTuristico;
import Logica.Hospedagem;
import Logica.PontoTuristico;
import Logica.Turista;
import Excecao.*;

public class TesteFachada {
	
	private Fachada f;
	private Turista t;
	private GuiaTuristico gt; 
	private AgenciaDeTaxi agencia;
	private Hospedagem h;
    private Cidade c;
    private PontoTuristico p;
    private Endereco e;
    

	@Before
	public void setUp(){//toda vez cria uma nova fachada para testar
		f = new Fachada();
		t = new Turista("João", "123");
		gt = new GuiaTuristico();
		agencia = new AgenciaDeTaxi();
		h = new Hospedagem();
		c=new Cidade();
		p=new PontoTuristico();
		e=new Endereco();
	}
	
	//Teste cadastros existente
	
	@Test
	public void testCadastrarTuristaExistente() throws TuristaInvalidoException{
		f.cadastrarTurista(t);
		Turista turista = f.pesquisarTuristaPorCpf("123");
		Assert.assertEquals("João",turista.getNome());
		Assert.assertEquals( "123",turista.getCpf());//minha espectativa eh "123", vou pesquisar ver se tenho pelo get
	}
	
	@Test
	public void testCadastrarGuiaTuristaExistente(){
		gt.setNome("Zico");
		gt.setCpf("121");
		f.cadastrarGuiaTuristico(gt);
		GuiaTuristico guia = f.pesquisarGuiaTuristicoPorNome("Zico");
		Assert.assertEquals("Zico",guia.getNome());
	}
	
	@Test
	public void testCadastrarAgenciaDeTaxiExistente(){
		agencia.setNome("Taxi da praca");
		agencia.setId(1);
		f.cadastrarAgenciaDeTaxi(agencia);
		AgenciaDeTaxi aux = f.pesquisarAgenciaDeTaxiPorNome("Taxi da praca");
		Assert.assertEquals("Taxi da praca",aux.getNome());
		Assert.assertEquals(1 , aux.getId());
		AgenciaDeTaxi aux2 = new AgenciaDeTaxi();
		aux2.setId(2);
		aux2.setNome("Viação Rio Tinto");
		Assert.assertEquals("Viação Rio Tinto",aux2.getNome());
		Assert.assertEquals(aux2.getId(), 2);
	}
	
	@Test
	public void testCadastrarHospedagemExistente () throws HospedagemInvalidaException{
		h.setNome("Pousada Miramar");
		h.setId(1);
		f.cadastrarHospedagem(h);
		Hospedagem h = f.pesquisarHospedagemPorNome("Pousada Miramar");
		Assert.assertEquals("Pousada Miramar",h.getNome());
		Assert.assertEquals(h.getId(), 1);
	}
	
	@Test
	public void testCadastrarCidadeExistente() throws CidadeInvalidaException{
		c.setNome("Natal");
		f.cadastrarCidade(c);
		Cidade c= f.pesquisarCidadePorNome("Natal");
		Assert.assertEquals("Natal",c.getNome());
	}
	
	@Test
	public void testCadastrarPontoTuristicoExistente(){
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
		PontoTuristico p= f.pesquisarPontoTuristicoPorNome("Morro do Carreca");
						 // f.pesquisarPontoTuristicoPorCidade("Natal");
		Assert.assertEquals("Morro do Carreca", p.getNome());
		//Assert.assertEquals("Natal", p.getNomeCidade());
	}
	
	//Testes Pesquisar
	
	@Test
	public void testPesquisarTuristaExistentePorNome() throws TuristaInvalidoException{
		f.cadastrarTurista(t);
		Turista aux = f.pesquisarTuristaPorNome("João");
		Assert.assertEquals("João",aux.getNome());
		
	}
	
	@Test
	public void testPesquisarTuristaExistentePorCpf() throws TuristaInvalidoException{
		f.cadastrarTurista(t);
		Turista aux = f.pesquisarTuristaPorCpf("123");
		Assert.assertEquals("123",aux.getCpf());
		
	}
	
	
	@Test
	public void testPesquisarGuiaTuristicoExistentePorNome(){
		GuiaTuristico guia=new GuiaTuristico();
		guia.setNome("Maciel");
		guia.setCpf("1234");
		f.cadastrarGuiaTuristico(guia);
		GuiaTuristico gt1= f.pesquisarGuiaTuristicoPorCpf("1234");
		GuiaTuristico gt2=f.pesquisarGuiaTuristicoPorNome("Maciel");
		Assert.assertEquals("Maciel",gt2.getNome());
	}
	
	@Test
	public void testPesquisarGuiaTuristicoExistentePorCpf(){
		GuiaTuristico guia1 = new GuiaTuristico();
		guia1.setNome("Jose");
		guia1.setCpf("12");
		f.cadastrarGuiaTuristico(guia1);
		GuiaTuristico gt1= f.pesquisarGuiaTuristicoPorCpf("12");
		Assert.assertEquals("Jose",gt1.getNome());
		
	}
	
	
	@Test
	public void testPesquisarAgenciaDeTaxiExistentePorNome(){
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
		AgenciaDeTaxi agt=f.pesquisarAgenciaDeTaxiPorNome("Rio Grande");
		Assert.assertEquals("Rio Grande", agt.getNome());
		
	}
	
	@Test
	public void testPesquisarAgenciaDeTaxiExistentePorId(){
		AgenciaDeTaxi agi=new AgenciaDeTaxi();
		agi.setId(19090);
		f.cadastrarAgenciaDeTaxi(agi);
		AgenciaDeTaxi aux = f.pesquisarAgenciaDeTaxiPorId(19090);
		Assert.assertEquals(19090,aux.getId());
		
	}
	
	@Test
	public void testPesquisarCidadeExistentePorNome() throws CidadeInvalidaException{
		c.setNome("Rio Tinto");
		f.cadastrarCidade(c);
		Cidade ci=f.pesquisarCidadePorNome("Rio Tinto");
		Assert.assertEquals("Rio Tinto", ci.getNome());
		
	}
	
	@Test
	public void testPesquisarHospedagemExistentePorNome() throws HospedagemInvalidaException{
		h.setNome("Pousada das Ocas");
		f.cadastrarHospedagem(h);
		Hospedagem h1 = f.pesquisarHospedagemPorNome("Pousada das Ocas");
		Assert.assertEquals("Pousada das Ocas",h1.getNome());
		
	}
	
	//Remover existente
	
	@Test
	public void testRemoverTuristaExistentePorNome() throws TuristaInvalidoException{
		Turista turista=new Turista("Fandangos", "12345");
		f.cadastrarTurista(turista);
		Turista t1	= f.pesquisarTuristaPorNome("Fandangos");
		Assert.assertEquals("Fandangos",t1.getNome());//blz 
		f.removerTuristaPorNome("Fandangos");
		Assert.assertFalse(f.removerTuristaPorNome("Fandangos"));
		Turista t2 = f.pesquisarTuristaPorNome("Fandangos");
		Assert.assertNull(t2);
		
	}
	public void testRemoverTursitaExistentePorCpf() throws TuristaInvalidoException{
		Turista turistaT=new Turista("Flamengo", "999");
		f.cadastrarTurista(turistaT);
		Turista tr1	= f.pesquisarTuristaPorCpf("999");
		Assert.assertEquals("999",tr1.getCpf());//blz 
		f.removerTuristaPorCpf("999");
		Assert.assertFalse(f.removerTuristaPorCpf("999"));
		Turista tr2 = f.pesquisarTuristaPorCpf("999");
		Assert.assertNull(tr2);
		
	}
	
	@Test
	public void testRemoverGuiaTuristaExistente(){
		GuiaTuristico gt=new GuiaTuristico();
		gt.setNome("Manuel");
		gt.setIdade(34);
	    f.cadastrarGuiaTuristico(gt);
	    GuiaTuristico gt1=f.pesquisarGuiaTuristicoPorNome("Manuel");
	    Assert.assertEquals("Manuel", gt1.getNome());
	    f.removerGuiaTuristicoPorNome("Manuel");
	    Assert.assertFalse(f.removerGuiaTuristicoPorNome("Manuel"));
	    GuiaTuristico gt2= f.pesquisarGuiaTuristicoPorNome("Manuel");
	    Assert.assertNull(gt2);
	}
	
	@Test
	public void testRemoverAgenciaDeTaxiExistente(){
		AgenciaDeTaxi agT=new AgenciaDeTaxi();
		agT.setNome("Jurubeba");
		agT.setCnpj("123490");
		e.setEstado("Rio Grande do Norte");
		e.setBairro("Varzea Nova");
		agT.setEndereco(e);
		f.cadastrarAgenciaDeTaxi(agT);
		AgenciaDeTaxi agt1= f.pesquisarAgenciaDeTaxiPorNome("Jurubeba");
		Assert.assertEquals("Jurubeba", agt1.getNome());
		f.removerAgenciaDeTaxiPorNome("Jurubeba");
		Assert.assertFalse(f.removerAgenciaDeTaxiPorNome("Jurubeba"));
		AgenciaDeTaxi agt2= f.pesquisarAgenciaDeTaxiPorNome("Jurubeba");
		Assert.assertNull(agt2);
		
	}
	
	@Test
	public void testRemoverHospedagemExistente () throws HospedagemInvalidaException{
		Hospedagem hp=new Hospedagem();
		hp.setNome("Pousada Mirabi");
		hp.setId(5432);
		hp.setQteQuartos(13);
		hp.setQteSuite(6);
		hp.setValorDiaria(100);
		hp.setValorOrcamento(500);
		f.cadastrarHospedagem(hp);
		Hospedagem hp1= f.pesquisarHospedagemPorNome("Pousada Mirabi");
		Assert.assertEquals("Pousada Mirabi", hp1.getNome());
		f.removerHospedagemPorId(5432);
		Assert.assertTrue(f.removerHospedagemPorId(5432));
		Hospedagem hp2= f.pesquisarHospedagemPorNome("Pousada Mirabi");
		Assert.assertNull(hp2);
		
	}
	
	@Test
	public void testRemoverCidadeExistente() throws CidadeInvalidaException{
		Cidade c=new Cidade();
		c.setNome("Baia da Traição");
		f.cadastrarCidade(c);
		Cidade c1= f.pesquisarCidadePorNome("Baia da Traição");
		Assert.assertEquals("Baia da Traição", c1.getNome());
		f.removerCidadePorNome("Baia da Traição");
		Assert.assertFalse(f.removerCidadePorNome("Baia da Traição"));
		Cidade c2= f.pesquisarCidadePorNome("Baia da Traição");
		Assert.assertNull(c2);
		
	}
	
	@Test
	public void testRemoverPontoTuristicoExistente(){
		p.setNome("Ponta do Seixas");
		f.cadastrarPontoTuristico(p);
		PontoTuristico pt = f.pesquisarPontoTuristicoPorNome("Ponta do Seixas");
		Assert.assertEquals("Ponta do Seixas", pt.getNome());
		f.removerPontoTuristicoPorNome("Ponta do Seixas");
		Assert.assertFalse(f.removerPontoTuristicoPorNome("Ponta do Seixas"));
		PontoTuristico pt1 = f.pesquisarPontoTuristicoPorNome("PontoTuristico");
		Assert.assertNull(pt1);
				
	}
	
	//Cadastrar Inexistente
	@Test(expected=TuristaInvalidoException.class)
	public void testCadastrarTuristaInexistente() throws TuristaInvalidoException{
		Turista t4 = new Turista("Antoin Jurema",null);
		f.cadastrarTurista(t4);
	}
	//Listar
	@Test
	public void testListarTuristas() throws TuristaInvalidoException{
		Turista t1 = new Turista("Paulo","123");
		Turista t2 = new Turista("Antoin Jurema","456");
		Turista t3 = new Turista("bastiana","768");
		f.cadastrarTurista(t1);
		f.cadastrarTurista(t2);
		f.cadastrarTurista(t3);
		ArrayList<Turista> aux = f.listarTuristas();
		int cont = 0;
		for(Turista t: aux){
			cont++;
		}
		
		Assert.assertEquals(3,cont);
	}
	@Test
	public void testListarCidades() throws CidadeInvalidaException{
		Cidade c2 =new Cidade();
		Cidade c1=new Cidade();
		Cidade c3=new Cidade();
		c1.setNome("Natal");
		c2.setNome("Mamanguape");
		c3.setNome("João Pessoa");
		f.cadastrarCidade(c1);
		f.cadastrarCidade(c2);
		f.cadastrarCidade(c3);
		ArrayList<Cidade>aux=f.listarCidade();
		int cont=0;
		for(Cidade c: aux){
			cont++;
		}
		Assert.assertEquals(3,cont);
	}
	@Test
	public void testListarHospedagem() throws HospedagemInvalidaException{
		Hospedagem h1 =new Hospedagem();
		Hospedagem h2=new Hospedagem();
		Hospedagem h3=new Hospedagem();
		h1.setNome("Hotel Grande");
		h2.setNome("Hotel Pousada");
		f.cadastrarHospedagem(h1);
		f.cadastrarHospedagem(h2);
		ArrayList<Hospedagem>aux=f.listarHospedagem();
		int cont=0;
		for(Hospedagem h: aux){
			 cont++;
		 }
		 Assert.assertEquals(2,cont);
	}
}
