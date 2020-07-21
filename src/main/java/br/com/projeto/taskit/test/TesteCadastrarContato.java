package br.com.projeto.taskit.test;

import static br.com.projeto.core.DriverFactory.getDriver;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import br.com.projeto.core.BaseTest;
import br.com.projeto.core.DSL;
import br.com.projeto.taskit.page.CadastrarContatoPage;

public class TesteCadastrarContato extends BaseTest {

	private CadastrarContatoPage page;
	private DSL dsl;

	@Before
	public void inicializa() {

		//getDriver().get("http://www.juliodelima.com.br/taskit/"); 

		// Não pode ficar na página de teste, componente da DSL ver melhoria depois

		//getDriver().findElement(By.linkText("Sign in")).click();

		//WebElement formularioCriarLogin = getDriver().findElement(By.id("signinbox"));
		//formularioCriarLogin.findElement(By.name("login")).sendKeys("israel.soares");

		//WebElement formularioCriarLogin2 = getDriver().findElement(By.id("signinbox"));
		//formularioCriarLogin2.findElement(By.name("password")).sendKeys("123");

		//WebElement formularioCriarLogin3 = getDriver().findElement(By.id("signinbox"));
		//formularioCriarLogin3.findElement(By.linkText("SIGN IN")).click();

		// ---------------------------------------------------------------------------------------------

		new TesteRealizarLogin().realizarLogin();
		page = new CadastrarContatoPage();
		dsl = new DSL();
	}

	@Test
	public void cadastrarContato() {

		dsl.aguardarCarregamentoElemento(2);
		page.clicarLinkHI();
		page.clicarEmMoreDataAboutYou();
		page.clicarBotaoAddMoreData();
		page.selecionarEmail();
		page.escreverContato("teste@teste.com");
		page.salvar();
		page.clicarEmMoreDataAboutYou();
		page.clicarBotaoAddMoreData();
		page.selecionarTelefone();
		page.escreverContato("+5161985784455");
		page.salvar();

	}

}
