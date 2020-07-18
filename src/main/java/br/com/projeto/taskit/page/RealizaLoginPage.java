package br.com.projeto.taskit.page;

import org.openqa.selenium.By;

import br.com.projeto.core.BasePage;

// Na page eu chamo a classe dsl
public class RealizaLoginPage extends BasePage {

	public void clicarBotaoLogin() {
		dsl.clicarBotaoPorTextVisible("Sign in");

	}

	public void setNome(String nome) {

		dsl.escreverNoForm(By.xpath("//div[@id='signinbox']//input[@name='login']"), nome);

		// dsl.escrever("signinbox", "login", nome);
	}

	// sdiv[@id='signinbox']//input[@name='login']

	public void setSenha(String senha) {

		dsl.escreverNoForm(By.xpath("//div[@id='signinbox']//input[@name='password']"), senha);

	}

	public void logar() {

		dsl.clicarBotaoPorIDeTextVisible("signinbox", "SIGN IN");

	}

	/* Mensgem da tela */

	public String mensagemToast() {

		return dsl.obterTextoToast("toast-container");

	}

}
