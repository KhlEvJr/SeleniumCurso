package Teste;

import SeleniumCursoCORE.DSL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TesteAjax {

    private WebDriver driver;
    private DSL dsl;

    @Before
    public void inicializa(){
        driver = new ChromeDriver();
       driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
        dsl = new DSL();
    }

    @After
    public void finaliza(){
        driver.quit();
    }

    @Test
    public void testaAjax(){
        dsl.escrever("j_idt85:name", "Teste");
        dsl.clicarBotao("j_idt85:j_idt88");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds (30));
        wait.until(ExpectedConditions.textToBe(By.id("j_idt85:display"), "Teste"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt98")));
        Assert.assertEquals("Teste", dsl.obterTexto("j_idt85:display"));

    }
}
