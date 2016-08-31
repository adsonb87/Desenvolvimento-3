package br.aeso.conteudo;

import java.util.ArrayList;

import br.aeso.usuario.Usuario;

public class Nota extends Conteudo{

	private ArrayList<Comentario> comentarios;
	
	public Nota(String data, String texto, Usuario autor) {
		super(data, texto, autor, TipoConteudo.Nota);
		comentarios = new ArrayList<>();
	}
	
	
	private void inserirComentario(Comentario comentario){
		this.comentarios.add(comentario);
	}
	
	private void removerComentario(Comentario comentario){
		this.comentarios.remove(comentario);
	}
	
	private ArrayList<Comentario> listarComentarios(){
		return comentarios;
	}

	
}
