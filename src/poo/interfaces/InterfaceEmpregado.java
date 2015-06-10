package poo.interfaces;

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

    public ArrayList<String> getNotes();

    public void addNotes(String str);

    public void aumentoPorc(double p);

    public void aumentoLiq(double l);

    public void decrescimoPorc(double p);

    public void decrescimoLiq(double l);

    public String getEmail();

    public void setEmail(String email);
    
    public void dataAdmToStringAMD();
    
    public void dataAdmToStringDMA();
	
    public void dataAdmToStringMDA();
    
    public int dataMesParaNumero(String str);
    
    public String dataNumeroParaMes(int i);
}
