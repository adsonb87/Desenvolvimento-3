package br.aeso.fachada;

import br.aeso.conteudo.Comentario;
import br.aeso.conteudo.Conteudo;
import br.aeso.conteudo.Nota;
import br.aeso.conteudo.TipoConteudo;
import br.aeso.usuario.Usuario;

public class Teste {

	public static void main(String[] args) {
		
		Conteudo comentario = new Comentario("data", "texto", null);
		
		Conteudo nota = new Nota("data", "texto", null);
		
		System.out.println(comentario.getTipo());
		
		System.out.println(comentario.toString()+"\n"+nota.toString());
		
		
	}

}
