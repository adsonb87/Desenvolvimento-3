package br.aeso.blog;

import java.util.ArrayList;

import br.aeso.usuario.Usuario;

public class ControladorBlog {
	
	private IRepositorioBlog repositorioBlog;
	
	public ControladorBlog() {
		repositorioBlog = new RepositorioBlogArray();
	}
	
	public void cadastrarBlog(Blog blog){
		repositorioBlog.cadastrar(blog);
	}
	
	public void atualizarBlog(Blog blog){
		repositorioBlog.atualizar(blog);
	}
	
	public boolean removerBlog(Blog blog){
		return repositorioBlog.remover(blog);
	}
	
	public Blog procurarBlog(Usuario user){
		return repositorioBlog.procurar(user);
	}
	
	public ArrayList<Blog> listarBlog(){
		return repositorioBlog.listar();
	}
	
}
