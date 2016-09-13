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
	}
	
	@Override
	public void cadastrar(Blog blog) throws SQLException {
		String sql = "insert into blog (blog_data, blog_titulo, blog_id_usuario_fk) values (?,?,?)";
		
		if(!existe(blog.getIdBlog())){
			PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preStatement.setString(1, blog.getData());
			preStatement.setString(2, blog.getTitulo());
			preStatement.setInt(3, blog.getDono().getId());
			preStatement.execute();
			con.close();
			preStatement.close();
		}
	}

	@Override
	public void atualizar(Blog blog) throws SQLException {
		String sql = "update blog set blog_data = ?, blog_titulo = ?, blog_id_usuario_fk = ? where blog_id = ?";
		
		if(existe(blog.getIdBlog())){
			PreparedStatement preStatement = con.prepareStatement(sql);
			preStatement.setString(1, blog.getData());
			preStatement.setString(2, blog.getTitulo());
			preStatement.setInt(3, blog.getDono().getId());
			preStatement.setInt(4, blog.getIdBlog());
			preStatement.executeUpdate();
			preStatement.close();
			con.close();
		}
	}

	@Override
	public boolean remover(Integer id) throws SQLException {
		String sql = "delete from blog where blog_id = ?";
		
		if(existe(id)){
			PreparedStatement preStatement = con.prepareStatement(sql);
			preStatement.setInt(1, id);
			preStatement.executeUpdate();
			preStatement.close();
			con.close();
			return true;
		}
		
		return false;
		
	}

	@Override
	public Blog procurar(Integer id) throws SQLException {
		String sql = "select * from blog "
				+ "	inner join usuario on blog_id_usuario_fk = usuario_id";
		
		if(existe(id)){
			PreparedStatement preStatement = con.prepareStatement(sql);
			ResultSet resultSet = preStatement.executeQuery();			
			while(resultSet.next()){
				if(resultSet.getInt("blog_id") == id){
					Usuario user = new Usuario(resultSet.getString("usuario_nome"), resultSet.getString("usuario_email"));
					user.setId(resultSet.getInt("usuario_id"));
					
					Blog blog = new Blog(resultSet.getString("blog_data"), user, resultSet.getString("blog_titulo"));
					blog.setIdBlog(resultSet.getInt("blog_id"));
					
					return blog;
				}
			}
		
			preStatement.close();
			resultSet.close();
			con.close();
		}
		
		return null;
	}

	@Override
	public boolean existe(Integer id) throws SQLException {
		String sql = "select * from blog";
		
		PreparedStatement preStatement = con.prepareStatement(sql);
		ResultSet resultSet = preStatement.executeQuery();			
		while(resultSet.next()){
			if(resultSet.getInt("blog_id") == id){
				return true;
			}
		}
		
		preStatement.close();
		resultSet.close();
		con.close();
		
		return false;
	}

	@Override
	public ArrayList<Blog> listar() throws SQLException {
		ArrayList<Blog> listaBlog = new ArrayList<>();
		
		String sql = "select * from blog inner join usuario on blog_id_usuario_fk = usuario_id";	
		
		PreparedStatement preStatement = con.prepareStatement(sql);
		
		ResultSet resultSet = preStatement.executeQuery();
				
		while(resultSet.next()){
			Usuario user = new Usuario(resultSet.getString("usuario_nome"), resultSet.getString("usuario_email"));
			user.setId(resultSet.getInt("usuario_id"));
			
			Blog blog = new Blog(resultSet.getString("blog_data"), user , resultSet.getString("blog_titulo"));
			blog.setIdBlog(resultSet.getInt(1));
			
			listaBlog.add(blog);
		}
		
		preStatement.close();
		resultSet.close();
		con.close();
		
		return listaBlog;
		
	}

	
}
