package br.aeso.fachada;

import java.sql.SQLException;

import br.aeso.blog.Blog;
import br.aeso.blog.IRepositorioBlog;
import br.aeso.blog.RepositorioBlogJDBC;
import br.aeso.conteudo.Conteudo;
import br.aeso.conteudo.Nota;
import br.aeso.conteudo.RepositorioNotaJDBC;
import br.aeso.conteudo.TipoConteudo;
import br.aeso.usuario.IRepositorioUsuario;
import br.aeso.usuario.RepositorioUsuarioJDBC;
import br.aeso.usuario.Usuario;

public class Teste {

	public static void main(String[] args){
			
		try {
			Nota c = new Nota("14/10/1987", "oi", new RepositorioUsuarioJDBC().procurar(1), new RepositorioBlogJDBC().procurar(5));
			
			RepositorioNotaJDBC r = new RepositorioNotaJDBC();
			
			r.cadastrar(c);
			
			
			System.out.println(r.listar());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
