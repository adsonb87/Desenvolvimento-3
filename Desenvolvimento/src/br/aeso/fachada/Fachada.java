package br.aeso.fachada;

import java.sql.SQLException;
import java.util.ArrayList;

import br.aeso.blog.Blog;
import br.aeso.blog.ControladorBlog;
import br.aeso.conteudo.ControladorConteudo;
import br.aeso.usuario.ControladorUsuario;

public class Fachada {
	
	private ControladorBlog controladorBlog;
	private ControladorConteudo controladorConteudo;
	private ControladorUsuario controladorUsuario;
	
	private static Fachada fachada;

	public static Fachada getInstance(){
		if(fachada == null){
			fachada = new Fachada();
		}
		return fachada;
	}
	
	private Fachada() {
		controladorBlog = new ControladorBlog();
		controladorConteudo = new ControladorConteudo();
		controladorUsuario = new ControladorUsuario();
	}
	
	
	public void cadastrarBlog(Blog blog){
		controladorBlog.cadastrarBlog(blog);
	}
	
	public void atualizarBlog(Blog blog){
		controladorBlog.atualizarBlog(blog);
	}
	
	public boolean removerBlog(Integer id){
		return controladorBlog.removerBlog(id);
	}
	
	public Blog procurarBlog(Integer id){
		return controladorBlog.procurarBlog(id);
	}
	
	public ArrayList<Blog> listarBlog(){
		return controladorBlog.listarBlog();
	}
	
	
	
	
	
	
}
