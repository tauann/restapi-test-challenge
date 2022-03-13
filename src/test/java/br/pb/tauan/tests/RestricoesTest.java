package br.pb.tauan.tests;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import br.pb.tauan.utils.Constants;

@RunWith(DataProviderRunner.class)
public class RestricoesTest extends Constants {

	@Test
	@UseDataProvider("cpfSemRestricao")
	public void testCPFSemRestricao(String cpfSemRestricao) {
		when()
			.get(RESTRICOES + cpfSemRestricao)
		.then()
			.log().all()
			.statusCode(204)
		;
	}

	@Test
	@UseDataProvider("cpfComRestricao")
	public void testCPFComRestricao(String cpfComRestricao) {
		when()
			.get(RESTRICOES + cpfComRestricao)
		.then()
			.log().all()
			.statusCode(200)
			.body("mensagem", is("O CPF " + cpfComRestricao + " possui restrição"))
		;
	}
}
