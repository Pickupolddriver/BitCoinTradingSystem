/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.SystemAdminWorkArea;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author lijianxi
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    private JPanel processPanel;
    private EcoSystem business;
    private DB4OUtil dB4OUtil;
    public SystemAdminWorkAreaJPanel(JPanel processPanel, EcoSystem business, DB4OUtil dB4OUtil) {
        initComponents();
        this.processPanel = processPanel;
        this.business = business;
        this.dB4OUtil = dB4OUtil;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BtnEnterpriseAdmin = new javax.swing.JButton();
        BtnManageEnterprise = new javax.swing.JButton();
        BtnManageNetwork = new javax.swing.JButton();
        BtnLogout = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("My Work Area - System Admin Role");

        BtnEnterpriseAdmin.setText("Manage Enterprise Admin");
        BtnEnterpriseAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnterpriseAdminActionPerformed(evt);
            }
        });

        BtnManageEnterprise.setText("Manage Enterprise");
        BtnManageEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnManageEnterpriseActionPerformed(evt);
            }
        });

        BtnManageNetwork.setText("Manage Network");
        BtnManageNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnManageNetworkActionPerformed(evt);
            }
        });

        BtnLogout.setText("Log out");
        BtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnEnterpriseAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(BtnManageEnterprise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnManageNetwork, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(480, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 239, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 239, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(329, Short.MAX_VALUE)
                .addComponent(BtnManageNetwork)
                .addGap(21, 21, 21)
                .addComponent(BtnManageEnterprise)
                .addGap(21, 21, 21)
                .addComponent(BtnEnterpriseAdmin)
                .addGap(18, 18, 18)
                .addComponent(BtnLogout)
                .addGap(95, 95, 95))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 196, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 375, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEnterpriseAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnterpriseAdminActionPerformed
        ManageEnterpriseAdminJPanel meajp = new ManageEnterpriseAdminJPanel(processPanel, business);
        processPanel.add("ManageEnterpriseAdminJPanel", meajp);
        CardLayout card = (CardLayout)processPanel.getLayout();
        card.next(processPanel);
    }//GEN-LAST:event_BtnEnterpriseAdminActionPerformed

    private void BtnManageEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnManageEnterpriseActionPerformed
        ManageEnterpriseJPanel mejp = new ManageEnterpriseJPanel(processPanel, business);
        processPanel.add("ManageEnterpriseJPanel", mejp);
        CardLayout card = (CardLayout)processPanel.getLayout();
        card.next(processPanel);
    }//GEN-LAST:event_BtnManageEnterpriseActionPerformed

    private void BtnManageNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnManageNetworkActionPerformed
        ManageNetworkJPanel mnjp = new ManageNetworkJPanel(processPanel, business);
        processPanel.add("ManageNetworkJPanel", mnjp);
        CardLayout card = (CardLayout)processPanel.getLayout();
        card.next(processPanel);
        
    }//GEN-LAST:event_BtnManageNetworkActionPerformed

    private void BtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogoutActionPerformed
        // TODO add your handling code here:       
        processPanel.remove(this);
        Component[] componentArray = processPanel.getComponents();
        Component comp = componentArray[componentArray.length - 1];
        JPanel firstPagepanel = (JPanel) comp;
        CardLayout card = (CardLayout) processPanel.getLayout();
        card.previous(processPanel);
        dB4OUtil.storeSystem(business);
    }//GEN-LAST:event_BtnLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEnterpriseAdmin;
    private javax.swing.JButton BtnLogout;
    private javax.swing.JButton BtnManageEnterprise;
    private javax.swing.JButton BtnManageNetwork;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}