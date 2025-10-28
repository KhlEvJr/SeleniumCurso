
package seleniumCurso.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import Teste.TesteCadastro;
import Teste.TesteRegrasCadastro;
import Teste.TesteCampoTreinamento;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TesteCadastro.class,
        TesteRegrasCadastro.class,
        TesteCampoTreinamento.class
})
public class SuiteTeste { }
