package poo.logica;

import poo.tipo.*;

import java.util.ArrayList;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;






/**
 *
 * @author Caio
 */
public class Escritor implements java.io.Serializable {    
    private Engenheiro eng;
    private Ensino ens;
    private Legal leg;
    private Rh rh;
    private SemSuperior sp;
    private Tecnico tec;
    
    private ArrayList<Empregado> lista;
    private ListaHandler listaHandler;
    
    private String newLine = System.lineSeparator();
	
    public Escritor(ArrayList<Empregado> lista){
        this.lista = lista;
        this.listaHandler = new ListaHandler();
    }
    
    public void preencheCampos(Empregado key, File file, FileWriter fw) throws IOException{    	
		fw.write(newLine + "Engenheiro --------------->");
		fw.write("Nome: " + key.getNome());
		fw.write("Salario: " + key.getSalario());
		fw.write("CPF: " + key.getCpf());
		fw.write("Email: " + key.getCpf());
		fw.write("Data de admissao: " + key.getDataAdm().get(0) + "/" + key.getDataAdm().get(1) + "/" + key.getDataAdm().get(2));
		
		//ACIMA -> Propriedades comuns a todos os empregados
		//ABAIXO -> Propriedes particulares
		
		if(key instanceof Engenheiro){
			this.eng = (Engenheiro) key;
			fw.write("Area: " + this.eng.getEng());
		}
		if(key instanceof Ensino){
			this.ens = (Ensino) key;
			fw.write("Formacao: " + this.ens.getFormacao());
		}
		if(key instanceof Legal){
			this.leg = (Legal) key;
			fw.write("Cargo: " + this.leg.getCargo());
		}
		if(key instanceof Rh){
			this.rh = (Rh) key;
			fw.write("Funcao: " + this.rh.getFuncao());
		}
		if(key instanceof SemSuperior){
			this.sp = (SemSuperior) key;
			fw.write("Funcao: " + this.sp.getFuncao());
		}
		if(key instanceof Tecnico){
			this.tec = (Tecnico) key;
			fw.write("Licensa: " + this.tec.getLicensa());
		}
		fw.write(newLine + "----------------------");
		
    }
        
    public void escreveRelatorio() throws IOException{
        int i = 1;
        boolean b;
        
        while(true){
            if (b=new File("Relatorio_"+Integer.toString(i)+".txt").exists()){
                i++;
            } else {
                File file = new File("Relatorio_"+Integer.toString(i)+".txt");
                FileWriter fw = new FileWriter(file);

                for(Empregado key : this.lista){
                	this.preencheCampos(key, file, fw);
                	
                }

                break;           
            }            
        } 
    }
    
    
    
    

    
}
