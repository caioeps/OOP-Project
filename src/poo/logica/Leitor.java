package poo.logica;

import poo.interfaces.InterfaceEmpregado;
import java.io.*;
import java.util.ArrayList;
import poo.tipo.*;

import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Leitor {
	private Empregado emp;
        
	public Leitor() throws IOException{
            
	}
        
	public double getFaturaTotal() throws FileNotFoundException, IOException{
		double total = 0;
		double aux;
		String linha = null;
		
		FileReader fReader = new FileReader("arq.txt");
		BufferedReader bReader = new BufferedReader(fReader);
		
		while((linha = bReader.readLine())!=null){
			aux = Double.parseDouble(linha.split(",")[1]); //Adiciona o campo 0 do split a lista			
			total += aux;
		}
		
                fReader.close();
                bReader.close();
                
		return total;
	}
	
	public double getFaturaMedia() throws IOException{
		double total = 0;
		double aux;
		String linha = null;
		int i=0;
		
		FileReader fReader = new FileReader("arq.txt");
		BufferedReader bReader = new BufferedReader(fReader);

		
		while((linha = bReader.readLine())!=null){
			aux = Double.parseDouble(linha.split(",")[1]); //Adiciona o campo 0 do split a lista
			total += aux;
			i++;
		}
                
		fReader.close();
                bReader.close();
                
		return total/i;
	}
}
