package br.ufba.dcc.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ufba.dcc.dao.AlunoDAO;
import br.ufba.dcc.dao.TransferenciaDAO;
import br.ufba.dcc.domain.Aluno;
import br.ufba.dcc.domain.Departamento;
import br.ufba.dcc.domain.Transferencia;
import br.ufba.dcc.util.JSFUtil;

@ManagedBean
@ViewScoped
public class TransferenciaBean {


	private ArrayList<Transferencia> transferencias;
	private ArrayList<Transferencia> transferenciasFiltradas;

	private Transferencia transferencia;
	
	private ArrayList<Aluno> alunos;
	




	public void carregarListagem(){
		try{
			TransferenciaDAO dao = new TransferenciaDAO();
			Departamento departamento = new Departamento();
			departamento.setId(1);
			transferencias=dao.listarHistoricoTrasferenciaLab(departamento);
		}catch(SQLException e){
			e.printStackTrace();
			JSFUtil.adicionarMensagensErro(e.getMessage());
		}
	}


	
	public void prepararNovo(){
		try{
		transferencia = new Transferencia();
		AlunoDAO dao = new AlunoDAO();
		alunos = dao.listar();
		
		}catch(SQLException e){
			e.printStackTrace();
			JSFUtil.adicionarMensagensErro(e.getMessage());
		}
	}


	public ArrayList<Transferencia> getTransferencias() {
		return transferencias;
	}




	public void setTransferencias(ArrayList<Transferencia> transferencias) {
		this.transferencias = transferencias;
	}




	public ArrayList<Transferencia> getTransferenciasFiltradas() {
		return transferenciasFiltradas;
	}




	public void setTransferenciasFiltradas(ArrayList<Transferencia> transferenciasFiltradas) {
		this.transferenciasFiltradas = transferenciasFiltradas;
	}




	public Transferencia getTransferencia() {
		return transferencia;
	}




	public void setTransferencia(Transferencia transferencia) {
		this.transferencia = transferencia;
	}




	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}




	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	

	

}
