package src.Suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


import src.main.test.TesteRegrasCadastro;
import src.main.test.java.TesteCadastro;


@RunWith(Suite.class)
@SuiteClasses({
        TesteCadastro.class,
        TesteRegrasCadastro.class,
        seleniumCurso.TesteCampoTreinamento.class
})
public class SuiteTeste {
}
