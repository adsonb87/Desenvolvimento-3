package br.aeso.conteudo;

import java.util.ArrayList;

public interface IRepositorioNota {
	
	public void cadastrar (Nota nota);
	public void atualizar (Nota nota);
	public boolean remover (Integer id);
	public Conteudo procurar (Integer id);
	public boolean existe (Integer id);
	public ArrayList<Conteudo> listar();
}
