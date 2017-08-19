package br.com.caelum.jdbc.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {
	
	private Connection connection;
	
	public ContatoDao() {
		
		this.connection = new ConnectionFactory().getConnection();
		
	}
	
	public void adiciona(Contato contato) {
		
		String sql = "insert into contatos " +
				"(nome,email,endereco,dataNascimento)" +
				" values (?,?,?,?)";
		
		try {
			
			//prepared statement para inserção
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(
					contato.getDataNascimento().getTimeInMillis()));
			
			// executa
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		}
			
	}
	
	public List<Contato> getLista() {
		
		
		String sql = "select * from contatos";
				
		try {
			
			//prepared statement para inserção
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			List<Contato> contatos = new ArrayList<>();
			
			while(rs.next()) {
				
				// Objeto contato
				Contato contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				// montando a data com Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				contatos.add(contato);
				
			}
			
			rs.close();
			stmt.close();
			
			return contatos;
		
		} catch(SQLException e) {
			
			throw new RuntimeException(e);
			
		}
		
		
	}

}
