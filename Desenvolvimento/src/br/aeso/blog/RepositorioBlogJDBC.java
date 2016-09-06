package br.aeso.blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.LoadBalancedMySQLConnection;

import br.aeso.jdbc.Conexao;
import br.aeso.usuario.Usuario;


public class RepositorioBlogJDBC implements IRepositorioBlog{
	
	private Connection con;
	
	public RepositorioBlogJDBC() throws SQLException {
		try {
			con = Conexao.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		con = DriverManager.getConnection("jdbc:mysql://localhost/blog", "root","");
	}
	
	@Override
	public void cadastrar(Blog blog) {
		String sql = "insert into blog (data, titulo, id_usuario) values (?,?,?)";
		try {
			PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preStatement.setString(1, blog.getData());
			preStatement.setString(2, blog.getTitulo());
			preStatement.setInt(3, blog.getDono().getId());
			preStatement.execute();
			con.close();
			preStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Blog blog) {
		String sql = "update blog set data = ?, titulo = ?, id_usuario = ? where id_blog = ?";
		
		try {
			PreparedStatement preStatement = con.prepareStatement(sql);
			preStatement.setString(1, blog.getData());
			preStatement.setString(2, blog.getTitulo());
			preStatement.setInt(3, blog.getDono().getId());
			preStatement.setInt(4, blog.getIdBlog());
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
		String sql = "delete from blog where id_blog = ?";
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
	public Blog procurar(Integer id) {
		String sql = "select * from blog inner join usuario on id_usuario_fk = id_usuario";
		try {
			PreparedStatement preStatement = con.prepareStatement(sql);
			
			ResultSet resultSet = preStatement.executeQuery();			
			
			while(resultSet.next()){
				if(resultSet.getInt("id_blog") == id){
					
					Usuario user = new Usuario(resultSet.getString("nome"), resultSet.getString("email"));
					
					user.setId(resultSet.getInt("id_usuario"));
					
					Blog blog = new Blog(resultSet.getString("data"), user, resultSet.getString("titulo"));
					
					blog.setIdBlog(resultSet.getInt("id_blog"));
					
					return blog;
				}
			}
			preStatement.close();
			resultSet.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean existe(Integer id) {
		String sql = "select * from blog";
		try {
			PreparedStatement preStatement = con.prepareStatement(sql);
			ResultSet resultSet = preStatement.executeQuery();			
			while(resultSet.next()){
				if(resultSet.getInt("id_blog") == id){
					return true;
				}
			}
			preStatement.close();
			resultSet.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Blog> listar() throws SQLException {
		ArrayList<Blog> listaBlog = new ArrayList<>();
		String sql = "select * from blog inner join usuario on id_usuario_fk = id_usuario";	
		
		PreparedStatement preStatement = con.prepareStatement(sql);
		
		ResultSet resultSet = preStatement.executeQuery();
				
		while(resultSet.next()){
			Usuario user = new Usuario(resultSet.getString("nome"), resultSet.getString("email"));
			user.setId(resultSet.getInt("id_usuario"));
			
			Blog blog = new Blog(resultSet.getString("data"), user , resultSet.getString("titulo"));
			blog.setIdBlog(resultSet.getInt(1));
			
			listaBlog.add(blog);
		}
		
		preStatement.close();
		resultSet.close();
		con.close();
		
		return listaBlog;
		
	}

	
}
