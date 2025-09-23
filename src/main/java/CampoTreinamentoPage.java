import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {

    private DSL dsl;

    public CampoTreinamentoPage(WebDriver driver) {
        dsl = new DSL(driver);
    }

    public void setNome(String nome) {
        dsl.escrever("elementosForm:nome", nome);
    }

    public void setSobrenome(String sobrenome) {
        dsl.escrever("elementosForm:sobrenome", sobrenome);
    }

    public void setSexoMasculino() {
        dsl.clicarRadio("elementosForm:sexo:0");
    }

    public void setComida() {
        dsl.clicarRadio("elementosForm:comidaFavorita:0");
    }

    public void setEscolaridade(String valor) {
        dsl.escrever("elementosForm:escolaridade", valor);
    }

    public void setEsporte(String valor) {
        dsl.escrever("elementosForm:esporte", valor);
    }

    public void cadastrar() {
        dsl.clicarBotao("elementosForm:cadastrar");
    }

    public String obterResultadoCadastro() {
        return dsl.obterTexto(By.xpath("//*[@id='resultado']/span"));
    }

    public String obterNomeCadastro() {
        return dsl.obterTexto  (By.xpath("//*[@id='descNome']/span"));
    }

    public String obterSobrenomeCadastro() {
        return dsl.obterTexto  (By.xpath("//*[@id='descSobrenome']/span"));
    }

    public String obterSexoCadastro() {
        return dsl.obterTexto  (By.xpath("//*[@id='descSexo']/span"));
    }

    public String obterComidaCadastro() {
        return dsl.obterTexto  (By.xpath("//*[@id='descComida']/span"));
    }

    public String obterEscolaridadeCadastro() {
        return dsl.obterTexto  (By.xpath("//*[@id='descEscolaridade']/span"));
    }

    public  String obterEsporteCadastro() {
        return dsl.obterTexto  (By.xpath("//*[@id='descEsporte']/span"));

    }

    public void setEsporte(String... valores) {
        for(String valor: valores)
            dsl.selecionarCombo("elementosForm:esportes", valor);
    }

    public String obterEsportesCadastro(){
        return dsl.obterTexto("descEsportes");
    }


    public void setSexoFeminio() {
        dsl.clicarRadio("elementosForm:sexo:1");
    }

    public void setComidaCarne() {
        dsl.clicarRadio("elementosForm:comidaFavorita:0");
    }


    public void setComidaPizza() {
        dsl.clicarRadio("elementosForm:comidaPizza:1");
    }

    public void setComidaVegetariana() {
        dsl.clicarRadio("elementosForm:comidaFavorita:3");

    }
}









