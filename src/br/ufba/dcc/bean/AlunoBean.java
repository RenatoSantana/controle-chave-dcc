package br.ufba.dcc.bean;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ufba.dcc.dao.AlunoDAO;
import br.ufba.dcc.dao.DepartamentoDAO;
import br.ufba.dcc.domain.Aluno;
import br.ufba.dcc.domain.Departamento;
import br.ufba.dcc.util.JSFUtil;

@ManagedBean
@ViewScoped
public class AlunoBean {
	
	
	private ArrayList<Aluno> alunos;
	private ArrayList<Aluno> alunosFiltrados;
	
	private Aluno aluno;
	private ArrayList<Departamento> departamentos;
	
	
	
	public void carregarListagem(){
		try{
		AlunoDAO dao = new AlunoDAO();
		alunos=dao.listar();
		}catch(SQLException e){
			e.printStackTrace();
			JSFUtil.adicionarMensagensErro(e.getMessage());
		}
	}
	public void prepararNovo(){
		try{
		aluno = new Aluno();
		DepartamentoDAO dao = new DepartamentoDAO();
		
		departamentos = dao.listar();
		}catch(SQLException e){
			e.printStackTrace();
			JSFUtil.adicionarMensagensErro(e.getMessage());
		}
	}
	public void novo(){
		try{
		AlunoDAO dao = new AlunoDAO();
		dao.salvar(aluno);
		
		alunos = dao.listar();
		JSFUtil.adicionarMensagemSucesso("Aluno cadastrado com sucesso");
		}catch(SQLException e){
			e.printStackTrace();
			JSFUtil.adicionarMensagensErro(e.getMessage());
		}
	}
	public void excluir (){
		try{
		AlunoDAO dao = new AlunoDAO();
		
		dao.excluir(aluno);
		alunos = dao.listar();
		
		JSFUtil.adicionarMensagemSucesso("Aluno removido com sucesso");
		}catch(SQLException e){
			e.printStackTrace();
			JSFUtil.adicionarMensagensErro(e.getMessage());
		}
	}
	public void prepararEditar(){
	try{
		DepartamentoDAO dao = new DepartamentoDAO();
		
		departamentos = dao.listar();
		
	}catch(SQLException e){
		e.printStackTrace();
		JSFUtil.adicionarMensagensErro(e.getMessage());
	}
	}
	public void editar(){
		try{
			AlunoDAO dao = new AlunoDAO();
			
			dao.editar(aluno);
			
			alunos = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Aluno editado com sucesso");
			
		}catch(SQLException e){
			e.printStackTrace();
			JSFUtil.adicionarMensagensErro(e.getMessage());
		}
	}
	
	
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	public ArrayList<Aluno> getAlunosFiltrados() {
		return alunosFiltrados;
	}
	public void setAlunosFiltrados(ArrayList<Aluno> alunosFiltrados) {
		this.alunosFiltrados = alunosFiltrados;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public ArrayList<Departamento> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(ArrayList<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
	

}
