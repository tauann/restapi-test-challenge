package br.pb.tauan.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.pb.tauan.tests.AlterarSimulacaoTest;
import br.pb.tauan.tests.ConsultarSimulacaoCPFTest;
import br.pb.tauan.tests.ConsultarSimulacoesTest;
import br.pb.tauan.tests.CriarSimulacaoTest;
import br.pb.tauan.tests.RemoverSimulacaoTest;
import br.pb.tauan.tests.RestricoesTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	RestricoesTest.class,
	ConsultarSimulacoesTest.class,
	CriarSimulacaoTest.class,
	AlterarSimulacaoTest.class,
	ConsultarSimulacaoCPFTest.class,
	RemoverSimulacaoTest.class	
})
public class TestSuite {

}
