
import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class TesteCadastro {
    @Test
    public void deveinteragirComAlertPrompt() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
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

    @Test
    public void deveValidarNomeObrigatorio() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Nome eh obrigatorio", alerta.getText());


    }

    @Test
    public void deveValidarSobrenomeObrigatorio() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Sobrenome eh obrigato", alerta.getText());
    }

    @Test
    public void deveValidarSexoObrigatorio() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome qualquer");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Sexo eh obrigatorio", alerta.getText());

    }

    @Test
    public void deveValidarComidaVegetariana() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome qualquer");
        driver.findElement(By.id("elementosForm:sexo:1")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Tem certeza que voce eh vegetariano?", alerta.getText());
    }

    @Test
    public void deveValidarEsportistaIndeciso() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome qualquer");
        driver.findElement(By.id("elementosForm:sexo:1")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
        combo.selectByVisibleText("Karate");
        combo.selectByVisibleText("O que eh esporte?");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Voce faz esporte ou nao?", alerta.getText());
    }
}
