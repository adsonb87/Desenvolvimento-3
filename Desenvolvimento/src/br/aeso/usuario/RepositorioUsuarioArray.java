package br.aeso.usuario;

import java.util.ArrayList;

public class RepositorioUsuarioArray implements IRepositorioUsuario{
	
	private ArrayList<Usuario> listaUsuario;
	
	public RepositorioUsuarioArray() {
		listaUsuario = new ArrayList<>();
	}
	
	@Override
	public void cadastrar(Usuario usuario) {
		if(!existe(usuario.getId())){
			listaUsuario.add(usuario);
		}
		
	}

	@Override
	public void atualizar(Usuario usuario) {
		if(existe(usuario.getId())){
			for(int i=0; i<listaUsuario.size();i++){
				if(listaUsuario.get(i).equals(usuario)){
					listaUsuario.set(i, usuario);
				}
			}
		}
		
	}

	@Override
	public boolean remover(Integer id) {
		if(existe(id)){
			listaUsuario.remove(id);
			return true;
		}
		return false;
	}

	@Override
	public Usuario procurar(Integer id) {
		if(existe(id)){
			for(int i=0; i<listaUsuario.size();i++){
				if(listaUsuario.get(i).getId().equals(id)){
					return listaUsuario.get(i);
				}
			}
		}
		return null;
	}

	@Override
	public boolean existe(Integer id) {
		if(id != null){
			for(int i=0; i<listaUsuario.size();i++){
				if(listaUsuario.get(i).getId().equals(id)){
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
