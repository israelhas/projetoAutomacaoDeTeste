package br.com.projeto.core;

import static br.com.projeto.core.DriverFactory.getDriver;
import static br.com.projeto.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
	
	//Regra do Junit que permite salvar o arquivo com o nome do método de teste executado
	@Rule
	public TestName testName = new TestName();

	@After
	public void finaliza() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		/*
		 * "target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg": onde o arquivo será salvo;
		 * Salva a imagem dentro da pasta target do projeto, File.separator: é equivalente a barra do sistema operacional
		 * getMethodName() renomeia o arquivo com o nome do metodo de teste
		*/
		FileUtils.copyFile(arquivo, new File(
				"target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg"));

		if (Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
		
	}

}
