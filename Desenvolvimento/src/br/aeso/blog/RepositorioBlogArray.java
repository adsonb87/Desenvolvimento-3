package br.aeso.blog;

import java.util.ArrayList;

import br.aeso.conteudo.Conteudo;
import br.aeso.usuario.Usuario;

public class RepositorioBlogArray {
	
	private ArrayList<Blog> listaBlog;
	
	public RepositorioBlogArray() {
		listaBlog = new ArrayList<>();
	}
	
	
	public void cadastrar(Blog blog) {
		if(!existe(blog.getIdBlog())){
			listaBlog.add(blog);
		}
		
	}

	
	public void atualizar(Blog blog) {
		if(existe(blog.getIdBlog())){
			for(int i=0; i<listaBlog.size();i++){
				if(listaBlog.get(i).equals(blog)){
					listaBlog.set(i, blog);
				}
			}
		}
		
	}

	
	public boolean remover(Blog blog) {
		if(existe(blog.getIdBlog())){
			listaBlog.remove(blog);
			return true;
		}
		return false;
	}

	
	public Blog procurar(Integer id) {
		if(existe(id)){
			for(int i=0; i<listaBlog.size();i++){
				if(listaBlog.get(i).getIdBlog().equals(id)){
					return listaBlog.get(i);
				}
			}
		}
		return null;
	}

	
	public boolean existe(Integer id) {
		if(id!=null){
			for(int i=0; i<listaBlog.size();i++){
				if(listaBlog.get(i).getIdBlog().equals(id)){
					return true;
				}
			}
		}
		return false;
	}

	
	public ArrayList<Blog> listar() {
		return listaBlog;
	}
	
	

}
