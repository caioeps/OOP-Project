package poo.tipo;

import poo.interfaces.InterfaceEmpregado;

import java.util.ArrayList;

import poo.exceptions.*;


public abstract class Empregado implements InterfaceEmpregado{

    protected String nome;
    protected double salario;
    protected String cpf;
    protected boolean isAtivo;
    protected ArrayList<Integer> dataAdm; // AAAA/MM/DD // x[0] | x[1] | x[2]
    protected ArrayList<Integer> dataDem; // AAAA/MM/DD // x[0] | x[1] | x[2]
    protected ArrayList<String> notes;
    private String email;
    protected static double SAL_MIN = 780.0;



    public Empregado(String nome, double salario, String cpf, ArrayList<Integer> dataAdm, String email) {
            this.nome = nome;
            this.setSalario(salario); //equals this.salario = salario;
            this.cpf = cpf;
            this.isAtivo = true;
            this.dataAdm = dataAdm;
            this.email = email;
            this.notes = new ArrayList<String>();
    }



    public double getSalario() {
            return this.salario;
    }

    public void setSalario(double salario) {
            if (salario < 0.0)
                    throw new SalarioException("Erro: valor de salario invalido.");
            else if(salario < SAL_MIN)
                    throw new SalarioException("Inserir salario maior ou igual ao salario minimo.");
            else
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

    public ArrayList<String> getNotes(){
            return this.notes;
    }

    public void addNotes(String str){
            this.notes.add(str);
    }

    public void aumentoPorc(double p){
        this.salario += this.salario*(p/100);
    }

    public void aumentoLiq(double l){
        this.salario += l;
    }

    public void decrescimoPorc(double p){
        this.salario -= this.salario*(p/100);
    }

    public void decrescimoLiq(double l){
        this.salario -= l;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void dataAdmToStringAMD(){
        String str = this.dataAdm.get(0) + "/" + this.dataNumeroParaMes(this.dataAdm.get(1)) + "/" + this.dataAdm.get(2); // AAAA/MM/DD
    }
    
    public void dataAdmToStringDMA(){
        String str = this.dataAdm.get(1) + "/" + this.dataNumeroParaMes(this.dataAdm.get(1)) + "/" + this.dataAdm.get(0); // DD/MM/AAAA
    }
	
    public void dataAdmToStringMDA(){
        String str = this.dataAdm.get(1) + "/" + this.dataNumeroParaMes(this.dataAdm.get(2)) + "/" + this.dataAdm.get(0); // MM/DD/AAAA
    }
    
    public int dataMesParaNumero(String str){
        int r;
        switch(str){
            case "Janeiro":
                r = 1;
                break;
            case "Fevereiro":
                r = 2;
                break;
            case "Marco":
                r = 3;
                break;
            case "Abril":
                r = 4;
                break;
            case "Maio":
                r = 5;
                break;
            case "Junho":
                r = 6;
                break;
            case "Julho":
                r = 7;
                break;
            case "Agosto":
                r = 8;
                break;
            case "Setembro":
                r = 9;
                break;
            case "Outubro":
                r = 10;
                break;
            case "Novembro":
                r = 11;
                break;
            case "Dezembro":
                r = 12;
            default:
                throw new DataException("Erro ao computar data");
        }
        
        return r;
    }
    
    public String dataNumeroParaMes(int i){
        String r;
        switch(i){
            case 1:
                r = "Janeiro";
                break;
            case 2:
                r = "Fevereiro";
                break;
            case 3:
                r = "Marco";
                break;
            case 4:
                r = "Abril";
                break;
            case 5:
                r = "Maio";
                break;
            case 6:
                r = "Junho";
                break;
            case 7:
                r = "Julho";
                break;
            case 8:
                r = "Agosto";
                break;
            case 9:
                r = "Setembro";
                break;
            case 10:
                r = "Outubro";
                break;
            case 11:
                r = "Novembro";
                break;
            case 12:
                r = "Dezembro";
            default:
                throw new DataException("Erro ao computar data");
        }
        
        return r;
    } 
}
