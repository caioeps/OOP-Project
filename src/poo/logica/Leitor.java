package poo.logica;

import poo.interfaces.InterfaceEmpregado;
import java.io.*;
import java.util.ArrayList;
import poo.tipo.*;

import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Leitor {
	File file;
        FileInputStream fIn;
        ObjectInputStream objIn;

	private FileReader fReader;
	private BufferedReader breader;
	private Empregado emp;
        
	public Leitor(Empregado emp) throws IOException{
		this.emp = emp;
                this.fReader = new FileReader("arq.txt");
	}
        
        public ArrayList<Empregado> abrir(){
            try {
                ArrayList<Empregado> aux;
                this.fIn = new FileInputStream("data.dat");
                this.objIn = new ObjectInputStream(fIn); 
                
                aux = (ArrayList) objIn.readObject();
                
                return aux;
                
            } catch (FileNotFoundException ex) {
                ex.getMessage();
            }catch (IOException ex) {
                ex.getMessage();
            } catch (ClassNotFoundException ex) {
                ex.getMessage();
            }
        }
	
	public double getFaturaTotal() throws IOException{
		double total = 0;
		double aux;
		String linha = null;
		
		this.fReader = new FileReader("arq.txt");
		this.breader = new BufferedReader(fReader);
		
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
		
		this.fReader = new FileReader("arq.txt");
		this.breader = new BufferedReader(fReader);

		
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
		this.fReader.close();
	}
}
