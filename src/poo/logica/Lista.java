/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.logica;

import java.util.ArrayList;
import poo.exceptions.EmpregadoNaoEncontradoException;
import poo.tipo.Empregado;

/**
 *
 * @author caioe_000
 */
public class Lista {
    
    
    public Lista(){
        
    }
    
    public Empregado buscaNome(String nome, ArrayList<Empregado> lista) throws EmpregadoNaoEncontradoException{
            int i=0;            
            Empregado aux = null;

            System.out.print("\nDigite o nome do funcionario para buscar: ");
            
            for(i=0; i<lista.size(); i++){
                    if(nome.equals(lista.get(i).getNome())){
                            aux = (Empregado) lista.get(i);
                            break;
                    }

                    i++;
            }

            if(aux==null)
                throw new EmpregadoNaoEncontradoException("Empregado nao encontrado");
            else
                //faz nada

            return aux;

    }
    
    public Empregado buscaCpf(String cpf, ArrayList<Empregado> lista) throws EmpregadoNaoEncontradoException{
            int i=0;            
            Empregado aux = null;

            System.out.print("\nDigite o CPF do funcionario para buscar: ");
            
            for(i=0; i<lista.size(); i++){
                    if(cpf.equals(lista.get(i).getCpf())){
                            aux = (Empregado) lista.get(i);
                            break;
                    }

                    i++;
            }

            if(aux==null)
                throw new EmpregadoNaoEncontradoException("Empregado nao encontrado");
            else
                //faz nada

            return aux;

    }
    
}
