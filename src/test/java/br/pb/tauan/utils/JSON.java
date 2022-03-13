package br.pb.tauan.utils;

import org.json.simple.JSONObject;

public class JSON {

	@SuppressWarnings("unchecked")
	public String putKeys(String nome, String cpf, String email, Float valor, Integer parcelas, Boolean seguro) {
		JSONObject jsonObj = createJSON();
		jsonObj.put("nome", nome);
		jsonObj.put("cpf", cpf);
		jsonObj.put("email", email);
		jsonObj.put("valor", valor);
		jsonObj.put("parcelas", parcelas);
		jsonObj.put("seguro", seguro);
		return jsonObj.toJSONString();
	}

	private JSONObject createJSON() {
		JSONObject jsonObj = new JSONObject();
		return jsonObj;
	}
}
