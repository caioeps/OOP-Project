/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.logica;

import java.util.ArrayList;
import java.util.HashMap;

import poo.exceptions.EmpregadoNaoEncontradoException;
import poo.tipo.*;

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
    
    public double getSalarioTotalAnual(ArrayList<Empregado> lista){
    	double total = 0.0;
    	
    	for(Empregado emp : lista){
    		total += emp.getSalario();
    	}
    	
    	return total*13;
    }
    
    public double getSalarioMedio(ArrayList<Empregado> lista){
    	double total = 0.0;
    	int n = 0;
    	
    	for(Empregado emp : lista){
    		total += emp.getSalario();
    		n++;
    	}
    	
    	return total/n;
    }
    
    public double getSalarioMedioAnual(ArrayList<Empregado> lista){
    	double total = 0.0;
    	int n = 0;
    	
    	for(Empregado emp : lista){
    		total += emp.getSalario();
    		n++;
    	}
    	
    	return (total/n)*13;
    }
    
    public HashMap<String, Double> getSalarioPorClasse(ArrayList<Empregado> lista){
    	HashMap<String, Double> map = new HashMap<String, Double>();
    	double aux = 0.0;
    	
    	//Inicializa
    	map.put("Engenheiro", 0.0);
    	map.put("Ensino", 0.0);
    	map.put("Legal", 0.0);
    	map.put("Recursos humanos", 0.0);
    	map.put("Sem Superior", 0.0);
    	map.put("Tecnico", 0.0);
    	    	
    	//Soma a cada um
    	for(Empregado key: lista){
    		if(key instanceof Engenheiro){ 			
    			aux = map.get("Engenheiro");
    			aux += key.getSalario();
    			map.put("Engenheiro", aux);

    		}else if(key instanceof Ensino){
    			aux = map.get("Ensino");
    			aux += key.getSalario();
    			map.put("Ensino", 0.0);

    		}else if(key instanceof Legal){
    			aux = map.get("Legal");
    			aux += key.getSalario();
    			map.put("Legal", aux);

    		}else if(key instanceof Rh){
    			aux = map.get("Recursos humanos");
    			aux += key.getSalario();
    			map.put("Recursos humanos", aux);

    		}else if(key instanceof SemSuperior){
    			aux = map.get("Sem Superior");
    			aux += key.getSalario();
    			map.put("Sem Superior", aux);
    			
 
    		}else if(key instanceof Tecnico){
    			aux = map.get("Tecnico");
    			aux += key.getSalario();
    			map.put("Tecnico", aux);   			
    			
    		}
    	}
    	
    	return map;
    }
    
}
