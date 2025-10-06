package src.main.test;

import Page.CampoTreinamentoPage;
import SeleniumCursoCORE.DSL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    public static class TesteCadastro {

        private WebDriver driver;
        private DSL dsl;
        private CampoTreinamentoPage page;

        @Before
        public void inicializa() {
            WebDriver driver = new ChromeDriver();
            driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
            driver.manage().window().setSize(new Dimension(1920, 1080));
            dsl = new DSL();
            page = new CampoTreinamentoPage();
        }

        @After
        public void finaliza() {
            driver.quit();
        }


        @Test
        public void deveRealizarCadastroComSucesso() {
            page.setNome("Jr");
            page.setSobrenome("Louzada");
            page.setSexoMasculino();
            page.setComida();
            page.setEscolaridade("Mestrado");
            page.setEsporte("Natacao");
            page.cadastrar();

            Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
            Assert.assertEquals("Jr", page.obterNomeCadastro());
            Assert.assertEquals("Sobrenome: Louzada", page.obterSobrenomeCadastro());
            Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
            Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
            Assert.assertEquals("Escolaridade: Mestrado", page.obterEscolaridadeCadastro());
            Assert.assertEquals("Esportes: Natacao", page.obterEsportesCadastro());

        }

        @Test
        public void deveValidarNomeObrigatorio() {
            page.cadastrar();
            Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());


        }

        @Test
        public void deveValidarSobrenomeObrigatorio() {
            page.setNome("Nome qualquer");
            page.cadastrar();
            Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
        }

        @Test
        public void deveValidarSexoObrigatorio() {
            page.setNome("Nome qualquer");
            page.setSobrenome("Sobrenome qualquer");
            page.cadastrar();
            Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
        }

        @Test
        public void deveValidarComidaVegetariana() {
          page.setNome("Nome qualquer");
          page.setSobrenome("Sobrenome qualquer");
          page.setSexoFeminio();
          page.setComidaCarne();
          page.setComidaVegetariana();
          page.cadastrar();
            Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
        }

        @Test
        public void deveValidarEsportistaIndeciso() {
            page.setNome("Nome qualquer");
            page.setSobrenome("Sobrenome qualquer");
            page.setSexoFeminio();
            page.setComidaCarne();
            page.setEsporte("Karate", "O que eh esporte?");
            page.cadastrar();
            Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
        }
    }
}
