package br.pb.tauan.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.pb.tauan.utils.Constants;
import br.pb.tauan.utils.JSON;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CriarSimulacaoTest extends Constants {

	@Test
	public void test01CPFDuplicado() {
		String cpf = "66414919004";
		String json = new JSON().putKeys(NOME, cpf, EMAIL, VALOR, PARCELAS, SEGURO);
		createReq(json, 409)
			.body("mensagem", is("CPF já existente"))
		;
	}
	
	@Test
	public void test02CamposObrigatorios() {
		String nome = NOME + " Alterado";
		String cpf = randomInt11();
		String email = "alterado" + EMAIL ;
		Float valor = VALOR * 2;
		Integer parcelas = PARCELAS -2;
		Boolean seguro = !SEGURO;
		testSucess(nome, cpf, email, valor, parcelas, seguro);
	}

	@Test
	public void test03NomeVazio() {
		String cpf = randomInt11();
		String nome = null;
		testError(nome, cpf, EMAIL, VALOR, PARCELAS, SEGURO);
	}

	@Test
	public void test04CPFVazio() {
		String cpf = null;
		testError(NOME, cpf, EMAIL, VALOR, PARCELAS, SEGURO);
	}

	@Test
	public void test05EmailVazio() {
		String cpf = randomInt11();
		String email = null;
		testError(NOME, cpf, email, VALOR, PARCELAS, SEGURO);
	}

	@Test
	public void test06ValorVazio() {
		String cpf = randomInt11();
		Float valor = null;
		testError(NOME, cpf, EMAIL, valor, PARCELAS, SEGURO);
	}
	
	@Test
	public void test07ParcelasVazio() {
		String cpf = randomInt11();
		Integer parcelas = null;
		testError(NOME, cpf, EMAIL, VALOR, parcelas, SEGURO);
	}
	
	@Test
	public void test08SeguroVazio() {
		String cpf = randomInt11();
		Boolean seguro = null;
		testError(NOME, cpf, EMAIL, VALOR, PARCELAS, seguro);
	}
	
	@Test
	public void test09Nome() {
		String cpf = randomInt11();
		String nome = "Teste2";
		testSucess(nome, cpf, EMAIL, VALOR, PARCELAS, SEGURO);
	}
	
	@Test
	public void test10CPFLetras() {
		String cpf = randomString11() ;
		testError(NOME, cpf, EMAIL, VALOR, PARCELAS, SEGURO);
	}
	
	@Test
	public void test11CPF10() {
		String cpf = randomInt11().substring(1);
		testError(NOME, cpf, EMAIL, VALOR, PARCELAS, SEGURO);
	}
	
	@Test
	public void test12CPF12() {
		String cpf = randomInt11() + "1";
		testError(NOME, cpf, EMAIL, VALOR, PARCELAS, SEGURO);
	}
	
	@Test
	public void test13CPFInvalido() {
		String cpf = randomInt11();
		testError(NOME, cpf, EMAIL, VALOR, PARCELAS, SEGURO);
	}
	
	@Test
	public void test14CPFMascara() {
		String cpf = randomInt11Masked();
		testError(NOME, cpf, EMAIL, VALOR, PARCELAS, SEGURO);
	}
	
	@Test
	public void test15EmailInvalido1() {
		String cpf = randomInt11();
		String email = "teste@teste";
		testError(NOME, cpf, email, VALOR, PARCELAS, SEGURO);
	}
		
	@Test
	public void test16EmailInvalido2() {
		String cpf = randomInt11();
		String email = "teste.com";
		testError(NOME, cpf, email, VALOR, PARCELAS, SEGURO);
	}
	
	@Test
	public void test17ValorMenor1000() {
		String cpf = randomInt11();
		Float valor = 999.99F;
		testError(NOME, cpf, EMAIL, valor, PARCELAS, SEGURO);
	}
	
	@Test
	public void test18ValorIgual1000() {
		String cpf = randomInt11();
		Float valor = 1000.00F;
		testSucess(NOME, cpf, EMAIL, valor, PARCELAS, SEGURO);
	}
	
	@Test
	public void test19ValorMaior1000() {
		String cpf = randomInt11();
		Float valor = 1000.01F;
		testSucess(NOME, cpf, EMAIL, valor, PARCELAS, SEGURO);
	}
	
	@Test
	public void test20ValorMenor40000() {
		String cpf = randomInt11();
		Float valor = 39999.99F;
		testSucess(NOME, cpf, EMAIL, valor, PARCELAS, SEGURO);
	}
	
	@Test
	public void test21ValorIgual40000() {
		String cpf = randomInt11();
		Float valor = 40000.00F;
		testSucess(NOME, cpf, EMAIL, valor, PARCELAS, SEGURO);
	}
	
	@Test
	public void test22ValorMaior40000() {
		String cpf = randomInt11();
		Float valor = 40000.01F;
		testError(NOME, cpf, EMAIL, valor, PARCELAS, SEGURO);
	}
	
	@Test
	public void test23ValorNegativo() {
		String cpf = randomInt11();
		Float valor = -10000.00F;
		testError(NOME, cpf, EMAIL, valor, PARCELAS, SEGURO);
	}
	
	@Test
	public void test24ParcelasMenor2() {
		String cpf = randomInt11();
		Integer parcelas = 1;
		testError(NOME, cpf, EMAIL, VALOR, parcelas, SEGURO);
	}
	
	@Test
	public void test25ParcelasIgual2() {
		String cpf = randomInt11();
		Integer parcelas = 2;
		testSucess(NOME, cpf, EMAIL, VALOR, parcelas, SEGURO);
	}
	
	@Test
	public void test26ParcelasMaior2() {
		String cpf = randomInt11();
		Integer parcelas = 3;
		testSucess(NOME, cpf, EMAIL, VALOR, parcelas, SEGURO);
	}
	
	@Test
	public void test27ParcelasMenor48() {
		String cpf = randomInt11();
		Integer parcelas = 47;
		testSucess(NOME, cpf, EMAIL, VALOR, parcelas, SEGURO);
	}
	
	@Test
	public void test28ParcelasIgual48() {
		String cpf = randomInt11();
		Integer parcelas = 48;
		testSucess(NOME, cpf, EMAIL, VALOR, parcelas, SEGURO);
	}
	
	@Test
	public void test29ParcelasMaior48() {
		String cpf = randomInt11();
		Integer parcelas = 49;
		testError(NOME, cpf, EMAIL, VALOR, parcelas, SEGURO);
	}
	
	@Test
	public void test30ParcelasNegativo() {
		String cpf = randomInt11();
		Integer parcelas = -1;
		testError(NOME, cpf, EMAIL, VALOR, parcelas, SEGURO);
	}
	
	@Test
	public void test31CamposObrigatoriosVazios() {
		String nome = null;
		String cpf = null;
		String email = null;
		Float valor = null;
		Integer parcelas = null;
		Boolean seguro = null;
		testError(nome, cpf, email, valor, parcelas, seguro);
	}

	private ValidatableResponse testError(String nome, String cpf, String email, Float valor, Integer parcelas,
				Boolean seguro) {
		String json = new JSON().putKeys(nome, cpf, email, valor, parcelas, seguro);
		return createReq(json, 400)
			.body(containsString("erros"))
		;
	}

	private ValidatableResponse testSucess(String nome, String cpf, String email, Float valor, Integer parcelas,
				Boolean seguro) {
		String json = new JSON().putKeys(nome, cpf, email, valor, parcelas, seguro);
		return createReq(json, 200)
			.body("nome", is(nome))
			.body("cpf", is(cpf))
			.body("email", is(email))
			.body("valor", is(valor))
			.body("parcelas", is(parcelas))
			.body("seguro", is(seguro))
		;
	}
	
	private ValidatableResponse createReq(String json, int code) {
		return given()
					.contentType(ContentType.JSON)
					.body(json)
				.when()
					.post(SIMULACOES)
				.then()
					.log().all()
					.statusCode(code)
		;
	}
}
