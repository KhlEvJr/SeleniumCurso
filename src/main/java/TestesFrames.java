import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestesFrames {

    @Test
    public void deveInteragitComFrames(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024,768));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.switchTo().frame("frame1");
        driver.findElement(By.id("frameButton")).click();
        Alert alerta = driver.switchTo().alert();
        alerta.accept();

        driver.switchTo().defaultContent();
        driver.findElement(By.id("elementosForm:nome")).click();

    }

}
