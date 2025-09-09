import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestesFramesComJanelas {

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

    @Test
    public void deveInteragitComJanelas(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024,768));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("buttonPopUpEasy")).click();
        driver.switchTo().window("Popup");
        driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
        driver.close();
        driver.switchTo().window("");
        driver.findElement(By.tagName("textarea")).sendKeys("e agora??");

    }

    @Test
    public void deveInteragitComJanelasSemTitulo(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024,768));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("buttonPopUpHard")).click();
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
        driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
        driver.findElement(By.tagName("textarea")).sendKeys("e agora?");

    }
}
