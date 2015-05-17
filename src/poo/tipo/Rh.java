package poo.tipo;

import java.util.ArrayList;

public class Rh extends Empregado{
    
    private String funcao;
    
    public Rh(String nome, double salario, String cpf, ArrayList<Integer> dataAdm, ArrayList<Integer> dataDem, String funcao){
        super(nome, salario, cpf, dataAdm, dataDem);
        
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
