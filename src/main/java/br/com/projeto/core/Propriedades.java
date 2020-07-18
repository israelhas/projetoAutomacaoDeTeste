package br.com.projeto.core;

/*
Com essa classe � poss�vel escolher se para cada teste ser� criada uma nova inst�ncia do navegador(abrir e fechar) ou n�o, se a vari�vel 
estivar como false, os testes da classe ser� executado em uma �nica inst�ncia do navegador, caso contr�rio ir� criar uma inst�ncia para cada um
*/
public class Propriedades {
	
	public static boolean FECHAR_BROWSER = false; //true
	
	// navegado padr�o para executar os testes
	public static Browsers browser = Browsers.CHROME;
	
	public enum Browsers {
		
		// navegadores dispon�veis para execu��o do teste
		CHROME,
		FIREFOX
	}

}
