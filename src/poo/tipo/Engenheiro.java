package poo.tipo;

import java.util.ArrayList;

import poo.exceptions.*;
import poo.interfaces.InterfaceEmpregado;


public class Engenheiro extends Empregado implements InterfaceEmpregado{
	
	private String eng;

	public Engenheiro(String nome, double salario, String cpf, ArrayList<Integer> dataAdm, ArrayList<Integer> dataDem, String eng) {
		super(nome, salario, cpf, dataAdm, dataDem);
		
		this.eng = eng;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}
	
	
	
	
}
