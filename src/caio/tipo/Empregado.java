package caio.tipo;
import java.util.ArrayList;


abstract class Empregado implements InterfaceEmpregado{
	protected String nome;
	protected double salario;
	protected String cpf;
	protected boolean isAtivo;
	protected ArrayList<Integer> dataAdm; // AAAA/MM/DD // x[0]/x[1]/x[2]
	protected ArrayList<Integer> dataDem; // AAAA/MM/DD // x[0]/x[1]/x[2]
	
	
	public Empregado(String nome, double salario, String cpf, ArrayList<Integer> dataAdm, ArrayList<Integer> dataDem) {
		this.nome = nome;
		this.salario = salario;
		this.cpf = cpf;
		this.isAtivo = true;
		this.dataAdm = dataAdm;
		this.dataDem = dataDem;
	}



	public double getSalario() {
		return this.salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public boolean isAtivo() {
		return this.isAtivo;
	}
	
	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}
	
	public ArrayList<Integer> getDataAdm() {
		return this.dataAdm;
	}
	
	public void setDataAdm(int d, int m, int a) {
		this.dataAdm.add(a);
		this.dataAdm.add(m);
		this.dataAdm.add(d);
	}
	
	public ArrayList<Integer> getDataDem() {
		return this.dataDem;
	}
	
	public void setDataDem(int d, int m, int a) {
		this.dataDem.add(a);
		this.dataDem.add(m);
		this.dataDem.add(d);
	}
	
	
}
