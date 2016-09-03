package br.aeso.fachada;

import br.aeso.blog.ControladorBlog;
import br.aeso.conteudo.ControladorConteudo;
import br.aeso.usuario.ControladorUsuario;

public class Fachada {
	
	private ControladorBlog controladorBlog;
	private ControladorConteudo controladorConteudo;
	private ControladorUsuario controladorUsuario;
	
	private static Fachada fachada;
	
	public Fachada() {
		controladorBlog = new ControladorBlog();
		controladorConteudo = new ControladorConteudo();
		controladorUsuario = new ControladorUsuario();
	}
	
	public static Fachada getInstance(){
		if(fachada == null){
			fachada = new Fachada();
		}
		return fachada;
	}
	
	
	
	
	
	
}
