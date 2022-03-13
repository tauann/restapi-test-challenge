package br.pb.tauan.utils;

import java.util.Random;

import com.tngtech.java.junit.dataprovider.DataProvider;

public class Constants {
	private final static String BASEURL = "http://localhost:8080";
	protected final static String RESTRICOES = BASEURL + "/api/v1/restricoes/";
	protected final static String SIMULACOES = BASEURL + "/api/v1/simulacoes/";
	protected final static String CPF = "82298593027";
	protected final static String NOME = "Teste";
	protected final static String EMAIL = "teste@teste.com";
	protected final static Float VALOR = 2000.00F;
	protected final static Integer PARCELAS = 7;
	protected final static Boolean SEGURO = false;

	@DataProvider
	public static Object[][] cpfSemRestricao () {
		return new Object[][] {
			{"82298593027"},
			{"90144356066"},
			{"63160005020"},
			{"38850527098"},
			{"99972070093"},
			{"78545080034"},
			{"11130967050"},
			{"33336081033"},
			{"34511195013"},
			{"17070263007"}
		};
	}

	@DataProvider
	public static Object[][] cpfComRestricao () {
		return new Object[][] {
			{"97093236014"},
			{"60094146012"},
			{"84809766080"},
			{"62648716050"},
			{"26276298085"},
			{"01317496094"},
			{"55856777050"},
			{"19626829001"},
			{"24094592008"},
			{"58063164083"}
		};
	}
	
	public static String randomInt11() {
		return "4" + new Random().nextInt(99)
				+ new Random().nextInt(999)
				+ new Random().nextInt(999)
				+ new Random().nextInt(99);	
	}
	
	public static String randomInt11Masked() {
		return "4" + new Random().nextInt(99)
				+ "." + new Random().nextInt(999)
				+ "." + new Random().nextInt(999)
				+ "-" + new Random().nextInt(99);	
	}
	
	public static String randomString11() {
		return "ABCDEF" + new Random().nextInt(5); 
	}
}
