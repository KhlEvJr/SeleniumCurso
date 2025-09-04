import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;


public class TesteAlert {

    @Test
    public void deveInteragirComAlertSimples() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        webDriver.manage().window().setSize(new Dimension(1920, 1080));

        webDriver.findElement(By.id("alert")).click();
        Alert alert = webDriver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Alert Simples", texto);
        alert.accept();

        webDriver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
    }

    @Test
    public void deveInteragirComAlerts() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        webDriver.manage().window().setSize(new Dimension(1024, 768));


        webDriver.findElement(By.id("confirm")).click();
        Alert alerta = webDriver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alerta.getText());
        alerta.accept();

        webDriver.findElement(By.id("confirm")).click();
        alerta = webDriver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alerta.getText());
        alerta.accept();
        Assert.assertFalse("Negado",alerta.getText().isEmpty());
        alerta.dismiss();



    }

    @Test
    public void deveInteragirComPrompt() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        webDriver.manage().window().setSize(new Dimension(1024, 768));

        webDriver.findElement(By.id("prompt")).click();
        Alert alerta =  webDriver.switchTo().alert();
        Assert.assertEquals("Digite um numero", alerta.getText());
        alerta.sendKeys("12");
        alerta.accept();
        Assert.assertEquals("Era 12?", alerta.getText());
        alerta.accept();
        Assert.assertFalse(":D",alerta.getText().isEmpty());
        alerta.dismiss();


    }


    }

