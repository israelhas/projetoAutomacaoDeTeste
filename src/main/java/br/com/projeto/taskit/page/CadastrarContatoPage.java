package br.com.projeto.taskit.page;


import br.com.projeto.core.BasePage;

public class CadastrarContatoPage extends BasePage {

	public void clicarLinkHI() {

		dsl.clicarBotaoPorClassName("me");
	}

	public void clicarEmMoreDataAboutYou() {

		dsl.clicarBotaoPorTextVisible("MORE DATA ABOUT YOU");
	}

	public void clicarBotaoAddMoreData() {

		dsl.clicarBotaoXpath("//button[@data-target=\"addmoredata\"]");

	}

	public void selecionarEmail() {

		dsl.selecionarComboPorXpath("//Select[@name=\"type\"]", "E-mail");

	}

	public void escreverContato(String contato) {

		dsl.escrever("addmoredata", "contact", contato);
		
		
	}
	//l
	public void selecionarTelefone() {

		dsl.selecionarComboPorXpath("//Select[@name=\"type\"]", "Phone");

	}
	
	


	public void salvar() {

		dsl.clicarBotaoPorIDeTextVisible("addmoredata", "SAVE");

	}

}
