package br.aeso.blog;

import java.sql.SQLException;
import java.util.ArrayList;

import br.aeso.conteudo.Conteudo;
import br.aeso.usuario.Usuario;

public interface IRepositorioBlog {
	
	public void cadastrar (Blog blog) throws SQLException;
	public void atualizar (Blog blog) throws SQLException;
	public boolean remover (Integer id) throws SQLException;
	public Blog procurar (Integer id) throws SQLException;
	public boolean existe (Integer id) throws SQLException;
	public ArrayList<Blog> listar() throws SQLException;
}
