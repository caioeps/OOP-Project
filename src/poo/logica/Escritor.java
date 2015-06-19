package poo.logica;

import poo.tipo.Empregado;

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
    private ArrayList<Empregado> lista;
    private FileWriter fw;
    File file;
    FileOutputStream fOut;
    ObjectOutputStream objOut;

    
    public Escritor() throws IOException{
        this.lista = new ArrayList<>();
    }
    
    public void addLista(Empregado e){
        this.lista.add(e);
    }
    
    public void escreveArq() throws IOException{
        int i = 1;
        boolean b;
        
        while(true){
            if (b=new File("arq"+Integer.toString(i)+".txt").exists()){
                i++;
            }else{
                this.file = new File("Relatorio_"+Integer.toString(i)+".txt");
                this.fw = new FileWriter(this.file);

                this.fw.write("string ");
                this.fw.write("string ");
                this.fw.close();

                break;           
            }            
        } 
    }
    
    public void gravar(ArrayList<Empregado> list){
        try {
            this.fOut = new FileOutputStream("data.dat"); 
            this.objOut = new ObjectOutputStream(fOut);
            
            this.objOut.writeObject(list);
            
            //this.objOut.flush();
            this.objOut.close();
            
            //this.fOut.flush();
            this.fOut.close();
            
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }catch (IOException ex) {
            ex.getMessage();
        }
    }
    
    

    
}
