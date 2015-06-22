/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.logica;

import java.util.ArrayList;
import java.util.HashMap;
import poo.exceptions.EmpregadoNaoEncontradoException;
import poo.tipo.Empregado;

/**
 *
 * @author caioe_000
 */
public class ListaHandler {
        
    public ListaHandler(){
        
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
    
    public double getSalarioTotal(ArrayList<Empregado> lista){
    	double total = 0.0;
    	
    	for(Empregado emp : lista){
    		total += emp.getSalario();
    	}
    	
    	return total;
    }
    
    public double getSalarioMédio(ArrayList<Empregado> lista){
    	double total = 0.0;
    	int n = 0;
    	
    	for(Empregado emp : lista){
    		total += emp.getSalario();
    		n++;
    	}
    	
    	return total/n;
    }
    
    public HashMap<String, Double> getSalarioPorClasse(ArrayList<Empregado> lista){
    	HashMap<String, Double> aux = new HashMap<String, Double>();
    	
    	
    	return aux;
    }
    
}
