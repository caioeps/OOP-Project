package poo.logica;

import poo.interacao.ListaFrame;
import poo.tipo.*;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.Map.Entry;
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
    
    ListaFrame frame;
    private String nomeRelatorioAtual; //String para retornar o nome do arquivo gerado;
    private ArrayList<Empregado> lista;
    private ListaHandler listaHandler; //Classe para lidar com o ArrayList
    
    private String newLine = System.lineSeparator(); // Apenas para facilitar escrita
	
    public Escritor(ListaFrame frame){
    	this.frame = frame;
        this.lista = frame.getLista();
        this.listaHandler = new ListaHandler();
    }
    
    public String getNomeRelatorioAtual() {
		return nomeRelatorioAtual;
	}
    
    private void preencheCabecario(Empregado key, FileWriter fw) throws IOException{
		if(key instanceof Engenheiro){
			fw.write(newLine + "Engenheiro(a) --------------->");
		}
		if(key instanceof Ensino){
			fw.write(newLine + "Ensino --------------->");
		}
		if(key instanceof Legal){
			fw.write(newLine + "Legal --------------->");
		}
		if(key instanceof Rh){
			fw.write(newLine + "Recursos Humanos --------------->");
		}
		if(key instanceof SemSuperior){
			fw.write(newLine + "Sem Superior --------------->");
		}
		if(key instanceof Tecnico){
			fw.write(newLine + "Tecnico(a) --------------->");
		}	
    }
    
    private void preenchePropParticular(Empregado key, FileWriter fw) throws IOException{
    	if(key instanceof Engenheiro){
			this.eng = (Engenheiro) key;
			fw.write(" Area: " + this.eng.getEng());
			fw.write(newLine);
		}
		if(key instanceof Ensino){
			this.ens = (Ensino) key;
			fw.write(" Formacao: " + this.ens.getFormacao());
			fw.write(newLine);
		}
		if(key instanceof Legal){
			this.leg = (Legal) key;
			fw.write(" Cargo: " + this.leg.getCargo());
			fw.write(newLine);
		}
		if(key instanceof Rh){
			this.rh = (Rh) key;
			fw.write(" Funcao: " + this.rh.getFuncao());
			fw.write(newLine);
		}
		if(key instanceof SemSuperior){
			this.sp = (SemSuperior) key;
			fw.write(" Funcao: " + this.sp.getFuncao());
			fw.write(newLine);
		}
		if(key instanceof Tecnico){
			this.tec = (Tecnico) key;
			fw.write(" Licensa: " + this.tec.getLicensa());
			fw.write(newLine);
		}
    }
    
    public void preencheNotes(Empregado key, FileWriter fw) throws IOException{
    	int i = 1;
    	for(String str : key.getNotes()){
    		fw.write("  Nota " + i + ": " + str);
    		fw.write(newLine);
    		i++;
    	}
    }
    
    public void preencheRelatorio(Empregado key, FileWriter fw) throws IOException{    	

		preencheCabecario(key, fw);
		fw.write(newLine);
		fw.write(" Nome: " + key.getNome());
		fw.write(newLine);
		fw.write(" Salario: R$" + key.getSalario());
		fw.write(newLine);
		fw.write(" CPF: " + key.getCpf());
		fw.write(newLine);
		fw.write(" Email: " + key.getCpf());
		fw.write(newLine);
		fw.write(" Data de admissao: " + key.getDataAdm().get(0) + "/" + key.getDataAdm().get(1) + "/" + key.getDataAdm().get(2));
		fw.write(newLine);
		//ACIMA -> Propriedades comuns a todos os empregados		
		//ABAIXO -> Propriedes particulares
		preenchePropParticular(key, fw);
		
		fw.write(newLine);
		
		preencheNotes(key, fw);
    }     
    
    public void preencheRelatorioPorClasse(){
    	
    }

	public void escreveRelatorioGeral() throws IOException{
        int i = 1;
        
        //While para criar novo arquivo caso exista outro
        while(true){
            if (new File("Relatorio_"+Integer.toString(i)+".txt").exists()){
                i++;
            } else {
            	this.nomeRelatorioAtual = "Relatorio_"+Integer.toString(i)+".txt";
                File file = new File(this.nomeRelatorioAtual);
                FileWriter fw = new FileWriter(file);
                
                //Escreve o arquivo
        		fw.write("Numero de empregados: " + this.lista.size());
        		fw.write(newLine);
        		fw.write("Gasto total com salario por mês: " + this.listaHandler.getSalarioTotal(this.lista));
        		fw.write(newLine);
        		fw.write("Gasto total com salario por ano: " + this.listaHandler.getSalarioTotalAnual(this.lista));
        		fw.write(newLine);
        		fw.write("Salario medio dos funcionarios: " + this.listaHandler.getSalarioMédio(this.lista));
        		fw.write(newLine);
        		fw.write("Salario medio anual dos funcionarios: " + this.listaHandler.getSalarioMédioAnual(this.lista));
        		fw.write(newLine);
        		
                
                for(Empregado key : this.lista){
                	this.preencheRelatorio(key, fw);                	
                }
                
                fw.close();
                
                this.frame.salvaLista();
                
                break;           
            }            
        } 
    }
	
	public void escreveRelatorioPorClasse() throws IOException{
        int i = 1;
        
        //While para criar novo arquivo caso exista outro
        while(true){
            if (new File("Relatorio_por_classe_"+Integer.toString(i)+".txt").exists()){
                i++;
            } else {
            	this.nomeRelatorioAtual = "Relatorio_por_classe_"+Integer.toString(i)+".txt";
                File file = new File(this.nomeRelatorioAtual);
                FileWriter fw = new FileWriter(file);
                HashMap<String, Double> map = new HashMap<String, Double>();
                map = this.listaHandler.getSalarioPorClasse(this.lista);
                //Escreve o arquivo
                for(Entry<String, Double> entry : map.entrySet()){
                	String key = entry.getKey();
                	Double valor = entry.getValue();
                	
                	fw.write(key + " ----------->");
                	fw.write(newLine);
                	fw.write("Salario total gasto com funcionarios do tipo " + key + ": R$" + valor);
                	fw.write(newLine);
                	fw.write("Salario total gasto anualmente com funcionarios do tipo " + key + ": R$" + valor*13);
                	fw.write(newLine + newLine);
                }
                
                fw.close();
                
                break;           
            }            
        } 
	}
    
    
    
    

    
}
