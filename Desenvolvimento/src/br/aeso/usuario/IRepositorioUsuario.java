package br.aeso.usuario;

import java.sql.SQLException;
import java.util.ArrayList;

import br.aeso.blog.Blog;

public interface IRepositorioUsuario {
	public void cadastrar (Usuario usuario);
	public void atualizar (Usuario usuario);
	public boolean remover (Integer id);
	public Usuario procurar (Integer id);
	public boolean existe (Integer id);
	public ArrayList<Usuario> listar();
}
