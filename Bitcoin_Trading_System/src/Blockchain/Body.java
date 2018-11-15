/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blockchain;

import Business.Enterprise.Enterprise;
import Business.Organizaiton.MinerOrganization;
import java.util.ArrayList;

/**
 *
 * @author lijianxi
 */
public class Body {
    private int amount;
    private ArrayList<Transaction> transactions;
    private int bodyHashcode;

    public int getBodyHashcode() {
        return bodyHashcode;
    }

    public void setBodyHashcode(int bodyHashcode) {
        this.bodyHashcode = bodyHashcode;
    }

   public void refreshBodyHashcode(){
      bodyHashcode=0;
       for(Transaction x:this.transactions){
           int tranhashcode=x.getTranHashcode();
           bodyHashcode=bodyHashcode+tranhashcode;
       }
      
   }
    
    

    public Body(){
        this.transactions=new ArrayList<Transaction>();
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
    public void addTransaction(Transaction trans,Enterprise minerOrg){
        this.transactions.add(trans);
        trans.setMinerOrganization(minerOrg);
       
    }
    
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
    
}
