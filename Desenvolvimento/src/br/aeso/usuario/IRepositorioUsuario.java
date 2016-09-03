package br.aeso.usuario;

import java.util.ArrayList;

import br.aeso.blog.Blog;

public interface IRepositorioUsuario {
	public void cadastrar (Usuario usuario);
	public void atualizar (Usuario usuario);
	public boolean remover (Usuario usuario);
	public Usuario procurar (String nome);
	public boolean existe (String nome);
	public ArrayList<Usuario> listar();
}
