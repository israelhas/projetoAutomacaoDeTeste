package br.com.projeto.taskit.test;

import static br.com.projeto.core.DriverFactory.getDriver;


import org.junit.Before;
import org.junit.Test;
import br.com.projeto.core.BaseTest;
import br.com.projeto.taskit.page.LoginPage;

/*
 *  primeira coisa a se verificar ao procurar um elemento é se ele possui ID
 */
public class TesteLogin extends BaseTest {

	private LoginPage page;

	@Before
	public void inicializa() {

		getDriver().get("http://www.juliodelima.com.br/taskit/");
		//getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		page = new LoginPage();
	}

	@Test
	public void cadastrarLogin() {

		page.Botaocadastrar();
		page.setNome("Israel da Silva Soares");
		page.setLogin("israel.soares");
		page.setSenha("Test@12556");
		page.salvar();
		//DriverFactory.killDriver();
		
	}
}
