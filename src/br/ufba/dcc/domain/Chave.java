package br.ufba.dcc.domain;

import java.io.Serializable;

/**
 * Created by Bruno on 21/03/2017.
 */
public class Chave implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6447918873387038363L;
	private Integer id;
    private String descricao;
    
    private Laboratorio laboratorio;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
