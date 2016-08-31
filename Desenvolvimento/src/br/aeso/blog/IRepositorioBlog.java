package br.aeso.blog;

import java.util.ArrayList;

import br.aeso.conteudo.Conteudo;
import br.aeso.usuario.Usuario;

public interface IRepositorioBlog {
	
	public void cadastrar (Blog blog);
	public void atualizar (Blog blog);
	public boolean remover (Blog blog);
	public Blog procurar (Usuario user);
	public boolean existe (Usuario user);
	public ArrayList<Conteudo> conteudos();
}
