package br.ufba.dcc.domain;

import java.io.Serializable;

public class Status implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6132261060291474524L;
	
	private Integer id;
	private String descricao;
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
