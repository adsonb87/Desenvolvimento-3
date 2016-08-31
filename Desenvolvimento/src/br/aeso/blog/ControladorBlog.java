package br.aeso.blog;

public class ControladorBlog {
	
	private IRepositorioBlog repositorioBlog;
	
	public ControladorBlog() {
		repositorioBlog = new RepositorioBlogArray();
	}
	
	
}
