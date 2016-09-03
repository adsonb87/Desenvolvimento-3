package br.aeso.blog;

import java.sql.SQLException;
import java.util.ArrayList;

import br.aeso.conteudo.Conteudo;
import br.aeso.usuario.Usuario;

public interface IRepositorioBlog {
	
	public void cadastrar (Blog blog);
	public void atualizar (Blog blog);
	public boolean remover (Integer id);
	public Blog procurar (Integer id);
	public boolean existe (Integer id);
	public ArrayList<Blog> listar() throws SQLException;
}
