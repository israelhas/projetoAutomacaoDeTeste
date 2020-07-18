package br.com.projeto.taskit.page;

import br.com.projeto.core.BasePage;

// Classe com os elementos da página
public class LoginPage extends BasePage {

	public void Botaocadastrar() {
		// Passa como parâmetro o ID do botão que quer clicar
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
