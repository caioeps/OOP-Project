package poo.tipo;

import java.util.ArrayList;

public class Rh extends Empregado{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 3446328221128928370L;
	private String funcao;
    
    public Rh(String nome, double salario, String cpf, ArrayList<Integer> dataAdm, String email, String funcao){
        super(nome, salario, cpf, dataAdm, email);
        
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public int compareTo(Empregado pi)
    {
        return (pi.getNome()).compareTo(pi.getNome());
    }
}
