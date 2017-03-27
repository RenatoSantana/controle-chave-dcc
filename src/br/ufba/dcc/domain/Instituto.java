package br.ufba.dcc.domain;

import java.io.Serializable;

/**
 * Created by Bruno on 21/03/2017.
 */
public class Instituto implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -545144265161302345L;
	private Integer id;
	private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
