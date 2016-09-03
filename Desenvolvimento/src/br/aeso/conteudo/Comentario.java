package br.aeso.conteudo;

import br.aeso.usuario.Usuario;

public class Comentario extends Conteudo{
	
	private Nota nota;
	
	public Comentario(String data, String texto, Usuario autor, Nota nota) {
		super(data, texto, autor, TipoConteudo.Comentario);
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
