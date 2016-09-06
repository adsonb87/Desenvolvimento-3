package br.aeso.conteudo;

import java.util.ArrayList;

import br.aeso.blog.Blog;
import br.aeso.usuario.Usuario;

public class Nota extends Conteudo{
	
	private ArrayList<Comentario> comentarios;
	
	public Nota(String data, String texto, Usuario autor, Blog blog) {
		super(data, texto, autor, TipoConteudo.Nota, blog);
		comentarios = new ArrayList<>();
	}
	
		
	
	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}



	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
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



	@Override
	public String toString() {
		return "Nota [comentarios=" + comentarios + "]";
	}


	
}
