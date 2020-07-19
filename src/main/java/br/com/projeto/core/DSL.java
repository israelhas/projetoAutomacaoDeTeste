package br.com.projeto.core;

import static br.com.projeto.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//---------------------------------------------------------------------------------------------------------------------------------------
/*
 * ----------------- Debug ---------------------- 
 * F5 - Entra no método; 
 * F6 - excutado o método todo; 
 * F7 - vai para o último método a ser excutado; 
 * F7 - vai para o último método a ser excutado.
 */
//---------------------------------------------------------------------------------------------------------------------------------------
/*
 * ----------------- Atalhos ----------------------
 * CTRL + SHIFT + C é para comentar e descomentar
 * CTRL + SHIFT + F identar o código
 * ALT + SHIFT + R é para renomear a class ou qq membro da classe
 * ALT + UP ou ALT + DOWN para levar uma linha para baixo e pra cima
*/
//---------------------------------------------------------------------------------------------------------------------------------------
/* 
 * ---- Xpath (utilizando quando não conseguimos buscar o elemento usando os recursos do seleniun) ----------------------
 *  // procura em toda página HTML. Ex.: //div, acha todas as divs da página 
 *  [] é passado o parâmetro para o elemento. Ex.: //div[@id="moredate"], busca a div  que possui o id iqual a moredate, @ é o atributo do elemento
 *  * Elemento coringa. EX.: //*[@id="moredate"], encontra qualquer elemento que possua o id moredate
 *  // // Consulta com subconsulta. Ex.: //div[@id="moredate"]//button[@data-target="addmoredata"], procura o id da div e dentro disso procura o botão   
*/
//---------------------------------------------------------------------------------------------------------------------------------------

// O DSL equivale a helper do sicoob, onde fica as funções

/* 
 * Outra forma de verificar se o elemento é único na página
 * 
 * inspect > console > document.querySelectorAll('.modal-trigger'), informar o valor da class no parenteses, se iniciar com "." é classe 
 * se iniciar com "#" é ID 
 * 
 */

public class DSL {

	/********* Temporizador ************/

	public void aguardarCarregamentoElemento(int tempoEmSegundos) {

		getDriver().manage().timeouts().implicitlyWait(tempoEmSegundos, TimeUnit.SECONDS);

	}

	/********* TextField , TextArea e Text ************/
	
	private void escrever(By by, String texto) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}

	//  Polimorfismo Sobrecarga 
	//  Polimorfismo Sobrecarga - Método com o mesmo nome porém com assinatura diferente
	public void escrever(String id_campo, String texto) {
		
		
		escrever(By.id(id_campo), texto);
	}
	
	// Israel - funcionando
	//  Polimorfismo Sobrecarga - Método com o mesmo nome porém com assinatura diferente
	private void escrever(By by,String id_div, String name, String texto) {
		
	   getDriver().findElement(by).clear();
		
		// A variável formularioCriarLogin está recebendo o id do formulário (ID da tag DIV)
		WebElement formularioCriarLogin = getDriver().findElement(By.id(id_div));
		// formularioCriarLogin possui os elementos do formulário e está fazendo uma
		// pesquisa por nome da tag dentro dele e escreve o texto recebido
		formularioCriarLogin.findElement(By.name(name)).sendKeys(texto);
		
	}
	
	//  Polimorfismo Sobrecarga 
	public void escrever(String id, String name, String texto) {
	
		 	
		
		escrever(By.name(name), id, name, texto);
		
				
	}

	// Israel - escreverNoForm
	public void escreverNoForm(By by, String texto ) {
		
			
		//WebElement formularioCriarLogin = getDriver().findElement(By.id(id));
		getDriver().findElement(by).sendKeys(texto);
	}
	
	//Polimorfismo Sobrecarga 
	//public void escrever(String id, String name, String texto) {
	
		//escreverNoForm(id, name, texto);
		
	//}


	public String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}

	/********* Radio e Check ************/

	public void clicarRadio(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarRadio(String id) {
		clicarRadio(By.id(id));
	}

	public boolean isRadioMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}

	public void clicarCheck(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public boolean isCheckMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}

	/********* Combo ************/

	public void selecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	// Israel - Funcionando
	public void selecionarComboPorXpath(String xpath, String nomeVisivel) {
		WebElement element = getDriver().findElement(By.xpath(xpath));
		Select combo = new Select(element);
		combo.selectByVisibleText(nomeVisivel);
	}

	public void deselecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}

	public String obterValorCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}

	public List<String> obterValoresCombo(String id) {
		WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for (WebElement opcao : allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}

	public int obterQuantidadeOpcoesCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}

	public boolean verificarOpcaoCombo(String id, String opcao) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for (WebElement option : options) {
			if (option.getText().equals(opcao)) {
				return true;
			}
		}
		return false;
	}

	public void selecionarComboPrime(String radical, String valor) {
		clicarRadio(By.xpath("//*[@id='" + radical + "_input']/../..//span"));
		clicarRadio(By.xpath("//*[@id='" + radical + "_items']//li[.='" + valor + "']"));
	}

	/********* Botao ************/
	
	// Procura o botão conforme o seu ID
	public void clicarBotaoPorID(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public String obterValueElemento(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}

	public void clicarBotaoPorClassName(String nomeClasse) {
		getDriver().findElement(By.className(nomeClasse)).click();
	}
	
	// Israel - Funcionando
	public void clicarBotaoXpath(String xpath) {

		getDriver().findElement(By.xpath(xpath)).click();

	}

	/********* Link ************/

	// LinkText busca o texto da forma que ele é apresentada na tela, é case
	// sensitive

	public void clicarLink(String link) {
		// Clica no link conforme o nome do texto visivel
		getDriver().findElement(By.linkText(link)).click();
	}

	// Israel - funcionando
	public void clicarBotaoPorTextVisible(String TextVisible) {
		getDriver().findElement(By.linkText(TextVisible)).click();
	}

	// Israel - funcionando
	public void clicarBotaoPorIDeTextVisible(String id, String TextVisible) {
		// A variável formularioCriarLogin está recebendo o id do formulário (ID da tag
		// DIV)
		WebElement formularioCriarLogin = getDriver().findElement(By.id(id));
		// formularioCriarLogin possui os elementos do formulário e está fazendo uma
		// pesquisa por nome da tag dentro dele e escreve o texto recebido
		formularioCriarLogin.findElement(By.linkText(TextVisible)).click();
	}

	/********* Textos / mensagens ************/

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}

	public String obterTextoToast(String id) {

		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement mensagemPop = getDriver().findElement(By.id(id));
		String mensagem = mensagemPop.getText();

		// WebDriverWait aguardar = new WebDriverWait(getDriver(), 10);
		// aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));
		return mensagem;

	}

	/********* Alerts ************/

	public String alertaObterTexto() {
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}

	public String alertaObterTextoEAceita() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;

	}

	public String alertaObterTextoENega() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;

	}

	public void alertaEscrever(String valor) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}

	/********* Frames e Janelas ************/

	public void entrarFrame(String id) {
		getDriver().switchTo().frame(id);
	}

	public void sairFrame() {
		getDriver().switchTo().defaultContent();
	}

	public void trocarJanela(String id) {
		getDriver().switchTo().window(id);
	}

	/************** JS *********************/

	public Object executarJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(cmd, param);
	}

	/************** Tabela *********************/

	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		// procurar coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);

		// encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);

		// procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

		// clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[" + idColunaBotao + "]"));
		celula.findElement(By.xpath(".//input")).click();

	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" + idColuna + "]"));
		int idLinha = -1;
		for (int i = 0; i < linhas.size(); i++) {
			if (linhas.get(i).getText().equals(valor)) {
				idLinha = i + 1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for (int i = 0; i < colunas.size(); i++) {
			if (colunas.get(i).getText().equals(coluna)) {
				idColuna = i + 1;
				break;
			}
		}
		return idColuna;
	}
}
