package br.aeso.blog;

public class Conteudo {
	private String data;
	private String texto;
	private Usuario autor;
	
	public Conteudo(String data, String texto, Usuario autor) {
		this.data = data;
		this.texto = texto;
		this.autor = autor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Conteudo [data=" + data + ", texto=" + texto + ", autor=" + autor + "]";
	}
	
	
}
