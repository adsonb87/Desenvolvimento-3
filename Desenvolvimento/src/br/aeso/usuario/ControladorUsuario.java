package br.aeso.usuario;

import java.util.ArrayList;

public class ControladorUsuario {
	
	private IRepositorioUsuario repositorioUsuario;
	
	public ControladorUsuario() {
		repositorioUsuario = new RepositorioUsuarioJDBC();
	}
	
	public void cadastrarUsuario(Usuario usuario){
		repositorioUsuario.cadastrar(usuario);
	}
	
	public void atualizarUsuario(Usuario usuario){
		repositorioUsuario.atualizar(usuario);
	}
	
	public boolean removerUsuario(Integer id){
		return repositorioUsuario.remover(id);
	}
	
	public Usuario procurarUsuario(Integer id){
		return repositorioUsuario.procurar(id);
	}
	
	public ArrayList<Usuario> listarUsuario(){
		return repositorioUsuario.listar();
	}
	
}
