package poo.tipo;

import java.util.ArrayList;


public class Tecnico extends Empregado{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -4782277585705818916L;
		private String licensa;

	public Tecnico(String nome, double salario, String cpf,	ArrayList<Integer> dataAdm, String email, String licensa) {
            super(nome, salario, cpf, dataAdm, email);
            this.licensa = licensa;    
	}

    public String getLicensa() {
        return licensa;
    }

    public void setLicensa(String licensa) {
        this.licensa = licensa;
    }

    @Override
    public int compareTo(Empregado pi)
    {
        return (pi.getNome()).compareTo(pi.getNome());
    }
	
}
