package br.ufba.dcc.domain;

import java.io.Serializable;

/**
 * Created by Bruno on 21/03/2017.
 */
public class Departamento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8041442148077165408L;
	private Integer id;
    private String nome;
    private Instituto instituto;

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

	public Instituto getInstituto() {
		return instituto;
	}

	public void setInstituto(Instituto instituto) {
		this.instituto = instituto;
	}
}
