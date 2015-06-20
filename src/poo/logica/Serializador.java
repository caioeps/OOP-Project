/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.logica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author caioe_000
 */
public class Serializador {
       
    public Serializador(){
        
    }
    
    public void grava(ArrayList list) throws FileNotFoundException, IOException{
        FileOutputStream fos;
        ObjectOutputStream oos;


        fos = new FileOutputStream("data.bin");
        oos = new ObjectOutputStream(fos);

        oos.writeObject(list);
     
        
    }
    
    public Object abre() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis;
        ObjectInputStream ois;
        Object arq = null;
        
  
        fis = new FileInputStream("data.bin");
        ois = new ObjectInputStream(fis);

        arq =  ois.readObject();

        
        return arq;
    }
    
    
}
