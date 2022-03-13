package br.pb.tauan.tests;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasKey;

import org.junit.Test;

import br.pb.tauan.utils.Constants;

public class ConsultarSimulacoesTest extends Constants {

	@Test
	public void testConsultarSimulacoes() {
		when()
			.get(SIMULACOES)
		.then()
			.log().all()
			.statusCode(200)
			.body("[0]", hasKey("cpf"))
			.body("[0]", hasKey("nome"))
			.body("[0]", hasKey("email"))
			.body("[0]", hasKey("valor"))
			.body("[0]", hasKey("parcelas"))
			.body("[0]", hasKey("seguro"))
		;
	}
	
	@Test
	public void testConsultarSimulacoesVazia() {
		when()
			.get(SIMULACOES)
		.then()
			.log().all()
			.statusCode(204)
		;
	}
}
