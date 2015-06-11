package poo.tipo;

import java.util.ArrayList;

public class Legal extends Empregado{
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
    
    
}
