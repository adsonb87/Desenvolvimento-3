package br.aeso.conteudo;

import java.util.ArrayList;

import br.aeso.blog.Blog;
import br.aeso.usuario.Usuario;

public interface IRepositorioComentario {
	
	public void cadastrar (Comentario comentario);
	public void atualizar (Comentario comentario);
	public boolean remover (Integer id);
	public Conteudo procurar (Integer id);
	public boolean existe (Integer id);
	public ArrayList<Conteudo> listar();
}
