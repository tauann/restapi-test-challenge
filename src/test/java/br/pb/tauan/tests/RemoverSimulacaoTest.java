package br.pb.tauan.tests;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import br.pb.tauan.utils.Constants;

public class RemoverSimulacaoTest extends Constants {
	
	@Test
	public void testRemoverSimulacaoExistente() {
		int id = 12;
		
		when()
			.delete(SIMULACOES + id)
		.then()
			.log().all()
			.statusCode(204)
			.body(is("OK"))
		;
	}
	
	@Test
	public void testRemoverSimulacaoInexistente() {
		int id = 800;

		when()
			.delete(SIMULACOES + id)
		.then()
			.log().all()
			.statusCode(404)
			.body("mensagem", is("Simulação não encontrada"))
		;
	}
}
