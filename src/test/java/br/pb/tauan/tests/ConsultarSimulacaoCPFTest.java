package br.pb.tauan.tests;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import br.pb.tauan.utils.Constants;

public class ConsultarSimulacaoCPFTest extends Constants {

	@Test
	public void testConsultarSimulacaoCPF () {
		String cpf = "66414919004";
		when()
			.get(SIMULACOES + cpf)
		.then()
			.log().all()
			.statusCode(200)
			.body("$", hasKey("cpf"))
			.body("$", hasKey("nome"))
			.body("$", hasKey("email"))
			.body("$", hasKey("valor"))
			.body("$", hasKey("parcelas"))
			.body("$", hasKey("seguro"))
		;
	}
	
	@Test
	public void testConsultarSimulacaoCPFInexistente () {
		String cpf = "65432242079";
		when()
			.get(SIMULACOES + cpf)
		.then()
			.log().all()
			.statusCode(404)
			.body("mensagem", is("CPF " + cpf + " não encontrado"))
		;
	}
}
