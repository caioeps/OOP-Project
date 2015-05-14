package poo.tipo;

import java.util.ArrayList;

public interface InterfaceEmpregado {
	public double getSalario();
	
	public void setSalario(double salario);
	
	public String getNome();
	
	public void setNome(String nome);
	
	public String getCpf();
	
	public void setCpf(String cpf);
	
	public boolean isAtivo();
	
	public void setAtivo(boolean isAtivo);
	
	public ArrayList<Integer> getDataAdm();
	
	public void setDataAdm(int d, int m, int a);
	
	public ArrayList<Integer> getDataDem();
	
	public void setDataDem(int d, int m, int a);
}
