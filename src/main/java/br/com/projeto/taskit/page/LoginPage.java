package br.com.projeto.taskit.page;

import br.com.projeto.core.BasePage;

// Classe com os elementos da p�gina
public class LoginPage extends BasePage {

	public void Botaocadastrar() {
		// Passa como par�metro o ID do bot�o que quer clicar
		dsl.clicarBotaoPorID("signup");
	}

	public void setNome(String nomeCompleto) {

		dsl.escrever("signupbox", "name", nomeCompleto);
	}

	public void setLogin(String login) {

		dsl.escrever("signupbox", "login", login);

	}

	public void setSenha(String senha) {

		dsl.escrever("signupbox", "password", senha);

	}
	
	public void salvar() {
		
	dsl.clicarBotaoPorIDeTextVisible("signupbox", "SAVE");
		
	}

}
