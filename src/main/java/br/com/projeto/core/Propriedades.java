package br.com.projeto.core;

/*
Com essa classe é possível escolher se para cada teste será criada uma nova instância do navegador(abrir e fechar) ou não, se a variável 
estivar como false, os testes da classe será executado em uma única instância do navegador, caso contrário irá criar uma instância para cada um
*/
public class Propriedades {
	
	public static boolean FECHAR_BROWSER = false; //true
	
	// navegado padrão para executar os testes
	public static Browsers browser = Browsers.CHROME;
	
	public enum Browsers {
		
		// navegadores disponíveis para execução do teste
		CHROME,
		FIREFOX
	}

}
