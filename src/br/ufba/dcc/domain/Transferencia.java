package br.ufba.dcc.domain;

import java.io.Serializable;
import java.util.Date;

public class Transferencia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5983206047086273584L;


	
	private Chave chave;
	private Aluno alunoAnterior;
	private Aluno alunoPosterior;
	private Date dataHoraPosseChave;
	private Date dataHoraEntregaChave;
	private Status status;
	
	
	public Date getDataHoraEntregaChave() {
		return dataHoraEntregaChave;
	}
	public void setDataHoraEntregaChave(Date dataHoraEntregaChave) {
		this.dataHoraEntregaChave = dataHoraEntregaChave;
	}
	public Chave getChave() {
		return chave;
	}
	public void setChave(Chave chave) {
		this.chave = chave;
	}
	
	public Date getDataHoraPosseChave() {
		return dataHoraPosseChave;
	}
	public void setDataHoraPosseChave(Date dataHoraPosseChave) {
		this.dataHoraPosseChave = dataHoraPosseChave;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Aluno getAlunoPosterior() {
		return alunoPosterior;
	}
	public void setAlunoPosterior(Aluno alunoPosterior) {
		this.alunoPosterior = alunoPosterior;
	}
	public Aluno getAlunoAnterior() {
		return alunoAnterior;
	}
	public void setAlunoAnterior(Aluno alunoAnterior) {
		this.alunoAnterior = alunoAnterior;
	}

}
