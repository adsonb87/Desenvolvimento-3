package br.aeso.conteudo;

import java.util.ArrayList;

import br.aeso.blog.Blog;
import br.aeso.usuario.Usuario;

public interface IRepositorioConteudo {
	
	public void cadastrar (Conteudo conteudo);
	public void atualizar (Conteudo conteudo);
	public boolean remover (Conteudo conteudo);
	public Conteudo procurar (Usuario user);
	public boolean existe (Usuario user);
	public ArrayList<Conteudo> listar();
}
