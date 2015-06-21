package poo.tipo;

import java.util.ArrayList;

public class Engenheiro extends Empregado {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 5604187277039908401L;
	private String eng;

    public Engenheiro(String nome, double salario, String cpf, ArrayList<Integer> dataAdm, String email, String eng) {
            super(nome, salario, cpf, dataAdm, email);

            this.eng = eng;
    }

    public String getEng() {
            return eng;
    }

    public void setEng(String eng) {
            this.eng = eng;
    }

    @Override
    public int compareTo(Empregado pi)
    {
        return (pi.getNome()).compareTo(pi.getNome());
    }
        
        
	
}
