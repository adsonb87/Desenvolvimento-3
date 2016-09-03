package br.aeso.conteudo;

import java.util.ArrayList;

import br.aeso.blog.Blog;
import br.aeso.usuario.Usuario;

public class RepositorioConteudoArray implements IRepositorioConteudo{
	
	private ArrayList<Conteudo> listaConteudo;
	
	public RepositorioConteudoArray() {
		listaConteudo = new ArrayList<>();
	}
	
	@Override
	public void cadastrar(Conteudo conteudo) {
		if(!existe(conteudo.getAutor())){
			listaConteudo.add(conteudo);
		}
		
	}

	@Override
	public void atualizar(Conteudo conteudo) {
		if(existe(conteudo.getAutor())){
			for(int i=0;i<listaConteudo.size();i++){
				listaConteudo.set(i, conteudo);
			}
		}
	}

	@Override
	public boolean remover(Conteudo conteudo) {
		if(existe(conteudo.getAutor())){
			listaConteudo.remove(conteudo);
			return true;
		}
		return false;
	}

	@Override
	public Conteudo procurar(Usuario user) {
		if(existe(user)){
			for(int i=0; i<listaConteudo.size();i++){
				if(listaConteudo.get(i).getAutor().equals(user)){
					return listaConteudo.get(i);
				}
			}
		}
		return null;
	}

	@Override
	public boolean existe(Usuario user) {
		if(!user.equals(null)){
			for(int i=0; i<listaConteudo.size();i++){
				if(listaConteudo.get(i).getAutor().equals(user)){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public ArrayList<Conteudo> listar() {
		return listaConteudo;
	}

}
