package br.com.projeto.core;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	//System.setProperty("webdriver.chrome.driver", "/Users/israel.souza/eclipse-workspace/chromedriver.exe");

	private static WebDriver driver;
	
	private DriverFactory() {}
	
	public static WebDriver getDriver(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\projetoAutomacaoDeTeste/chromedriver.exe");
		if(driver == null) {
			// switch criada para instanciar o navegador escolhido de acordo com a parâmetro informado
			switch (Propriedades.browser) {
				case FIREFOX: driver = new FirefoxDriver(); break;
				case CHROME: driver = new ChromeDriver(); break;
			}
			driver.manage().window().maximize();	
			
		}
		return driver;
	}

	public static void killDriver(){
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
