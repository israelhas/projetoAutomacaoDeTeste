package br.com.projeto.taskit.test;

import static br.com.projeto.core.DriverFactory.getDriver;


import org.junit.Before;
import org.junit.Test;

import br.com.projeto.taskit.page.RealizaLoginPage;

public class TesteRealizarLogin {

	private RealizaLoginPage page;

	@Before
	public void inicializa() {

		// usar para teste

		getDriver().get("http://www.juliodelima.com.br/taskit/");
		// getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		/*
		 * getDriver().get("file:///" + System.getProperty("user.dir") +
		 * "/src/main/resources/componentes.html");
		 */

		page = new RealizaLoginPage();
	}

	@Test
	public void realizarLogin() {

		/*
		 * ---- Debug--- 
		 * F5 - Entra no método; 
		 * F6 - excutado o método todo; 
		 * F7 - vai para o último método a ser excutado; 
		 * F7 - vai para o último método a ser excutado.
		 */
		page.clicarBotaoLogin();
		page.setNome("israel.soares");
		page.setSenha("123");
		page.logar();
		//DriverFactory.killDriver();
	

	}

}
