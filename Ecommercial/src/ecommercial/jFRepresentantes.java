/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jFRepresentantes.java
 *
 * Created on 10/08/2012, 01:38:55
 */

package ecommercial;

import ecommercial.Classes.ClassConecta;
import ecommercial.Classes.Funcoes;
import ecommercial.Classes.Representantes;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vitiazze
 */
public class jFRepresentantes extends javax.swing.JFrame {

    /** Creates new form jFRepresentantes */
    public jFRepresentantes() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        buscarjButton = new javax.swing.JButton();
        novojButton = new javax.swing.JButton();
        editarjButton = new javax.swing.JButton();
        salvarjButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        alterarjButton = new javax.swing.JButton();
        excluirjButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        sairjButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        situacaojComboBox = new javax.swing.JComboBox();
        comissionadojComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        datAberturajFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        aliqComissaojTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setName("Form"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(ecommercial.EcommercialApp.class).getContext().getResourceMap(jFRepresentantes.class);
        jToolBar1.setBackground(resourceMap.getColor("jToolBar1.background")); // NOI18N
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

        buscarjButton.setBackground(resourceMap.getColor("buscarjButton.background")); // NOI18N
        buscarjButton.setIcon(resourceMap.getIcon("buscarjButton.icon")); // NOI18N
        buscarjButton.setText(resourceMap.getString("buscarjButton.text")); // NOI18N
        buscarjButton.setFocusable(false);
        buscarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buscarjButton.setName("buscarjButton"); // NOI18N
        buscarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(buscarjButton);

        novojButton.setBackground(resourceMap.getColor("novojButton.background")); // NOI18N
        novojButton.setIcon(resourceMap.getIcon("novojButton.icon")); // NOI18N
        novojButton.setText(resourceMap.getString("novojButton.text")); // NOI18N
        novojButton.setFocusable(false);
        novojButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        novojButton.setName("novojButton"); // NOI18N
        novojButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        novojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novojButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(novojButton);

        editarjButton.setBackground(resourceMap.getColor("editarjButton.background")); // NOI18N
        editarjButton.setIcon(resourceMap.getIcon("editarjButton.icon")); // NOI18N
        editarjButton.setText(resourceMap.getString("editarjButton.text")); // NOI18N
        editarjButton.setFocusable(false);
        editarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editarjButton.setName("editarjButton"); // NOI18N
        editarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(editarjButton);

        salvarjButton.setBackground(resourceMap.getColor("salvarjButton.background")); // NOI18N
        salvarjButton.setIcon(resourceMap.getIcon("salvarjButton.icon")); // NOI18N
        salvarjButton.setText(resourceMap.getString("salvarjButton.text")); // NOI18N
        salvarjButton.setFocusable(false);
        salvarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salvarjButton.setName("salvarjButton"); // NOI18N
        salvarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        salvarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(salvarjButton);

        jSeparator1.setName("jSeparator1"); // NOI18N
        jToolBar1.add(jSeparator1);

        alterarjButton.setBackground(resourceMap.getColor("alterarjButton.background")); // NOI18N
        alterarjButton.setIcon(resourceMap.getIcon("alterarjButton.icon")); // NOI18N
        alterarjButton.setText(resourceMap.getString("alterarjButton.text")); // NOI18N
        alterarjButton.setFocusable(false);
        alterarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alterarjButton.setName("alterarjButton"); // NOI18N
        alterarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(alterarjButton);

        excluirjButton.setBackground(resourceMap.getColor("excluirjButton.background")); // NOI18N
        excluirjButton.setIcon(resourceMap.getIcon("excluirjButton.icon")); // NOI18N
        excluirjButton.setText(resourceMap.getString("excluirjButton.text")); // NOI18N
        excluirjButton.setFocusable(false);
        excluirjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        excluirjButton.setName("excluirjButton"); // NOI18N
        excluirjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(excluirjButton);

        jSeparator2.setName("jSeparator2"); // NOI18N
        jToolBar1.add(jSeparator2);

        sairjButton.setBackground(resourceMap.getColor("sairjButton.background")); // NOI18N
        sairjButton.setIcon(resourceMap.getIcon("sairjButton.icon")); // NOI18N
        sairjButton.setText(resourceMap.getString("sairjButton.text")); // NOI18N
        sairjButton.setFocusable(false);
        sairjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sairjButton.setName("sairjButton"); // NOI18N
        sairjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sairjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(sairjButton);

        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jPanel4.setBackground(resourceMap.getColor("jPanel4.background")); // NOI18N
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel4.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), resourceMap.getColor("jPanel4.border.titleColor"))); // NOI18N
        jPanel4.setName("jPanel4"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("jTable1.columnModel.title0")); // NOI18N
        jTable1.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("jTable1.columnModel.title1")); // NOI18N
        jTable1.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("jTable1.columnModel.title2")); // NOI18N
        jTable1.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("jTable1.columnModel.title3")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setFont(resourceMap.getFont("jTabbedPane1.font")); // NOI18N
        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jPanel2.setBackground(resourceMap.getColor("jPanel2.background")); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        situacaojComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ATIVO", "INATIVO" }));
        situacaojComboBox.setName("situacaojComboBox"); // NOI18N

        comissionadojComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SIM", "NÃO" }));
        comissionadojComboBox.setName("comissionadojComboBox"); // NOI18N

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setForeground(resourceMap.getColor("jLabel2.foreground")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        datAberturajFormattedTextField.setFormatterFactory(Funcoes.setFormatoData());
        datAberturajFormattedTextField.setText(resourceMap.getString("datAberturajFormattedTextField.text")); // NOI18N
        datAberturajFormattedTextField.setName("datAberturajFormattedTextField"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        aliqComissaojTextField.setText(resourceMap.getString("aliqComissaojTextField.text")); // NOI18N
        aliqComissaojTextField.setName("aliqComissaojTextField"); // NOI18N

        jPanel3.setBackground(resourceMap.getColor("jPanel3.background")); // NOI18N
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel3.border.title"))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setName("jTextArea1"); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(situacaojComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 117, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(comissionadojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datAberturajFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(aliqComissaojTextField)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comissionadojComboBox, situacaojComboBox});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(situacaojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comissionadojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datAberturajFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aliqComissaojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(resourceMap.getString("jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ClassConecta conexao = new ClassConecta();




    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

        ClassConecta.conecta();
        try {
            datAberturajFormattedTextField.setText(Funcoes.getNowBR());
        } catch (ParseException ex) {
            Logger.getLogger(jFRepresentantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void sairjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairjButtonActionPerformed
        // TODO add your handling code here:
        if (!novojButton.isEnabled()){
                Object[] options = {"Sim", "Não"};
                int sd = JOptionPane.showOptionDialog(null, "Deseja realmente SAIR?", "Confirmação do Sistema!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                if (sd != 0) {
                    return;
                }

                this.dispose();

            }else{

                this.dispose();

            }
    }//GEN-LAST:event_sairjButtonActionPerformed

    private void salvarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarjButtonActionPerformed
        // TODO add your handling code here:
        Representantes oRepresentante = new Representantes();

        

        oRepresentante.setSituacao(situacaojComboBox.getSelectedItem().toString());
        oRepresentante.setComissionado(comissionadojComboBox.getSelectedItem().toString());

    }//GEN-LAST:event_salvarjButtonActionPerformed

    private void novojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novojButtonActionPerformed
        // TODO add your handling code here:
        novojButton.setEnabled(false);
        alterarjButton.setEnabled(false);
        editarjButton.setEnabled(false);
        excluirjButton.setEnabled(false);
        buscarjButton.setEnabled(true);
        salvarjButton.setEnabled(true);
        try {
            ClassConecta.con.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(jFEstados.class.getName()).log(Level.SEVERE, null, ex);
        }
        situacaojComboBox.setSelectedItem("ATIVO");
        comissionadojComboBox.setSelectedItem("SIM");
        aliqComissaojTextField.setText("");
        datAberturajFormattedTextField.setText("");
        
    }//GEN-LAST:event_novojButtonActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFRepresentantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aliqComissaojTextField;
    private javax.swing.JButton alterarjButton;
    private javax.swing.JButton buscarjButton;
    private javax.swing.JComboBox comissionadojComboBox;
    private javax.swing.JFormattedTextField datAberturajFormattedTextField;
    private javax.swing.JButton editarjButton;
    private javax.swing.JButton excluirjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton novojButton;
    private javax.swing.JButton sairjButton;
    private javax.swing.JButton salvarjButton;
    private javax.swing.JComboBox situacaojComboBox;
    // End of variables declaration//GEN-END:variables

}
