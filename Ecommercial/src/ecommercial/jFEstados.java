/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jFEstados.java
 *
 * Created on 19/05/2012, 00:10:46
 */

package ecommercial;

import ecommercial.Classes.ClassConecta;
import ecommercial.Classes.ComboItem;
import ecommercial.Classes.Estados;
import ecommercial.Classes.Funcoes;
import ecommercial.Classes.Paises;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luciano Carrafa Benfica
 */
public class jFEstados extends javax.swing.JDialog {

    /** Creates new form jFEstados */
    public jFEstados() {
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
        salvarMaisjButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        alterarjButton = new javax.swing.JButton();
        excluirjButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        sairjButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        estadojTextField = new javax.swing.JTextField();
        siglajTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        paisesjComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        atualizarPaisjButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gradeEstadosjTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(ecommercial.EcommercialApp.class).getContext().getResourceMap(jFEstados.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setBackground(resourceMap.getColor("jToolBar1.background")); // NOI18N
        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

        buscarjButton.setBackground(resourceMap.getColor("buscarjButton.background")); // NOI18N
        buscarjButton.setIcon(resourceMap.getIcon("buscarjButton.icon")); // NOI18N
        buscarjButton.setText(resourceMap.getString("buscarjButton.text")); // NOI18N
        buscarjButton.setFocusable(false);
        buscarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buscarjButton.setName("buscarjButton"); // NOI18N
        buscarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buscarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarjButtonActionPerformed(evt);
            }
        });
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
        editarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarjButtonActionPerformed(evt);
            }
        });
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

        salvarMaisjButton.setBackground(resourceMap.getColor("salvarMaisjButton.background")); // NOI18N
        salvarMaisjButton.setIcon(resourceMap.getIcon("salvarMaisjButton.icon")); // NOI18N
        salvarMaisjButton.setText(resourceMap.getString("salvarMaisjButton.text")); // NOI18N
        salvarMaisjButton.setFocusable(false);
        salvarMaisjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salvarMaisjButton.setName("salvarMaisjButton"); // NOI18N
        salvarMaisjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        salvarMaisjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarMaisjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(salvarMaisjButton);

        jSeparator1.setName("jSeparator1"); // NOI18N
        jToolBar1.add(jSeparator1);

        alterarjButton.setBackground(resourceMap.getColor("alterarjButton.background")); // NOI18N
        alterarjButton.setIcon(resourceMap.getIcon("alterarjButton.icon")); // NOI18N
        alterarjButton.setText(resourceMap.getString("alterarjButton.text")); // NOI18N
        alterarjButton.setFocusable(false);
        alterarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alterarjButton.setName("alterarjButton"); // NOI18N
        alterarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        alterarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(alterarjButton);

        excluirjButton.setBackground(resourceMap.getColor("excluirjButton.background")); // NOI18N
        excluirjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirjButtonActionPerformed1(evt);
            }
        });
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

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jPanel2.setBackground(resourceMap.getColor("jPanel2.background")); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        estadojTextField.setText(resourceMap.getString("estadojTextField.text")); // NOI18N
        estadojTextField.setName("estadojTextField"); // NOI18N
        estadojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                estadojTextFieldKeyReleased(evt);
            }
        });

        siglajTextField.setText(resourceMap.getString("siglajTextField.text")); // NOI18N
        siglajTextField.setName("siglajTextField"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        paisesjComboBox.setName("paisesjComboBox"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jButton1.setIcon(resourceMap.getIcon("jButton1.icon")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        atualizarPaisjButton.setIcon(resourceMap.getIcon("atualizarPaisjButton.icon")); // NOI18N
        atualizarPaisjButton.setText(resourceMap.getString("atualizarPaisjButton.text")); // NOI18N
        atualizarPaisjButton.setContentAreaFilled(false);
        atualizarPaisjButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atualizarPaisjButton.setName("atualizarPaisjButton"); // NOI18N
        atualizarPaisjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarPaisjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(estadojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(siglajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(paisesjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(atualizarPaisjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(atualizarPaisjButton)
                    .addComponent(jButton1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(estadojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(siglajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paisesjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(resourceMap.getString("jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel3.setBackground(resourceMap.getColor("jPanel3.background")); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N

        jPanel4.setBackground(resourceMap.getColor("jPanel4.background")); // NOI18N
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setName("jPanel4"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        gradeEstadosjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#Id", "Estado", "Sigla", "País"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        gradeEstadosjTable.setName("gradeEstadosjTable"); // NOI18N
        gradeEstadosjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradeEstadosjTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gradeEstadosjTable);
        gradeEstadosjTable.getColumnModel().getColumn(0).setResizable(false);
        gradeEstadosjTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("gradeEstadosjTable.columnModel.title0")); // NOI18N
        gradeEstadosjTable.getColumnModel().getColumn(1).setResizable(false);
        gradeEstadosjTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("gradeEstadosjTable.columnModel.title1")); // NOI18N
        gradeEstadosjTable.getColumnModel().getColumn(2).setResizable(false);
        gradeEstadosjTable.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("gradeEstadosjTable.columnModel.title2")); // NOI18N
        gradeEstadosjTable.getColumnModel().getColumn(3).setResizable(false);
        gradeEstadosjTable.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("gradeEstadosjTable.columnModel.title3")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ClassConecta conexao = new ClassConecta();

    ComboItem comboPais;

    public Integer codEstado;


//******************************************************************************************************
    public void getGradeEstados() throws ParseException{
       //Consultar Estados
        Estados oEstado = new Estados();


        if ( estadojTextField.getText().length() > 0 ){
            oEstado.setEstado(estadojTextField.getText()+"%");
        }

        ResultSet resultSet = null;

        String[] colunasTabela = new String[]{"#Id", "Estado", "Sigla", "País"};
        DefaultTableModel modeloTabela = new DefaultTableModel(null, colunasTabela) {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        gradeEstadosjTable.setModel(modeloTabela);
        gradeEstadosjTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        gradeEstadosjTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        gradeEstadosjTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        gradeEstadosjTable.getColumnModel().getColumn(3).setPreferredWidth(100);



try {


            resultSet = oEstado.getConsultar();

            if (resultSet.getRow() == 1){
             resultSet.first();
            }


        } catch (SQLException ex) {
            Logger.getLogger(Paises.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            while (resultSet.next()) {

                modeloTabela.addRow(new String[]{
                    Funcoes.getCodigoFormat(resultSet.getInt("COD_ESTADO")),
                    resultSet.getString("ESTADO"),
                    resultSet.getString("SIGLA") ,
                    resultSet.getString("PAIS"),
                });

            }

        } catch (SQLException ex) {
            Logger.getLogger(Estados.class.getName()).log(Level.SEVERE, null, ex);
        }

           }


    public void getFieldEstado(int codTelefone) throws ParseException{

        Estados oEstado = new Estados();
        ResultSet rs = null;
        oEstado.setCod_estado(codEstado);

        try {
            rs = oEstado.getConsultar();
            rs.next();

            ComboItem oItem = new ComboItem(rs.getInt("COD_PAIS"), rs.getString("PAIS"));
            paisesjComboBox.setSelectedItem(oItem);

            //Pegar campos
            estadojTextField.setText(rs.getString("ESTADO"));
            siglajTextField.setText(rs.getString("SIGLA"));
            paisesjComboBox.setSelectedItem(rs.getString("PAIS"));

        } catch (SQLException ex) {
            Logger.getLogger(Estados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

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

    private void novojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novojButtonActionPerformed
        // TODO add your handling code here:
        novojButton.setEnabled(false);
        alterarjButton.setEnabled(false);
        editarjButton.setEnabled(false);
        excluirjButton.setEnabled(false);
        buscarjButton.setEnabled(true);
        salvarjButton.setEnabled(true);
        salvarMaisjButton.setEnabled(true);
        estadojTextField.grabFocus();
        try {
            ClassConecta.con.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(jFEstados.class.getName()).log(Level.SEVERE, null, ex);
        }
        estadojTextField.setText("");
        siglajTextField.setText("");
    }//GEN-LAST:event_novojButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        ClassConecta.conecta();

        salvarjButton.setEnabled(false);
        salvarMaisjButton.setEnabled(false);
        alterarjButton.setEnabled(false);
        excluirjButton.setEnabled(false);
        editarjButton.setEnabled(false);
        novojButton.setEnabled(true);
        estadojTextField.grabFocus();

        atualizarPaisjButtonActionPerformed(null);
        try {
            getGradeEstados();
        } catch (ParseException ex) {
            Logger.getLogger(jFEstados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void salvarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarjButtonActionPerformed
        // TODO add your handling code here:
            salvarjButton.setEnabled(false);
            salvarMaisjButton.setEnabled(false);
            alterarjButton.setEnabled(false);
            excluirjButton.setEnabled(false);
            novojButton.setEnabled(true);
            editarjButton.setEnabled(true);

            comboPais = (ComboItem) paisesjComboBox.getSelectedItem();

            Estados oEstado = new Estados();

            if (estadojTextField.getText().equals("")){

                JOptionPane.showMessageDialog(null, "O campo ESTADO é obrigatório", "ATENÇÃO Mensagem do Sistema", JOptionPane.INFORMATION_MESSAGE);
                novojButtonActionPerformed(null);
            }else if (siglajTextField.getText().equals("")){

                JOptionPane.showMessageDialog(null, "O campo SIGLA é obrigatório", "ATENÇÃO Mensagem do Sistema", JOptionPane.INFORMATION_MESSAGE);
                novojButtonActionPerformed(null);
            }else{

                oEstado.setEstado(estadojTextField.getText().trim().toUpperCase());
                oEstado.setSigla(siglajTextField.getText().trim().toUpperCase());
                oEstado.setCod_pais(comboPais.getId());
                oEstado.setCadastrar();
            try {
                ClassConecta.con.commit();
                ClassConecta.con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(jFEstados.class.getName()).log(Level.SEVERE, null, ex);
            }

            }
        try {
            getGradeEstados();
        } catch (ParseException ex) {
            Logger.getLogger(jFEstados.class.getName()).log(Level.SEVERE, null, ex);
        }



    }//GEN-LAST:event_salvarjButtonActionPerformed

    private void atualizarPaisjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarPaisjButtonActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Paises oPais = new Paises();
            ResultSet rs = null;
            rs = oPais.getConsultar();
            paisesjComboBox.removeAllItems();
            while (rs.next()) {
                paisesjComboBox.addItem(new ComboItem(rs.getInt(1), rs.getString(2)));
            }
            paisesjComboBox.updateUI();
        } catch (SQLException ex) {
            Logger.getLogger(jFPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_atualizarPaisjButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jFPaises oFormPais = new jFPaises();

        oFormPais.setTitle("Cadastro de Países");
        oFormPais.pack();
        oFormPais.setLocationRelativeTo(null);
        oFormPais.setModal(true);
        oFormPais.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buscarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarjButtonActionPerformed
        try {
            // TODO add your handling code here:
            getGradeEstados();
        } catch (ParseException ex) {
            Logger.getLogger(jFEstados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarjButtonActionPerformed

    private void salvarMaisjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarMaisjButtonActionPerformed
        // TODO add your handling code here:
        salvarjButtonActionPerformed(null);
        novojButtonActionPerformed(null);
    }//GEN-LAST:event_salvarMaisjButtonActionPerformed

    private void gradeEstadosjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeEstadosjTableMouseClicked
        // TODO add your handling code here:
        editarjButton.setEnabled(true);
            codEstado = Integer.parseInt(gradeEstadosjTable.getValueAt(gradeEstadosjTable.getSelectedRow(), 0).toString());
            if (codEstado == 0) {
                return;
            }
        try {
            getFieldEstado(codEstado);
        } catch (ParseException ex) {
            Logger.getLogger(jFPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gradeEstadosjTableMouseClicked

    private void estadojTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_estadojTextFieldKeyReleased
        // TODO add your handling code here:
        if (!alterarjButton.isEnabled()){
            try {
                Estados oEstado = new Estados();
                oEstado.setEstado(estadojTextField.getText());
                ResultSet rs = null;
                rs = oEstado.getConsultar();
                getGradeEstados();
            } catch (ParseException ex) {
                Logger.getLogger(jFPessoas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(jFPessoas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (estadojTextField.getText().equals("")){
            estadojTextField.setText("");
            siglajTextField.setText("");
            editarjButton.setEnabled(false);
        }
    }//GEN-LAST:event_estadojTextFieldKeyReleased

    private void alterarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarjButtonActionPerformed
        // TODO add your handling code here:
        alterarjButton.setEnabled(false);
        editarjButton.setEnabled(true);
        excluirjButton.setEnabled(false);
        novojButton.setEnabled(true);

        comboPais = (ComboItem) paisesjComboBox.getSelectedItem();
        @SuppressWarnings("LocalVariableHidesMemberVariable")

        Estados oEstado = new Estados();
        oEstado.setCod_estado(codEstado);

        oEstado.setEstado(estadojTextField.getText().trim().toUpperCase());
        oEstado.setSigla(siglajTextField.getText());
        oEstado.setCod_pais(comboPais.getId());

        oEstado.setAlterar(conexao);
        try {
            ClassConecta.con.commit();
            ClassConecta.con.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(jFEstados.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            getGradeEstados();
        } catch (ParseException ex) {
            Logger.getLogger(jFPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_alterarjButtonActionPerformed

    private void editarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarjButtonActionPerformed
        // TODO add your handling code here:
            novojButton.setEnabled(false);
            salvarjButton.setEnabled(false);
            salvarMaisjButton.setEnabled(false);
            editarjButton.setEnabled(false);
            alterarjButton.setEnabled(true);
            excluirjButton.setEnabled(true);
        try {
            ClassConecta.con.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(jFPessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editarjButtonActionPerformed

    private void excluirjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirjButtonActionPerformed
        // TODO add your handling code here:
        Object[] options = {"Sim", "Não"};
        int sd =
                JOptionPane.showOptionDialog(null, "Deseja realmente EXCLUIR esse registro?", "Confirmação do Sistema!", JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE, null, options, options[0]);

        if (sd != 0) {
            return;
        }
        alterarjButton.setEnabled(false);
        editarjButton.setEnabled(true);
        excluirjButton.setEnabled(false);
        novojButton.setEnabled(true);

        Estados oEstado = new Estados();
        oEstado.setCod_estado(codEstado);

        oEstado.setExcluir(conexao);
        try {
            ClassConecta.con.commit();
            ClassConecta.con.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(jFPaises.class.getName()).log(Level.SEVERE, null, ex);
        }

            estadojTextField.setText("");
            siglajTextField.setText("");
        try {
            getGradeEstados();
        } catch (ParseException ex) {
            Logger.getLogger(jFPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_excluirjButtonActionPerformed

    private void excluirjButtonActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirjButtonActionPerformed1
        // TODO add your handling code here:
        Object[] options = {"Sim", "Não"};
        int sd =
                JOptionPane.showOptionDialog(null, "Deseja realmente EXCLUIR esse registro?", "Confirmação!", JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE, null, options, options[0]);

        if (sd != 0) {
            return;
        }
        alterarjButton.setEnabled(false);
        editarjButton.setEnabled(true);
        excluirjButton.setEnabled(false);
        novojButton.setEnabled(true);

        Estados oEstado = new Estados();
        oEstado.setCod_estado(codEstado);

        oEstado.setExcluir(conexao);
        try {
            ClassConecta.con.commit();
            ClassConecta.con.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(jFPaises.class.getName()).log(Level.SEVERE, null, ex);
        }

        estadojTextField.setText("");
        siglajTextField.setText("");
        atualizarPaisjButtonActionPerformed(null);
        try {
            getGradeEstados();
        } catch (ParseException ex) {
            Logger.getLogger(jFPaises.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_excluirjButtonActionPerformed1

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFEstados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarjButton;
    private javax.swing.JButton atualizarPaisjButton;
    private javax.swing.JButton buscarjButton;
    private javax.swing.JButton editarjButton;
    private javax.swing.JTextField estadojTextField;
    private javax.swing.JButton excluirjButton;
    private javax.swing.JTable gradeEstadosjTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton novojButton;
    private javax.swing.JComboBox paisesjComboBox;
    private javax.swing.JButton sairjButton;
    private javax.swing.JButton salvarMaisjButton;
    private javax.swing.JButton salvarjButton;
    private javax.swing.JTextField siglajTextField;
    // End of variables declaration//GEN-END:variables

}
