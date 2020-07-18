package br.com.projeto.core;

public class BasePage {


	protected DSL dsl;
//Construtor instancia a classe DSL, dessa forma não é necessário realizar a instancia dentro da Page que contem os elementos	
	public BasePage() {
		dsl = new DSL();
	}
}
