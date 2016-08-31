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
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remover(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Blog procurar(Usuario user) {
		// TODO Auto-generated method stub
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
	public ArrayList<Conteudo> conteudos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
