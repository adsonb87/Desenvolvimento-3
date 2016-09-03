package br.aeso.usuario;

import java.util.ArrayList;

public class RepositorioUsuarioArray implements IRepositorioUsuario{
	
	private ArrayList<Usuario> listaUsuario;
	
	public RepositorioUsuarioArray() {
		listaUsuario = new ArrayList<>();
	}
	
	@Override
	public void cadastrar(Usuario usuario) {
		if(!existe(usuario.getNome())){
			listaUsuario.add(usuario);
		}
		
	}

	@Override
	public void atualizar(Usuario usuario) {
		if(existe(usuario.getNome())){
			for(int i=0; i<listaUsuario.size();i++){
				if(listaUsuario.get(i).equals(usuario)){
					listaUsuario.set(i, usuario);
				}
			}
		}
		
	}

	@Override
	public boolean remover(Usuario usuario) {
		if(existe(usuario.getNome())){
			listaUsuario.remove(usuario);
			return true;
		}
		return false;
	}

	@Override
	public Usuario procurar(String nome) {
		if(existe(nome)){
			for(int i=0; i<listaUsuario.size();i++){
				if(listaUsuario.get(i).getNome().equals(nome)){
					return listaUsuario.get(i);
				}
			}
		}
		return null;
	}

	@Override
	public boolean existe(String nome) {
		if(nome != null){
			for(int i=0; i<listaUsuario.size();i++){
				if(listaUsuario.get(i).getNome().equals(nome)){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public ArrayList<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
