package poo.tipo;

import java.util.ArrayList;

public class Legal extends Empregado{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3076565197483308348L;
	private String cargo;
    
    public Legal(String nome, double salario, String cpf, ArrayList<Integer> dataAdm, String email, String cargo){
        super(nome, salario, cpf, dataAdm, email);
        
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public int compareTo(Empregado pi)
    {
        return (pi.getNome()).compareTo(pi.getNome());
    }
    
    
}
