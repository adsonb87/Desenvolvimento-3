package br.aeso.conteudo;

import br.aeso.usuario.Usuario;

public class Comentario extends Conteudo{

	public Comentario(String data, String texto, Usuario autor) {
		super(data, texto, autor, TipoConteudo.Comentario);
	}
	
}
