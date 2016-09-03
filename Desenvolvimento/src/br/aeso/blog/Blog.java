package br.aeso.blog;

import java.util.ArrayList;

import br.aeso.conteudo.Conteudo;
import br.aeso.usuario.Usuario;

public class Blog {
	private Integer idBlog;
	private String data;
	private Usuario dono;
	private String titulo;
	private ArrayList<Conteudo> conteudo;
	
	public Blog(String data, Usuario dono, String titulo) {
		this.data = data;
		this.dono = dono;
		this.titulo = titulo;
		conteudo = new ArrayList<>();
	}
	
	

	public Integer getIdBlog() {
		return idBlog;
	}



	public void setIdBlog(Integer idBlog) {
		this.idBlog = idBlog;
	}



	public ArrayList<Conteudo> getConteudo() {
		return conteudo;
	}



	public void setConteudo(ArrayList<Conteudo> conteudo) {
		this.conteudo = conteudo;
	}



	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public ArrayList<Conteudo> listarConteudos() {
		return conteudo;
	}

	public void inserirConteudo(Conteudo conteudo) {
		this.conteudo.add(conteudo);
	}
	
	public void removerConteudo(Conteudo conteudo){
		this.conteudo.remove(conteudo);
	}



	@Override
	public String toString() {
		return "Blog [idBlog=" + idBlog + ", data=" + data + ", dono=" + dono + ", titulo=" + titulo +  "]";
	}

	
	
}
