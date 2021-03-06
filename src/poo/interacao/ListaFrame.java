package poo.interacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import poo.tipo.*;
import poo.interfaces.InterfaceEmpregado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import poo.logica.Escritor;
import poo.logica.ListaHandler;
import poo.logica.Serializador;
import poo.logica.TableMouseListener;

/**
 *
 * @author caioe_000
 */
 public class ListaFrame extends javax.swing.JFrame {
    
    //Minhas variaveis
    private AddFrameEngenheiro frameEngenheiro;
    private AddFrameEnsino frameEnsino;
    private AddFrameLegal frameLegal;
    private AddFrameRH frameRh;
    private AddFrameSemSuperior frameSemSuperior;
    private AddFrameTecnico frameTecnico;
    private AddNotesFrame addNotes;
    private PerfilGeralFrame perfilGeral;
    private EditFrame editFrame;
    // ^^^^ FRAMES
    
    private ArrayList<Empregado> lista;
    private ListaHandler listaHandler;
    private Escritor escritor;
    
        
    //FIM das minhas variáveis
    
    /**
     * Creates new form ListaFrame
     */
    public ListaFrame() {
        initComponents();
        this.lista = new ArrayList<>();
        
        try {
                if(new Serializador().abre() != null)
                    carregaLista();
		} catch (ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(null, 
                        e.getMessage(),
                        "ERRO",
                        JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
                    JOptionPane.showMessageDialog(null, 
                        e.getMessage(),
                        "ERRO",
                        JOptionPane.INFORMATION_MESSAGE);
                }
        	
    }
    
    public ArrayList<Empregado> getLista(){
    	return this.lista;
    }
    
    public void carregaLista(){
        Serializador ser = new Serializador();
        
        try {
            this.lista = (ArrayList) ser.abre();
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao carregar lista.",
                    "ERRO I/O",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao carregar - Classe nao encontrada.",
                    "ERRO I/O",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
        atualizaLista();
    }
    
    public void salvaLista(){
        Serializador ser = new Serializador();
        try {
            ser.grava(this.lista);
            
        } catch (FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, 
                    "Arquivos corrompidos.  FILE_NOT_FOUND",
                    "ERRO I/O",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao salvar lista.",
                    "ERRO I/O",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void passaLista(InterfaceEmpregado eng){
        this.lista.add((Empregado) eng);
    }
    
    public void atualizaLista(){ 
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        


        dtm.setRowCount(0);

        for(Empregado key : this.lista){              

            Vector row = new Vector();

            this.table.setRowSelectionAllowed(true);
            row.add(key.getNome());
            row.add(key.getSalario());
            row.add(key.getCpf());
            row.add(key.getEmail());


            dtm.addRow(row);
        }
        
        this.salvaLista();

    }
       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuVerPerfil = new javax.swing.JMenuItem();
        menuEditar = new javax.swing.JMenuItem();
        menuAddAnotacao = new javax.swing.JMenuItem();
        menuExcluir = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAdicionar = new javax.swing.JMenu();
        itemEngenheiro = new javax.swing.JMenuItem();
        itemEnsino = new javax.swing.JMenuItem();
        itemLegal = new javax.swing.JMenuItem();
        itemRh = new javax.swing.JMenuItem();
        itemTecnico = new javax.swing.JMenuItem();
        itemSemSuperior = new javax.swing.JMenuItem();
        menuOrdenar = new javax.swing.JMenu();
        itemOrdenarNomeCresc = new javax.swing.JMenuItem();
        itemOrdenarNomeDecresc = new javax.swing.JMenuItem();
        itemOrdenarSalarioCresc = new javax.swing.JMenuItem();
        itemOrdenarSalarioDecresc = new javax.swing.JMenuItem();
        menuGerar = new javax.swing.JMenu();
        itemRelatorioGeral = new javax.swing.JMenuItem();
        itemRelatorioPorClasse = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        itemSobre = new javax.swing.JMenuItem();

        jPopupMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPopupMenu1MouseReleased(evt);
            }
        });

        menuVerPerfil.setText("Ver perfil");
        menuVerPerfil.setToolTipText("");
        menuVerPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVerPerfilActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuVerPerfil);

        menuEditar.setText("Editar");
        menuEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuEditar);

        menuAddAnotacao.setText("Adicionar anotacao");
        menuAddAnotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddAnotacaoActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuAddAnotacao);

        menuExcluir.setText("Excluir");
        menuExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExcluirActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuExcluir);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Salario", "CPF", "Emaill"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });
        table.setComponentPopupMenu (this.jPopupMenu1);
        jScrollPane1.setViewportView(table);

        menuAdicionar.setText("Adicionar");
        menuAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAdicionarActionPerformed(evt);
            }
        });

        itemEngenheiro.setText("Engenheiro");
        itemEngenheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEngenheiroActionPerformed(evt);
            }
        });
        menuAdicionar.add(itemEngenheiro);

        itemEnsino.setText("Ensino");
        itemEnsino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEnsinoActionPerformed(evt);
            }
        });
        menuAdicionar.add(itemEnsino);

        itemLegal.setText("Setor legal");
        itemLegal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLegalActionPerformed(evt);
            }
        });
        menuAdicionar.add(itemLegal);

        itemRh.setText("Recursos Humanos");
        itemRh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRhActionPerformed(evt);
            }
        });
        menuAdicionar.add(itemRh);

        itemTecnico.setText("Tecnico");
        itemTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTecnicoActionPerformed(evt);
            }
        });
        menuAdicionar.add(itemTecnico);

        itemSemSuperior.setText("Sem superior");
        itemSemSuperior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSemSuperiorActionPerformed(evt);
            }
        });
        menuAdicionar.add(itemSemSuperior);

        jMenuBar1.add(menuAdicionar);

        menuOrdenar.setText("Ordenar por");

        itemOrdenarNomeCresc.setText("nome crescente");
        itemOrdenarNomeCresc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOrdenarNomeCrescActionPerformed(evt);
            }
        });
        menuOrdenar.add(itemOrdenarNomeCresc);

        itemOrdenarNomeDecresc.setText("nome descrescente");
        itemOrdenarNomeDecresc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOrdenarNomeDecrescActionPerformed(evt);
            }
        });
        menuOrdenar.add(itemOrdenarNomeDecresc);

        itemOrdenarSalarioCresc.setText("salario crescente");
        itemOrdenarSalarioCresc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOrdenarSalarioCrescActionPerformed(evt);
            }
        });
        menuOrdenar.add(itemOrdenarSalarioCresc);

        itemOrdenarSalarioDecresc.setText("salario decrescente");
        itemOrdenarSalarioDecresc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOrdenarSalarioDecrescActionPerformed(evt);
            }
        });
        menuOrdenar.add(itemOrdenarSalarioDecresc);

        jMenuBar1.add(menuOrdenar);

        menuGerar.setText("Gerar");

        itemRelatorioGeral.setText("Relatorio Geral");
        itemRelatorioGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRelatorioGeralActionPerformed(evt);
            }
        });
        menuGerar.add(itemRelatorioGeral);
        
        itemRelatorioPorClasse.setText("Relatorio por Classe");
        itemRelatorioPorClasse.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		itemRelatorioPorClasseActionPerformed(evt);
        	}

        });
        menuGerar.add(itemRelatorioPorClasse);
        

        jMenuBar1.add(menuGerar);

        menuAjuda.setText("Ajuda");

        itemSobre.setText("Sobre");
        menuAjuda.add(itemSobre);
        itemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSobreActionPerformed(evt);
            }
        });

        jMenuBar1.add(menuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void itemSobreActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO
        JOptionPane.showMessageDialog(null, 
                "Sistema de gerenciamento de funcionarios." + System.lineSeparator() + "V1.0",
                "Programa de CAIOEPS",
                JOptionPane.INFORMATION_MESSAGE);
    }   
    
    private void itemRelatorioGeralActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO 
    	try {
			this.escritor = new Escritor(this);
			this.escritor.escreveRelatorioGeral();
			JOptionPane.showMessageDialog(null, 
	                "Relatorio salvo em " + this.escritor.getNomeRelatorioAtual(),
	                "Relatorio gerado com sucesso",
	                JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, 
	                "Erro ao escrever o relatorio.",
	                "ERRO",
	                JOptionPane.INFORMATION_MESSAGE);
		}
    }   
    
    private void itemRelatorioPorClasseActionPerformed(java.awt.event.ActionEvent evt){
    	//TODO
    	
    	try {
    		this.escritor = new Escritor(this);
			escritor.escreveRelatorioPorClasse();
			JOptionPane.showMessageDialog(null, 
					"Relatorio salvo em " + this.escritor.getNomeRelatorioAtual(),
	                "Relatorio gerado com sucesso",
	                JOptionPane.INFORMATION_MESSAGE);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, 
	                "Erro ao escrever o relatorio.",
	                "ERRO",
	                JOptionPane.INFORMATION_MESSAGE);
		}
    	
    }

    private void menuAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAdicionarActionPerformed
        // TODO add your handling code here:        
    }//GEN-LAST:event_menuAdicionarActionPerformed

    private void itemEngenheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEngenheiroActionPerformed
    	//TODO
    	frameEngenheiro = new AddFrameEngenheiro(this);
        frameEngenheiro.setVisible(true);
        frameEngenheiro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_itemEngenheiroActionPerformed

    private void itemEnsinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEnsinoActionPerformed
    	//TODO
    	frameEnsino = new AddFrameEnsino(this);
        frameEnsino.setVisible(true);
        frameEnsino.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_itemEnsinoActionPerformed

    private void itemLegalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLegalActionPerformed
        //TODO
    	frameLegal = new AddFrameLegal(this);
        frameLegal.setVisible(true);
        frameLegal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_itemLegalActionPerformed

    private void itemRhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRhActionPerformed
        //TODO
    	frameRh = new AddFrameRH(this);
        frameRh.setVisible(true);
        frameRh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_itemRhActionPerformed

    private void itemTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTecnicoActionPerformed
        //TODO
    	frameTecnico = new AddFrameTecnico(this);
        frameTecnico.setVisible(true);
        frameTecnico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_itemTecnicoActionPerformed

    private void itemSemSuperiorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSemSuperiorActionPerformed
        //TODO
    	frameSemSuperior = new AddFrameSemSuperior(this);
        frameSemSuperior.setVisible(true);
        frameSemSuperior.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_itemSemSuperiorActionPerformed

    private void jPopupMenu1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPopupMenu1MouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPopupMenu1MouseReleased

    private void menuVerPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVerPerfilActionPerformed
        // TODO
        int index = this.table.getSelectedRow();
                
        if(this.lista.get(index) instanceof Engenheiro){
            this.perfilGeral = new PerfilGeralFrame((Engenheiro) this.lista.get(index));
        } else if (this.lista.get(index) instanceof Ensino) {
            this.perfilGeral = new PerfilGeralFrame((Ensino) this.lista.get(index));
        } else if (this.lista.get(index) instanceof Legal) {
            this.perfilGeral = new PerfilGeralFrame((Legal) this.lista.get(index));
        } else if (this.lista.get(index) instanceof Rh) {
            this.perfilGeral = new PerfilGeralFrame((Rh) this.lista.get(index));
        } else if (this.lista.get(index) instanceof SemSuperior) {
            this.perfilGeral = new PerfilGeralFrame((SemSuperior) this.lista.get(index));
        } else if (this.lista.get(index) instanceof Tecnico) {
            this.perfilGeral = new PerfilGeralFrame((Tecnico) this.lista.get(index));
        }
        
        this.perfilGeral.setVisible(true);
        this.perfilGeral.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_menuVerPerfilActionPerformed

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased
        //TODO
    	if(evt.isPopupTrigger()){
            this.jPopupMenu1.show(this, evt.getX(), evt.getY());
        }
            
        
    }//GEN-LAST:event_tableMouseReleased

    private void menuAddAnotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddAnotacaoActionPerformed
        //TODO
    	Empregado emp;
        int index = this.table.getSelectedRow();
                
        emp = this.lista.get(index);
        
        this.addNotes = new AddNotesFrame(this, emp);
        addNotes.setVisible(true);
        addNotes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_menuAddAnotacaoActionPerformed

    private void itemOrdenarNomeCrescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOrdenarNomeCrescActionPerformed
        //TODO
    	Collections.sort(this.lista, Empregado.getComparatorNomeCresc());
        this.atualizaLista();
    }//GEN-LAST:event_itemOrdenarNomeCrescActionPerformed

    private void itemOrdenarSalarioCrescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOrdenarSalarioCrescActionPerformed
    	//TODO
    	Collections.sort(this.lista, Empregado.getComparatorSalarioCresc());
        this.atualizaLista();
    }//GEN-LAST:event_itemOrdenarSalarioCrescActionPerformed

    private void itemOrdenarNomeDecrescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOrdenarNomeDecrescActionPerformed
        // TODO
    	Collections.sort(this.lista, Empregado.getComparatorNomeDecresc());
        this.atualizaLista();
    }//GEN-LAST:event_itemOrdenarNomeDecrescActionPerformed

    private void itemOrdenarSalarioDecrescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOrdenarSalarioDecrescActionPerformed
        // TODO
    	Collections.sort(this.lista, Empregado.getComparatorSalariodecresc());
        this.atualizaLista();
    }//GEN-LAST:event_itemOrdenarSalarioDecrescActionPerformed

    private void menuExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExcluirActionPerformed
        // TODO
    	int index = this.table.getSelectedRow();
    	this.lista.remove(index);
    	this.atualizaLista();
    }//GEN-LAST:event_menuExcluirActionPerformed

    private void menuEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarActionPerformed
        //TODO
    	
        this.editFrame = new EditFrame(this, this.table.getSelectedRow());
        editFrame.setVisible(true);
        editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }//GEN-LAST:event_menuEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaFrame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JMenuItem itemEngenheiro;
    private javax.swing.JMenuItem itemEnsino;
    private javax.swing.JMenuItem itemLegal;
    private javax.swing.JMenuItem itemOrdenarNomeCresc;
    private javax.swing.JMenuItem itemOrdenarNomeDecresc;
    private javax.swing.JMenuItem itemOrdenarSalarioCresc;
    private javax.swing.JMenuItem itemOrdenarSalarioDecresc;
    private javax.swing.JMenuItem itemRelatorioGeral;
    private javax.swing.JMenuItem itemRelatorioPorClasse;
    private javax.swing.JMenuItem itemRh;
    private javax.swing.JMenuItem itemSemSuperior;
    private javax.swing.JMenuItem itemSobre;
    private javax.swing.JMenuItem itemTecnico;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuAddAnotacao;
    private javax.swing.JMenu menuAdicionar;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenuItem menuEditar;
    private javax.swing.JMenuItem menuExcluir;
    private javax.swing.JMenu menuGerar;
    private javax.swing.JMenu menuOrdenar;
    private javax.swing.JMenuItem menuVerPerfil;
    private javax.swing.JTable table;
    // End of variables declaration     
}
