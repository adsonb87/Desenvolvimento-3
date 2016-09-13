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
		try {
			repositorioBlog.cadastrar(blog);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void atualizarBlog(Blog blog){
		try {
			repositorioBlog.atualizar(blog);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean removerBlog(Integer id){
		try {
			return repositorioBlog.remover(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Blog procurarBlog(Integer id){
		try {
			return repositorioBlog.procurar(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
