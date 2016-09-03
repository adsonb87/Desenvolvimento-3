package br.aeso.usuario;

public class Usuario {
	private Integer id;
	private String nome;
	private String email;
	
	public Usuario(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}
	
	
	
}
