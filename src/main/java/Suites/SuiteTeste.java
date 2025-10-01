package Suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.java.TesteCadastro;
import test.java.TesteRegrasCadastro;
import test.java.TesteRegrasCadastroastro;
import test.java.TesteCampoTreinamento;

@RunWith(Suite.class)
@SuiteClasses({
        TesteCadastro.class,
        TesteRegrasCadastro.class,
        TesteRegrasCadastroastro.class,
        TesteCampoTreinamento.class
})
public class SuiteTeste {
}
