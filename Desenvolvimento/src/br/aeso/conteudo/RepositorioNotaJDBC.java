package br.aeso.conteudo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.aeso.blog.Blog;
import br.aeso.blog.RepositorioBlogJDBC;
import br.aeso.jdbc.Conexao;
import br.aeso.usuario.RepositorioUsuarioJDBC;
import br.aeso.usuario.Usuario;

public class RepositorioNotaJDBC implements IRepositorioNota{
	
	private Connection con;
	
	public RepositorioNotaJDBC() {
		try {
			con = Conexao.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void cadastrar(Nota nota) {
		String sql = "insert into nota (data, texto, id_usuario_fk, id_blog_fk) values(?,?,?,?)";
		
		try {
			PreparedStatement preStatement = con.prepareStatement(sql);
			preStatement.setString(1, nota.getData());
			preStatement.setString(2, nota.getTexto());
			preStatement.setInt(3, nota.getAutor().getId());
			preStatement.setInt(4, nota.getBlog().getIdBlog());
			preStatement.execute();
			con.close();
			preStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void atualizar(Nota nota) {
		String sql = "update nota set data = ?, texto = ?, id_usuario_fk = ?, id_blog_fk = ? where id_nota = ?";
		
		try {
			PreparedStatement preStatement = con.prepareStatement(sql);
			preStatement.setString(1, nota.getData());
			preStatement.setString(2, nota.getTexto());
			preStatement.setInt(3, nota.getAutor().getId());
			preStatement.setInt(4, nota.getBlog().getIdBlog());
			preStatement.setInt(5, nota.getIdConteudo());
			preStatement.executeUpdate();
			preStatement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean remover(Integer id) {
		String sql = "delete from nota where id_nota = ?";
		
		try {
			PreparedStatement preStatement = con.prepareStatement(sql);
			preStatement.setInt(1, id);
			preStatement.executeUpdate();
			preStatement.close();
			con.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Conteudo procurar(Integer id) {
		String sql = "select * from nota"
				+ "inner join usuario on id_usuario_fk = id_usuario"
				+ "inner join blog on id_blog_fk = id_blog";
		
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				if(rs.getInt("id_nota") == id){
					Usuario user = new Usuario(rs.getString("nome"), rs.getString("email"));
					user.setId(rs.getInt("id_usuario"));
					
					Blog blog = new Blog(rs.getString("data"), user, rs.getString("titulo"));
					
					Nota nota = new Nota(rs.getString(2), rs.getString("texto"), user, blog);
					
					return nota;
				}
			}
			pstm.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean existe(Integer id) {
		String sql = "select * from nota";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getInt("id_nota") == id){
					return true;
				}
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Conteudo> listar() {
		ArrayList<Conteudo> listaNota = new ArrayList<>();
		
		String sql = "select * from nota"
				+ "inner join usuario on id_usuario_fk = id_usuario"
				+ "inner join blog on id_blog_fk = id_blog";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Usuario user = new RepositorioUsuarioJDBC().procurar(rs.getInt("id_usuario_fk"));
				Blog blog = new RepositorioBlogJDBC().procurar(rs.getInt("id_blog_fk"));
				
				Nota nota = new Nota(rs.getString("data"),
						rs.getString("texto"), 
						user, 
						blog);
				nota.setIdConteudo(rs.getInt("id_nota"));
				
				
				listaNota.add(nota);
			}
			ps.close();
			con.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaNota;
	}

}
