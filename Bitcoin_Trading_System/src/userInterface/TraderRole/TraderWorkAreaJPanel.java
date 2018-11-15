/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.TraderRole;

import Blockchain.updateBlockChainAPI;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Blockchain.searchNewestBlockAPI;
import static Blockchain.updateBlockChainAPI.updateBlockchain;

/**
 *
 * @author Administrator
 */
public class TraderWorkAreaJPanel extends javax.swing.JPanel implements updateBlockChainAPI, searchNewestBlockAPI {

    /**
     * Creates new form tradeLoginJpanel
     */
    private JPanel processPanel;
    private EcoSystem business;
    private DB4OUtil dB4OUtil;
    private UserAccount useraccount;
    private Enterprise enterprise;

    public TraderWorkAreaJPanel(JPanel processPanel, EcoSystem business, DB4OUtil dB4OUtil, UserAccount u, Enterprise e) {
        initComponents();
        this.processPanel = processPanel;
        this.business = business;
        this.dB4OUtil = dB4OUtil;
        this.useraccount = u;
        this.enterprise = e;
        e.getWallet().setBlockChaine(searchNewestBlockAPI.searchNewestBlock(business));
        //updateBlockChainAPI.updateBlockchain(business, e);
        populateTbl();
        blockChainUpdate();
//To change body of generated methods, choose Tools | Templates.
    }
      public void blockChainUpdate(){
       updateBlockchain(business,enterprise);   
    }

    public void populateTbl() {
        DefaultTableModel model = (DefaultTableModel) tblTraderWR.getModel();
        model.setRowCount(0);
        for (WorkRequest wr : business.getWorkQueue().getWorkRequestList()) {
              txtBitcoin.setText("Your amount:"+enterprise.getWallet().refreshCount());
//            System.out.println("test");
//            System.out.println("wr: " + wr);
//            //Transaction
//            System.out.println("wr.getT(): " + wr.getT());
//            System.out.println("wr.getStatus(): " + wr.getStatus());
//            System.out.println("wr.getT().getFrom(): " + wr.getT().getFrom());
//            //Enterprise
//            System.out.println("e: " + enterprise);
            if ((wr.getStatus().equals("Coin Requested") && (wr.getT().getFrom() == enterprise.getenterpriseId()))
                    || (wr.getStatus().equals("Coin Requested") && (wr.getT().getTo() == enterprise.getenterpriseId()))
                    || (wr.getStatus().equals("Withdraw Confirm needed") && (wr.getT().getFrom() == enterprise.getenterpriseId()))
                    || (wr.getStatus().equals("Cash Transaction started") && (wr.getT().getTo() == enterprise.getenterpriseId()))
                    || (wr.getStatus().equals("Declined") && (wr.getT().getFrom() == enterprise.getenterpriseId()))
                    || (wr.getStatus().equals("P2P Comfirmed") && (wr.getT().getFrom() == enterprise.getenterpriseId()))
                    || (wr.getStatus().equals("P2P Comfirmed") && (wr.getT().getTo() == enterprise.getenterpriseId()))
                    || (wr.getStatus().equals("Withdraw approved") && (wr.getT().getFrom() == enterprise.getenterpriseId()))
                    || (wr.getStatus().equals("Cash Transaction completed") && (wr.getT().getFrom() == enterprise.getenterpriseId()))
                    || (wr.getStatus().equals("P2P Confirm Needed") && (wr.getT().getFrom() == enterprise.getenterpriseId()))
                    || (wr.getStatus().equals("P2P Confirm Needed") && (wr.getT().getTo() == enterprise.getenterpriseId()))) {
                Object[] row = new Object[4];
                row[0] = wr;
                row[1] = wr.getT().getTo();
                row[2] = wr.getT().getBtcAmount();
                row[3] = wr.getStatus();
                model.addRow(row);
            }
            else {

            }
        }
        // remove the confirmed transaction once they are dispalyed
/*
        for (WorkRequest wr : business.getWorkQueue().getWorkRequestList()) {
            if ((wr.getStatus().equals("Declined") && (wr.getT().getFrom() == e.getenterpriseId()))
                    || (wr.getStatus().equals("P2P Comfirmed") && (wr.getT().getFrom() == e.getenterpriseId()))
                    || (wr.getStatus().equals("P2P Comfirmed") && (wr.getT().getTo() == e.getenterpriseId()))
                    || (wr.getStatus().equals("Withdraw approved") && (wr.getT().getFrom() == e.getenterpriseId()))
                    || (wr.getStatus().equals("Cash Transaction completed") && (wr.getT().getFrom() == e.getenterpriseId()))) {
                business.getWorkQueue().getWorkRequestList().remove(wr);
            }
        }
         */

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        BtnAllTransactin = new javax.swing.JButton();
        BtnRequest = new javax.swing.JButton();
        BtnCashTransaction = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTraderWR = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        BtnSend = new javax.swing.JButton();
        BtnDecline = new javax.swing.JButton();
        BtnApprove = new javax.swing.JButton();
        txtBitcoin = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(900, 556));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("My Work Area(Trader) -Wecomle! ");

        BtnAllTransactin.setText("All Transactions");
        BtnAllTransactin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAllTransactinActionPerformed(evt);
            }
        });

        BtnRequest.setText("Create Request");
        BtnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRequestActionPerformed(evt);
            }
        });

        BtnCashTransaction.setText("Cash Transaction");
        BtnCashTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCashTransactionActionPerformed(evt);
            }
        });

        tblTraderWR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "From", "To", "Amount", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblTraderWR);

        jButton1.setText("Log out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BtnSend.setText("Start Sending");
        BtnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSendActionPerformed(evt);
            }
        });

        BtnDecline.setText("Decline");
        BtnDecline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeclineActionPerformed(evt);
            }
        });

        BtnApprove.setText("Approve");
        BtnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnApproveActionPerformed(evt);
            }
        });

        txtBitcoin.setText("Your coin:");
        txtBitcoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBitcoinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnDecline)
                        .addGap(302, 302, 302)
                        .addComponent(BtnApprove))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnSend)
                        .addGap(221, 221, 221)
                        .addComponent(BtnAllTransactin))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnRequest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnCashTransaction)))
                .addGap(0, 379, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBitcoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnApprove)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnDecline)
                        .addComponent(txtBitcoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnRequest)
                    .addComponent(BtnCashTransaction))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSend)
                    .addComponent(BtnAllTransactin))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(143, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAllTransactinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllTransactinActionPerformed
        allTransactionJPanel atjp = new allTransactionJPanel(processPanel, business, enterprise);
        processPanel.add("allTransactionJPanel", atjp);
        CardLayout card = (CardLayout) processPanel.getLayout();
        card.next(processPanel);
    }//GEN-LAST:event_BtnAllTransactinActionPerformed

    private void BtnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRequestActionPerformed
        RequestJPanel rjp = new RequestJPanel(processPanel, business, enterprise);
        processPanel.add("RequestJPanel", rjp);
        CardLayout card = (CardLayout) processPanel.getLayout();
        card.next(processPanel);
    }//GEN-LAST:event_BtnRequestActionPerformed

    private void BtnCashTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCashTransactionActionPerformed
        CashTransactionJPanel ctjp = new CashTransactionJPanel(processPanel, business, enterprise);
        processPanel.add("CashTransactionJPanel", ctjp);
        CardLayout card = (CardLayout) processPanel.getLayout();
        card.next(processPanel);
    }//GEN-LAST:event_BtnCashTransactionActionPerformed

    private void BtnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSendActionPerformed
        sendJPanel rjp = new sendJPanel(processPanel, business, enterprise);
        processPanel.add("sendJPanel", rjp);
        CardLayout card = (CardLayout) processPanel.getLayout();
        card.next(processPanel);        // TODO add your handling code here:
    }//GEN-LAST:event_BtnSendActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        processPanel.remove(this);
        Component[] componentArray = processPanel.getComponents();
        Component comp = componentArray[componentArray.length - 1];
        JPanel firstPagepanel = (JPanel) comp;
        CardLayout card = (CardLayout) processPanel.getLayout();
        card.previous(processPanel);
        dB4OUtil.storeSystem(business);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnDeclineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeclineActionPerformed

        int index = tblTraderWR.getSelectedRow();
        if (index >= 0) {
            WorkRequest wr = (WorkRequest) tblTraderWR.getValueAt(index, 0);
            if((wr.getStatus().equals("Coin Requested"))&&((wr.getT().getFrom()==enterprise.getenterpriseId()))){
           
            wr.setStatus("Declined");
            JOptionPane.showMessageDialog(null, "You have declined the request!");
            populateTbl();
        }else{
                JOptionPane.showMessageDialog(null, "No need to do anything");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "You need to select an Item!");
        }              // TODO add your handling code here:
    }//GEN-LAST:event_BtnDeclineActionPerformed

    private void BtnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnApproveActionPerformed
        int index = tblTraderWR.getSelectedRow();
        if (index >= 0) {
            WorkRequest a = (WorkRequest) tblTraderWR.getValueAt(index, 0);
            if(a.getStatus().equals("Coin Requested")&&((a.getT().getFrom()==enterprise.getenterpriseId()))){
                
            a.setStatus("P2P Confirm Needed");
            JOptionPane.showMessageDialog(null, "The transation is waiting to be confirmed!");
            populateTbl();
        }
            else{
                    JOptionPane.showMessageDialog(null, "No need to do anything");
            }
        }else {
            JOptionPane.showMessageDialog(null, "You need to select an Item!");
        }
    }//GEN-LAST:event_BtnApproveActionPerformed

    private void txtBitcoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBitcoinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBitcoinActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAllTransactin;
    private javax.swing.JButton BtnApprove;
    private javax.swing.JButton BtnCashTransaction;
    private javax.swing.JButton BtnDecline;
    private javax.swing.JButton BtnRequest;
    private javax.swing.JButton BtnSend;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTraderWR;
    private javax.swing.JTextField txtBitcoin;
    // End of variables declaration//GEN-END:variables
}
