/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import poo.tipo.Empregado;

/**
 *
 * @author caioe_000
 */
public class Serializador {
    
	
    public Serializador(){
        
    }
    
    public void grava(ArrayList<Empregado> list) throws FileNotFoundException, IOException{
        FileOutputStream fos;
        ObjectOutputStream oos;


        fos = new FileOutputStream("data.bin");
        oos = new ObjectOutputStream(fos);

        oos.writeObject(((ArrayList<Empregado>)list));
        
        oos.close();
     
        
    }
    
    public Object abre() throws FileNotFoundException, IOException, ClassNotFoundException{
        File file;
    	FileInputStream fis;
        ObjectInputStream ois;
        Object arq = null;
        
        if(new File("data.bin").exists()){
            file = new File("data.bin");
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            arq =  ois.readObject();
            
            ois.close();
            
            return arq;
        } else {
        	return null;
        }
        
    }
    
    
}
