package br.com.projeto.curso.suites;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.projeto.core.DriverFactory;
import br.com.projeto.taskit.test.TesteLogin;
import br.com.projeto.taskit.test.TesteRealizarLogin;

@RunWith(Suite.class)
@SuiteClasses({
	TesteLogin.class,
	TesteRealizarLogin.class,
	//TesteCadastro.class,
	//TesteRegrasCadastro.class
})
public class SuiteTeste {
	
// Ap�s a execu��o dos testes esse m�todo finaliza o driver	
	@AfterClass
	public static void finalizaTudo(){
		DriverFactory.killDriver();
	}

}
