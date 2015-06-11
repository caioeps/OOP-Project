package poo.tipo;

import java.util.ArrayList;

import poo.exceptions.*;
import poo.interfaces.InterfaceEmpregado;


public class Engenheiro extends Empregado{
	
	private String eng;

	public Engenheiro(String nome, double salario, String cpf, ArrayList<Integer> dataAdm, String email, String eng) {
		super(nome, salario, cpf, dataAdm, email);
		
		this.eng = eng;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}
	
}
