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

public class DepartamentoDAO {
	
	public ArrayList<Departamento> listar()throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT d.id, d.nome, i.id, i.nome ")
		.append("FROM departamento d ")
		.append("INNER JOIN instituto  i   ON i.id = d.id_instituto ");

		Connection conexao = (Connection) ConexaoFactory.conectar();

		PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Departamento> itens = new ArrayList<Departamento>();

		while(resultado.next()){
			Departamento departamento = new Departamento();
			departamento.setId(resultado.getInt("d.id"));
			departamento.setNome(resultado.getString("d.nome"));
			Instituto instituto = new Instituto();
			instituto.setId(resultado.getInt("i.id"));
			instituto.setNome(resultado.getString("i.nome"));
			departamento.setInstituto(instituto); 


			

			itens.add(departamento);
		}
		return itens;	
		
	}

}
