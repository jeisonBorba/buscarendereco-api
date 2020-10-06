package br.com.jborba.buscarendereco.api.util;

public class CepUtil {
	
	public static String substituirUltimoNumeroPorZero(String cep) {
		StringBuilder cepAlterado = new StringBuilder(cep);
		
		for (int i = cep.length() -1; i >= 0; i--) {
			if ('0' != cep.charAt(i)) {
				cepAlterado.setCharAt(i, '0');
				break;
			}
		}
		
		return cepAlterado.toString();
	}
	
	public static String sanearConteudo(String cep) {
		return cep.replaceAll("[^0-9]", "");
	}

}
