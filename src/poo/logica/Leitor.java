package poo.logica;

import interfaces.InterfaceEmpregado;
import java.io.*;
import java.util.ArrayList;
import poo.tipo.*;

public class Leitor {
	File file;
        private FileReader reader;
	private BufferedReader breader;
	private Empregado emp;
        
	public Leitor(Empregado emp) throws IOException{
		this.emp = emp;
                reader = new FileReader("arq.txt");
	}
	
	public double getFaturaTotal() throws IOException{
		double total = 0;
		double aux;
		String linha = null;
		
		this.reader = new FileReader("arq.txt");
		this.breader = new BufferedReader(reader);
		
		while((linha = breader.readLine())!=null){
			aux = Double.parseDouble(linha.split(",")[1]); //Adiciona o campo 0 do split a lista			
			total += aux;
		}
		close();		
		return total;
	}
	
	public double getFaturaMedia() throws IOException{
		double total = 0;
		double aux;
		String linha = null;
		int i=0;
		
		this.reader = new FileReader("arq.txt");
		this.breader = new BufferedReader(reader);

		
		while((linha = breader.readLine())!=null){
			aux = Double.parseDouble(linha.split(",")[1]); //Adiciona o campo 0 do split a lista
			total += aux;
			i++;
		}
		close();
		return total/i;
	}
	
	public void close() throws IOException{
		this.breader.close();
		this.reader.close();
	}
}
