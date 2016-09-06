package br.aeso.usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import br.aeso.jdbc.Conexao;

public class RepositorioUsuarioJDBC implements IRepositorioUsuario{
	
	private Connection con;
	
	public RepositorioUsuarioJDBC() {
		try {
			con = Conexao.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void cadastrar(Usuario usuario){
		String sql = "insert into usuario (nome, email) values (?,?)";		
		
		try {
			PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preStatement.setString(1, usuario.getNome());
			preStatement.setString(2, usuario.getEmail());
			preStatement.execute();
			con.close();
			preStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	@Override
	public void atualizar(Usuario usuario) {
		String sql = "update usuario set nome = ?, email = ? where id_usuario = ?";
		
		try {
			PreparedStatement preStatement = con.prepareStatement(sql);
			preStatement.setString(1, usuario.getNome());
			preStatement.setString(2, usuario.getEmail());
			preStatement.setInt(3, usuario.getId());
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
		String sql = "delete from usuario where id_usuario = ?";
		
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
	public Usuario procurar(Integer id) {
		String sql = "select * from usuario";
		
		try {
			PreparedStatement preStatement  = con.prepareStatement(sql);
				
			ResultSet resultSet = preStatement.executeQuery();
			
			while(resultSet.next()){
				if(resultSet.getInt("id_usuario") == id){
					Usuario user = new Usuario(resultSet.getString("nome"), resultSet.getString("email"));
					user.setId(resultSet.getInt("id_usuario"));
					
					return user;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public boolean existe(Integer id){
		String sql = "select * from usuario";
		
		try {
			PreparedStatement preStatement = con.prepareStatement(sql);
			ResultSet resultSet = preStatement.executeQuery();
			
			while(resultSet.next()){
				if(resultSet.getInt("id_usuario") == id){
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
	public ArrayList<Usuario> listar(){
		ArrayList<Usuario> listaUsuario = new ArrayList<>();
		
		String sql = "select * from usuario";
		
		
		try {
			PreparedStatement preStatement = con.prepareStatement(sql);
			
			ResultSet resultSet = preStatement.executeQuery();
			while(resultSet.next()){
				Usuario user = new Usuario(resultSet.getString("nome"), resultSet.getString("email"));
				user.setId(resultSet.getInt("id_usuario"));
				listaUsuario.add(user);
			}
			preStatement.close();
			resultSet.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listaUsuario;
		
	}

}
