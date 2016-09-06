package br.aeso.conteudo;

import br.aeso.blog.Blog;
import br.aeso.usuario.Usuario;

public class Comentario extends Conteudo{
	
	private Nota nota;
	
	public Comentario(String data, String texto, Usuario autor, Nota nota, Blog blog) {
		super(data, texto, autor, TipoConteudo.Comentario, blog);
		this.nota = nota;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Comentario [nota=" + nota + "]";
	}
	
	
	
}
