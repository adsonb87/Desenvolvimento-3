package br.aeso.conteudo;

import java.util.ArrayList;

import br.aeso.blog.Blog;
import br.aeso.usuario.Usuario;

public class Nota extends Conteudo{
	
	private Blog blog;
	private ArrayList<Comentario> comentarios;
	
	public Nota(String data, String texto, Usuario autor, Blog blog) {
		super(data, texto, autor, TipoConteudo.Nota);
		comentarios = new ArrayList<>();
		this.blog = blog;
	}
	
		
	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
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
		return "Nota [blog=" + blog + ", comentarios=" + comentarios + "]";
	}

	
	
}
