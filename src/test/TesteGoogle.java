import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteGoogle {

    @Test
    public void deveInteragirGoogle(){
        WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "D:\\DATA\\geckodriver.exe");
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals("Google",driver.getTitle());
        driver.quit();
    }

}
