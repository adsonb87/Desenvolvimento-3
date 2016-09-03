package br.aeso.blog;

import java.util.ArrayList;

import br.aeso.conteudo.Conteudo;
import br.aeso.usuario.Usuario;

public class RepositorioBlogArray implements IRepositorioBlog{
	
	private ArrayList<Blog> listaBlog;
	
	public RepositorioBlogArray() {
		listaBlog = new ArrayList<>();
	}
	
	@Override
	public void cadastrar(Blog blog) {
		if(!existe(blog.getDono())){
			listaBlog.add(blog);
		}
		
	}

	@Override
	public void atualizar(Blog blog) {
		if(existe(blog.getDono())){
			for(int i=0; i<listaBlog.size();i++){
				if(listaBlog.get(i).equals(blog)){
					listaBlog.set(i, blog);
				}
			}
		}
		
	}

	@Override
	public boolean remover(Blog blog) {
		if(existe(blog.getDono())){
			listaBlog.remove(blog);
			return true;
		}
		return false;
	}

	@Override
	public Blog procurar(Usuario user) {
		if(existe(user)){
			for(int i=0; i<listaBlog.size();i++){
				if(listaBlog.get(i).getDono().equals(user)){
					return listaBlog.get(i);
				}
			}
		}
		return null;
	}

	@Override
	public boolean existe(Usuario user) {
		if(!user.equals(null)){
			for(int i=0; i<listaBlog.size();i++){
				if(listaBlog.get(i).getDono().getNome().equals(user.getNome())){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public ArrayList<Blog> listar() {
		return listaBlog;
	}
	
	

}
