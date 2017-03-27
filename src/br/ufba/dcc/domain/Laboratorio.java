package br.ufba.dcc.domain;

import java.io.Serializable;

/**
 * Created by Bruno on 21/03/2017.
 */
public class Laboratorio implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2740042309700725371L;
	private Integer id;
	private String nome;
    private String numSala;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumSala() {
        return numSala;
    }

    public void setNumSala(String numSala) {
        this.numSala = numSala;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
