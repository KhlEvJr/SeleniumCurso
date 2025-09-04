
import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class TesteCadastro {
    @Test
    public void deveinteragirComAlertPrompt() {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Wagner");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Costas");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
        new Select(driver.findElement(By.id("elementosForm:escolaridade")))
                .selectByVisibleText("Mestrado");
        new Select(driver.findElement(By.id("elementosForm:esportes")))
                .selectByVisibleText("Natação");
        driver.findElement(By.id("elementosForm:cadastrar")).click();

        Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Castrado!"));
        Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Wagner!"));
        Assert.assertEquals("Sobrenome: Costa", driver.findElement(By.id("descSobrenome")).getText().equals("Costas"));
        Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText().equals("Masculino"));
        Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText().equals("Pizza"));
        Assert.assertEquals("Escolaridade: Mestrado", driver.findElement(By.id("descEscolaridade")).getText().equals("Mestrado"));
        Assert.assertEquals("Esportes: Natacao", driver.findElement(By.id("descEsportes")).getText().equals("Natacao"));
    }


}

