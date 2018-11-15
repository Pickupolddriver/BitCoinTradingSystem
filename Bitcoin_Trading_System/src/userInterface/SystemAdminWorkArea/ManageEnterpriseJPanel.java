/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Blockchain.searchNewestBlockAPI;

/**
 *
 * @author lijianxi
 */
public class ManageEnterpriseJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageEnterpriseJPanel
     */
    private JPanel processPanel;
    private EcoSystem business;

    public ManageEnterpriseJPanel(JPanel processPanel, EcoSystem business) {
        initComponents();
        this.processPanel = processPanel;
        this.business = business;
        refreshTbl();
        populateComboBox();
    }

    public void refreshTbl() {
        int rowCount = TblEnterprise.getRowCount();
        DefaultTableModel model = (DefaultTableModel) TblEnterprise.getModel();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        //System.out.print("OK");
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                Object row[] = new Object[4];
                row[0] = e.getName();
                row[1] = e.getenterpriseId();
                row[2] = n.getName();
                row[3] = e.getEnterpriseType();
                model.addRow(row);
            }
        }
    }

    public void populateComboBox() {
        CmbNework.removeAllItems();
        CmbEnterpriseType.removeAllItems();
        for (Network n : business.getNetworkList()) {
            CmbNework.addItem(n);
        }
        for (Enterprise.EnterpriseType type : Enterprise.EnterpriseType.values()) {
            CmbEnterpriseType.addItem(type);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CmbEnterpriseType = new javax.swing.JComboBox();
        BtnSubmit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblEnterprise = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        CmbNework = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        BtnBack = new javax.swing.JButton();

        jLabel3.setText("Enterprise Type");

        CmbEnterpriseType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        BtnSubmit.setText("Submit");
        BtnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSubmitActionPerformed(evt);
            }
        });

        TblEnterprise.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enterprise Name", "EntID", "Network", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TblEnterprise);

        jLabel1.setText("Network");

        CmbNework.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbNework.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbNeworkActionPerformed(evt);
            }
        });

        jLabel2.setText("Name");

        BtnBack.setText("Back");
        BtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CmbEnterpriseType, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CmbNework, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(BtnBack)
                        .addGap(69, 69, 69)
                        .addComponent(BtnSubmit)))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CmbNework, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CmbEnterpriseType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnBack)
                    .addComponent(BtnSubmit))
                .addGap(44, 44, 44))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSubmitActionPerformed
        for (Network n : business.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (e.getName().equals(txtName.getText())) {
                    JOptionPane.showMessageDialog(null, "Enterprise already existed");
                }
            }
        }
        Network n = (Network) CmbNework.getSelectedItem();
        Enterprise.EnterpriseType type = (Enterprise.EnterpriseType) CmbEnterpriseType.getSelectedItem();
        if (n == null || type == null) {
            JOptionPane.showMessageDialog(null, "Invalid combobox selection");
        }
        Enterprise e = n.getEnterpriseDirectory().createAndAddEnterprise(txtName.getText(), type);
        e.getWallet().setBlockChaine(searchNewestBlockAPI.searchNewestBlock(business));
        refreshTbl();
        txtName.setText("");
    }//GEN-LAST:event_BtnSubmitActionPerformed

    private void BtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBackActionPerformed
        // TODO add your handling code here:
        processPanel.remove(this);
        Component[] componentArray = processPanel.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel buyerPanel = (SystemAdminWorkAreaJPanel) component;
        CardLayout layout = (CardLayout) processPanel.getLayout();
        layout.previous(processPanel);
    }//GEN-LAST:event_BtnBackActionPerformed

    private void CmbNeworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbNeworkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbNeworkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBack;
    private javax.swing.JButton BtnSubmit;
    private javax.swing.JComboBox CmbEnterpriseType;
    private javax.swing.JComboBox CmbNework;
    private javax.swing.JTable TblEnterprise;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

}