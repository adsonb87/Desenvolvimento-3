package br.aeso.fachada;

import java.sql.SQLException;

import br.aeso.blog.Blog;
import br.aeso.blog.ControladorBlog;
import br.aeso.blog.RepositorioBlogJDBC;
import br.aeso.jdbc.Conexao;
import br.aeso.usuario.Usuario;

public class Teste {

	public static void main(String[] args) throws SQLException {
			
		Usuario dono = new Usuario("nome", "email");
		dono.setId(1);
		
		ControladorBlog c = new ControladorBlog();
		
		System.out.println(c.listarBlog());
		
		
	}

}
