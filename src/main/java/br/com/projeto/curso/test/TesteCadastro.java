package br.com.projeto.curso.test;
import static br.com.projeto.core.DriverFactory.getDriver;

import org.junit.Before;
import org.junit.Test;

import br.com.projeto.core.BaseTest;
import br.com.projeto.curso.page.CampoTreinamentoPage;

public class TesteCadastro extends BaseTest {
	
	private CampoTreinamentoPage page;

	@Before
	public void inicializa(){

		// usar para teste
		
		getDriver().get("http://www.juliodelima.com.br/taskit/");

		/*getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");*/
		
		page = new CampoTreinamentoPage();
	}

	@Test
	public void deveRealizarCadastroComSucesso(){
		
		page.setNome("Wagner");
	/*	page.setNome("Wagner");
		page.setSobrenome("Costa");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Mestrado");
		page.setEsporte("Natacao");
		page.cadastrar();
		
		Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
		Assert.assertEquals("Wagner", page.obterNomeCadastro());
		Assert.assertEquals("Costa", page.obterSobrenomeCadastro());
		Assert.assertEquals("Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Pizza", page.obterComidaCadastro());
		Assert.assertEquals("mestrado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Natacao", page.obterEsportesCadastro());*/
	}
}
