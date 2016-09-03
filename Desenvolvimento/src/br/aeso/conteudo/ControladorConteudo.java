package br.aeso.conteudo;

import java.util.ArrayList;

import br.aeso.usuario.Usuario;

public class ControladorConteudo {
	
	private IRepositorioConteudo repositorioConteudo;
	
	public ControladorConteudo() {
		repositorioConteudo = new RepositorioConteudoArray();
	}
	
	public void cadastrarConteudo(Conteudo conteudo){
		repositorioConteudo.cadastrar(conteudo);
	}
	
	public void atualizarConteudo(Conteudo conteudo){
		repositorioConteudo.atualizar(conteudo);
	}
	
	public boolean removerConteudo(Conteudo conteudo){
		return repositorioConteudo.remover(conteudo);
	}
	
	public Conteudo procurarConteudo (Usuario user){
		return repositorioConteudo.procurar(user);
	}
	
	public ArrayList<Conteudo> listarConteudo(){
		return repositorioConteudo.listar();
	}
}
