package br.aeso.fachada;

import br.aeso.conteudo.Comentario;

public class Teste {

	public static void main(String[] args) {
		
		Comentario coment = new Comentario("data", "texto", null);
		
		System.out.println(coment.toString());
		
		
		
	}

}
