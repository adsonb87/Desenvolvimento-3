package br.aeso.fachada;

import java.sql.SQLException;

import br.aeso.blog.Blog;
import br.aeso.blog.IRepositorioBlog;
import br.aeso.blog.RepositorioBlogJDBC;
import br.aeso.usuario.IRepositorioUsuario;
import br.aeso.usuario.RepositorioUsuarioJDBC;
import br.aeso.usuario.Usuario;

public class Teste {

	public static void main(String[] args){
			
		Usuario user = new Usuario("Tarcisio", "hugotchotcha@gmail.com");
		user.setId(2);
		
		IRepositorioUsuario r = new RepositorioUsuarioJDBC();
		
//		System.out.println(r.remover(2));
		
//		System.out.println(r.procurar(2));
		
		System.out.println(r.listar());
		
		
		
		
	}

}
