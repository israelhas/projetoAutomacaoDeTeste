package br.com.projeto.taskit.test;

import static br.com.projeto.core.DriverFactory.getDriver;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import br.com.projeto.core.BaseTest;
import br.com.projeto.core.DSL;
import br.com.projeto.taskit.page.RealizaLoginPage;

//Classe criada para realizar o testes negativos, validar as mensagens 
// Técnica chamada DDT Data drivin testing, teste orientado a dados. Exemplo 1
@RunWith(Parameterized.class)
public class TesteRegrasRealizarLogin extends BaseTest {

	private RealizaLoginPage page;

	@Parameter
	public String nome;
	@Parameter(value = 1)
	public String senha;
	@Parameter(value = 2)
	public String msg;

	@Before
	public void inicializa() {

		getDriver().get("http://www.juliodelima.com.br/taskit/");

		new DSL();
		page = new RealizaLoginPage();

	}

	@Parameters
	public static Collection<Object[]> getCollection() {
		return Arrays.asList(new Object[][] {

				{ "israel.soares", "12fgfgg", "Maybe you brain dropped the password or login in some place!" },
				{ "", "123456", "Maybe you brain dropped the password or login in some place!" }
			//	{ "", "", "Maybe you brain dropped the password or login in some place!" }
				//{ "israel.soares", "1234", "Maybe you brain dropped the password or login in some place!" }

		});
	}

	@Test
	public void deveValidarRegras() {

		page.clicarBotaoLogin();
		page.setNome(nome);
		page.setSenha(senha);
		page.logar();
		page.mensagemToast();
		Assert.assertEquals(msg, page.mensagemToast());
		System.out.println("Mensagem método: " + page.mensagemToast());
		System.out.println("Mensagem variável: " + msg);

	}

}
