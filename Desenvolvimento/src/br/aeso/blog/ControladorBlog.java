package br.aeso.blog;

import java.sql.SQLException;
import java.util.ArrayList;

import br.aeso.usuario.Usuario;

public class ControladorBlog {
	
	private IRepositorioBlog repositorioBlog;
	
	public ControladorBlog() {
		try {
			repositorioBlog = new RepositorioBlogJDBC();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cadastrarBlog(Blog blog){
		repositorioBlog.cadastrar(blog);
	}
	
	public void atualizarBlog(Blog blog){
		repositorioBlog.atualizar(blog);
	}
	
	public boolean removerBlog(Integer id){
		return repositorioBlog.remover(id);
	}
	
	public Blog procurarBlog(Integer id){
		return repositorioBlog.procurar(id);
	}
	
	public ArrayList<Blog> listarBlog(){
		try {
			return repositorioBlog.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
