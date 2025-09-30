import SeleniumCursoCORE.DSL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestesFramesComJanelas {

    private WebDriver driver;
    private DSL dsl;


    @Before
    public void inicializa(){
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.manage().window().setSize(new Dimension(1920, 1080));

    }

    @After
    public void finaliza(){
        driver.quit();
    }

    @Test
    public void deveInteragirComFrames(){
        dsl.entrarFrame("frame1");
        dsl.clicarBotao("frameButton");
        String msg = dsl.alertaObterTextoEAceita();
        Assert.assertEquals("Frame OK!", msg);

        dsl.sairframe();
        dsl.escrever("elementosForm:nome", msg);
    }


    @Test
    public void deveInteragirComFrameEscondido(){
        WebElement frame = driver.findElement(By.id("frame2"));
        dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
        dsl.entrarFrame("frame2");
        dsl.clicarBotao("frameButton");
        String msg = dsl.alertaObterTextoEAceita();
        Assert.assertEquals("Frame OK!", msg);
    }


    @Test
    public void deveInteragirComJanelas(){
        dsl.clicarBotao("buttonPopUpEasy");
        dsl.trocarDeJanela("Popup");
        //dsl.escreve(By.tagName("textarea"), "Deu certo?");
        driver.close();
        dsl.trocarDeJanela("");
        //dsl.escreve(By.tagName("textarea"), "e agora?");
    }

    @Test
    public void deveInteragirComJanelasSemTitulo(){
        dsl.clicarBotao("buttonPopUpHard");
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());
        dsl.trocarDeJanela((String) driver.getWindowHandles().toArray()[1]);
        //dsl.escreve(By.tagName("textarea"), "Deu certo?");
        dsl.trocarDeJanela((String) driver.getWindowHandles().toArray()[0]);
        //dsl.escreve(By.tagName("textarea"), "e agora?");
    }
}