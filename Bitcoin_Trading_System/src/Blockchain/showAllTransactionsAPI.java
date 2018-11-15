/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blockchain;

import Business.EcoSystem;
import Business.Network.Network;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raywa
 */
public interface showAllTransactionsAPI extends searchNewestBlockAPI {

    public static void showAllTransaction(JTable tbl, EcoSystem business) {
        tbl.setVisible(true);
        int rowCount = tbl.getRowCount();
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (Network n : business.getNetworkList()) {
            BlockChain bc = searchNewestBlockAPI.searchNewestBlock(business);
            System.out.println(bc.getHm());
            for (Block b : bc.getHm().values()) {
                for (Transaction trans : b.getBody().getTransactions()) {
                    Object row[] = new Object[4];
                    row[0] = trans.getFrom();
                    row[1] = trans.getTo();
                    row[2] = trans.getBtcAmount();
                    row[3] = trans.getTransactionDate();
                    model.addRow(row);
                }
            }
        }
    }
    
}
