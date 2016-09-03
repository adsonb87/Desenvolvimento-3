package br.aeso.usuario;

import java.util.ArrayList;

public class ControladorUsuario {
	
	private IRepositorioUsuario repositorioUsuario;
	
	public ControladorUsuario() {
		repositorioUsuario = new RepositorioUsuarioArray();
	}
	
	public void cadastrarUsuario(Usuario usuario){
		repositorioUsuario.cadastrar(usuario);
	}
	
	public void atualizarUsuario(Usuario usuario){
		repositorioUsuario.atualizar(usuario);
	}
	
	public boolean removerUsuario(Usuario usuario){
		if(usuario.getNome()!=null){
			repositorioUsuario.remover(usuario);
			return true;
		}
		return false;
	}
	
	public Usuario procurarUsuario(String nome){
		return repositorioUsuario.procurar(nome);
	}
	
	public ArrayList<Usuario> listarUsuario(){
		return repositorioUsuario.listar();
	}
	
}
