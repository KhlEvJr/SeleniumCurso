import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DSL {

    private WebDriver driver;


    public DSL(WebDriver driver) {
        this.driver = driver;
    }


    public void escrever(String id_campo, String texto) {
        escrever(By.id(id_campo), texto);
    }

    public String obterValorCampo(String id_campo) {
        return driver.findElement(By.id(id_campo)).getAttribute("value");
    }


    public void clicarRadio(String id) {
        driver.findElement(By.id(id)).click();
    }

    public boolean isRadioMarcado(String id) {
        return driver.findElement(By.id("id")).isSelected();


    }

    public void clicarCheck(String id) {
        driver.findElement(By.id(id)).click();
    }

    public boolean isCheckMarcado(String id) {
        return driver.findElement(By.id("id")).isSelected();
    }

    public void selecionarCombo(String id, String valor) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);

    }

    public String obterValorCombo(String id) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public void deselecionarCombo(String id) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        combo.deselectByVisibleText(combo.getFirstSelectedOption().getText());
    }

    public String obterValorCombo(String id, String valor) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public List<String> ObterValoresCombo(String id) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> AllSelected = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<>();
        for (WebElement el : AllSelected) {
            valores.add(el.getText());
        }
        return valores;

    }

    public int ObterQuantidadeOpcoesCombo(String id) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        return options.size();
    }

    public boolean verificarOpcaoCombo(String id, String opcao) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(opcao)) {
                return true;
            }
        }

        return false;
    }

    public void clicarBotao(String id) {
        driver.findElement(By.id("id")).click();
    }

    public String obterValueElemento(String id) {

        return driver.findElement(By.id(id)).getAttribute("value");
    }

    public void clicarLink(String link) {
        driver.findElement(By.linkText(link)).click();
    }

    public String obterTexto(By by) {
        return driver.findElement(by).getText();
    }

    public String obterTexto(String id) {
        return obterTexto(By.id(id));
    }

    public String alertaObterTexto() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public String alertaObterTextoEAceita() {
        Alert alert = driver.switchTo().alert();
        String valor = alert.getText();
        alert.accept();
        return valor;

    }

    public String alertaObterTextoENega() {
        Alert alert = driver.switchTo().alert();
        String valor = alert.getText();
        alert.dismiss();
        return valor;

    }

    public void alertaEscrever(String valor) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(valor);
        alert.accept();
    }

    //*********** Frames e Janelas ************//

    public void entrarFrame(String id){
        driver.switchTo().frame(id);
    }

    public void sairframe() {
        driver.switchTo().defaultContent();
    }

    public void trocarDeJanela(String id){
        driver.switchTo().window(id);
    }

    // ************* JS ******************//

    public Objects executarJS(String cmd,Objects...param){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(cmd, param);
    }

    //*********** Tabela ************ //

    public void CLicarBotãoTabela(String colunaBuscas, String valor, String colunaBotao, String idTabela){

        //Procurar coluna do registro
        WebElement tabela = driver.findElement(By.xpath("//*[@id='elementosForm:tableUsuario']"));
       int idColuna = obterIndiceColuna(colunaBuscas, tabela);

       // encontrar a linha do registro

        int idLinha = obterIndiceLinha(valor, tabela, idColuna);

        //procurar coluina do botão
        int idCOlunaBotao = obterIndiceColuna(colunaBotao,tabela);

        // clicar no botão da celula encontrada
        WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColuna+"]"));
        celula.findElement(By.xpath(".//input")).click();

    }



}