/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.tipo;

import java.util.ArrayList;

public class Ensino extends Empregado{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -4286903579061355261L;
	private String formacao;
    
    public Ensino(String nome, double salario, String cpf, ArrayList<Integer> dataAdm, String email, String formacao){
        super(nome, salario, cpf, dataAdm, email);
        this.formacao = formacao;
        
    }

    public String getFormacao() {
        return formacao;
    }
    
    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    @Override
    public int compareTo(Empregado pi)
    {
        return (pi.getNome()).compareTo(pi.getNome());
    }
}
