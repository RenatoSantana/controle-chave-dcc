package br.ufba.dcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufba.dcc.domain.Aluno;
import br.ufba.dcc.domain.Departamento;
import br.ufba.dcc.domain.Status;
import br.ufba.dcc.domain.Transferencia;
import br.ufba.dcc.factory.ConexaoFactory;

public class TransferenciaDAO {


	public void salvar(Transferencia trasferencia)throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO chave_com_aluno ");
		sql.append(" (id_chave, id_aluno_anterior,id_aluno_posterior ,dataHoraPosseChave, dataHoraEntregaChave, id_status) ");
		sql.append(" VALUES (?, ?, ?, ?, ?) ");

		Connection conexao = (Connection) ConexaoFactory.conectar();

		java.sql.PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setInt(1, trasferencia.getStatus().getId() );
		comando.setInt(2, trasferencia.getAlunoAnterior().getId());
		comando.setInt(3, trasferencia.getAlunoPosterior().getId());
		comando.setDate(4,  new java.sql.Date (trasferencia.getDataHoraPosseChave().getTime()));
		comando.setDate(5,  new java.sql.Date(trasferencia.getDataHoraEntregaChave().getTime()));

		comando.executeUpdate();
	}


	public ArrayList<Transferencia> listarHistoricoTrasferenciaLab(Departamento dep)throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT cca.dataHoraPosseChave,cca.dataHoraEntregaChave,a.id , a.nome, a.matricula, a2.id,a2.nome, a2.matricula , s.descricao")
		.append(" FROM chave_com_aluno cca ")
		.append(" INNER JOIN status  s  ON cca.id_status  = s.id ")
		.append(" INNER JOIN aluno  a  ON cca.id_aluno_anterior  = a.id ")
		.append(" LEFT JOIN aluno   a2   ON cca.id_aluno_posterior  = a2.id ")
		.append(" INNER JOIN chave  c  ON cca.id_chave  = c.id ")
		.append(" INNER JOIN laboratorio  l   ON c.id_laboratorio = l.id ")
		//.append(" INNER JOIN departamento d   ON l.id_departamento = d.id ")

		.append(" WHERE l.id_departamento = ? AND cca.dataHoraPosseChave is not null and a2.id is not null")

		.append(" order by cca.dataHoraPosseChave DESC ");

		Connection conexao = (Connection) ConexaoFactory.conectar();

		PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql.toString());

		comando.setInt(1, dep.getId());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Transferencia> itens = new ArrayList<Transferencia>();

		while(resultado.next()){
			Transferencia transferencia = new Transferencia();

			Aluno aluno = new Aluno();
			aluno.setId(resultado.getInt("a.id"));
			aluno.setNome(resultado.getString("a.nome"));
			aluno.setMatricula(resultado.getString("a.matricula"));


				Aluno aluno2 = new Aluno();
				aluno2.setId(resultado.getInt("a2.id"));
				aluno2.setNome(resultado.getString("a2.nome"));
				aluno2.setMatricula(resultado.getString("a2.matricula"));
				transferencia.setAlunoPosterior(aluno);

			

			Status status  = new Status();
			status.setDescricao(resultado.getString("s.descricao"));
			transferencia.setAlunoAnterior(aluno);
			transferencia.setStatus(status);

			transferencia.setDataHoraPosseChave(resultado.getDate("cca.dataHoraPosseChave"));
			transferencia.setDataHoraEntregaChave(resultado.getDate("cca.dataHoraEntregaChave"));





			itens.add(transferencia);
		}
		return itens;	

	}

}
