/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.logica;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

/**
 *
 * @author Caio
 */
public class Escritor {
    
    File file;
    FileWriter fw;
    
    public Escritor() throws IOException{
        if(!file.exists())
            file.createNewFile();
                    
        file = new File("relatorio.txt");
        fw = new FileWriter(file);
    }
}
