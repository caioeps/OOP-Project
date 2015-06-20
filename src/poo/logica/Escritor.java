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
    
    
    

    
    public Escritor() throws IOException{
        super();
    }
        
    public void escreveRelatorio() throws IOException{
        int i = 1;
        boolean b;
        
        while(true){
            if (b=new File("Relatorio_"+Integer.toString(i)+".txt").exists()){
                i++;
            }else{
                File file = new File("Relatorio_"+Integer.toString(i)+".txt");
                FileWriter fw = new FileWriter(file);

                fw.write("string ");
                fw.write("string ");
                fw.close();

                break;           
            }            
        } 
    }
    
    public void gravar(ArrayList<Empregado> list) throws FileNotFoundException, IOException{
       File file = new File("data.bin");
         
       FileOutputStream fOut = new FileOutputStream(file); 
       ObjectOutputStream objOut = new ObjectOutputStream(fOut);

       objOut.writeObject(list);

       objOut.flush();
       objOut.close();
       fOut.flush();
       fOut.close();
    }
    
    

    
}
