package br.ufba.dcc.domain;

import java.io.Serializable;

/**
 * Created by Bruno on 21/03/2017.
 */
public class Aluno implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3949890751373730826L;
	private Integer id;
    private String nome;
    private String matricula;
    private String email;
    private Departamento departamento = new  Departamento();
    
    

   
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}
