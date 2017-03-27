package br.ufba.dcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufba.dcc.domain.Aluno;
import br.ufba.dcc.domain.Departamento;
import br.ufba.dcc.domain.Instituto;
import br.ufba.dcc.factory.ConexaoFactory;

public class AlunoDAO {

	public void salvar(Aluno aluno)throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO aluno ");
		sql.append("(nome, matricula, email, id_departamento) ");
		sql.append("VALUES (?, ?, ?, ?) ");

		Connection conexao = (Connection) ConexaoFactory.conectar();

		java.sql.PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, aluno.getNome() );
		comando.setString(2, aluno.getMatricula());
		comando.setString(3, aluno.getEmail());
		comando.setInt(4, aluno.getDepartamento().getId());

		comando.executeUpdate();
	}

	public ArrayList<Aluno> listar()throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT a.id, a.nome, a.matricula, a.email, d.id, d.nome, i.id, i.nome ")
		.append("FROM aluno a ")
		.append("INNER JOIN departamento d ON d.id = a.id_departamento ")
		.append("INNER JOIN instituto  i   ON i.id = d.id_instituto ");

		Connection conexao = (Connection) ConexaoFactory.conectar();

		PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Aluno> itens = new ArrayList<Aluno>();

		while(resultado.next()){
			Departamento departamento = new Departamento();
			departamento.setId(resultado.getInt("d.id"));
			departamento.setNome(resultado.getString("d.nome"));
			Instituto instituto = new Instituto();
			instituto.setId(resultado.getInt("i.id"));
			instituto.setNome(resultado.getString("i.nome"));
			departamento.setInstituto(instituto); 


			Aluno a = new Aluno();

			a.setId(resultado.getInt("a.id"));
			a.setNome(resultado.getString("a.nome"));
			a.setEmail(resultado.getString("a.email"));
			a.setMatricula(resultado.getString("a.matricula"));

			a.setDepartamento(departamento);

			itens.add(a);
		}
		return itens;	
		
	}

	public void excluir(Aluno a)throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM aluno ");
		sql.append("WHERE id = ? ");

		Connection conexao = (Connection) ConexaoFactory.conectar();
		PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql.toString());
		comando.setInt(1, a.getId());
		comando.executeUpdate();		
	}

	public void editar(Aluno a) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE aluno ")
		.append("SET nome = ?, matricula = ?, email = ?, id_departamento = ? ")
		.append("WHERE id = ? " );

		Connection conexao = (Connection) ConexaoFactory.conectar();
		PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql.toString());

		comando.setString(1, a.getNome());
		comando.setString(2, a.getMatricula());
		comando.setString(3, a.getEmail());
		comando.setInt(4, a.getDepartamento().getId());
		comando.setInt(5, a.getId());
		comando.executeUpdate();

	}
}
