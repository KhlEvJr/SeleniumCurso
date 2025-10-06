package seleniumCurso;


import SeleniumCursoCORE.DSL;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Dimension;



import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TesteCampoTreinamento {

    private WebDriver driver;
    private DSL dsl;

    @Before
    public void inicializa() {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        dsl = new DSL(driver);
    }

    @After
    public void finaliza() {
      //  driver.quit();
    }

    @Test
    public void testeTextField() {

        dsl.escrever("elementosForm:norme", "Teste de escrita");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
        Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));


    }

    @Test
    public void deveIntegarirComTextArea() {
        dsl.escrever("elementosForm:sugestoes", "teste\n\naasldjdlks\nUltima linha");
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste\n\naasldjdlks\nUltima linha");
        Assert.assertEquals("teste\n\naasldjdlks\nUltima linha", dsl.obterValorCampo(("elementosForm:sugestoes")));


    }


    @Test
    public void deveIntegarirComRadioButton() {

        driver.findElement(By.id("elementosForm:sexo:0")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());


    }

    @Test
    public void deveIntegarirComCheckbox() {


        dsl.isRadioMarcado("elmentosForm:comidaFavorita:2");
        Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:2"));

    }

    @Test
    public void deveIntegarirComCombo() {

        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
//		combo.selectByIndex(2);
//		combo.selectByValue("superior");
        combo.selectByVisibleText("2o grau completo");
        dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
        Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());

    }

    @Test
    public void deveVerificarValoresCombo() {


        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        Assert.assertEquals(8, options.size());

        boolean encontrou = false;
        for (WebElement option : options) {
            if (option.getText().equals("Mestrado")) {
                encontrou = true;
                break;
            }
        }
        Assert.assertTrue(encontrou);
    }

    @Test
    public void deveVerificarValoresComboMultiplo() {

        dsl.selecionarCombo("elementosForm:esportes", "Natacao");
        dsl.selecionarCombo("elementosForm:esportes", "Corrida");
        dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");

        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);

       List<String> opcoesMarcas = Collections.singletonList(dsl.obterValorCampo("elementosForm:esportes"));
       Assert.assertEquals(3, opcoesMarcas.size());
       Assert.assertTrue(opcoesMarcas.containsAll(Arrays.asList("Natacao", "O que eh esporte?")));


    }

    @Test
    public void deveintragirComBotoes() {
        dsl.clicarBotao("buttonSimple");

        WebElement botao = driver.findElement(By.id("buttonSimple"));
        botao.click();

        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));

    }

    @Test
    @Ignore
    public void deveinteragirComLinks() {
        dsl.clicarLink("Voltar");

        Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
    }

    @Test
    public void deveBuscarTextoNaPagina() {


        //   Assert.assertTrue(driver.findElement(By.tagName("body"))
        //       .getText().contains("Campo de Treinamento"));
        Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));

        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));


    }

    @Test
    public void testJavascript(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("alert('Testando js via selenium')");
        js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
        js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");

        WebElement element = driver.findElement(By.id("elementosForm:nome"));
        js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
    }

}

