/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blockchain;

import Business.Enterprise.Enterprise;
import Business.Organizaiton.MinerOrganization;
import Business.Organizaiton.Organization;
import Business.UserAccount.*;
import java.util.Date;

/**
 *
 * @author lijianxi
 */
public class Transaction {

    private int ID;
    private int from;//OrganizationID----BitCoinsAccount
    private int to; //OrganizationID-----BitCoinsAccount
    private int btcAmount;
    private Enterprise minerOrganization;//The Miner who fist validte this transaction;
    private String locktime;//the Time when the first Miner Validate it;
    private int tranHashcode;
    private Date transactionDate;
    
    public Transaction() {
        
    }

    public Enterprise getMinerOrganization() {
        return  minerOrganization;
    }

    public void setMinerOrganization(Enterprise minerOrganization) {
        this.minerOrganization = minerOrganization;
    }

    
    


    public int getTranHashcode() {
        return tranHashcode;
    }

    public void setTranHashcode(int tranHashcode) {
        this.tranHashcode = tranHashcode;
    }

    public void refreshTranHashcode() {
        this.tranHashcode = String.valueOf(this.from).hashCode() + String.valueOf(this.to).hashCode() + this.locktime.hashCode();
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int   getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getBtcAmount() {
        return btcAmount;
    }

    public void setBtcAmount(int btcAmount) {
        this.btcAmount = btcAmount;
    }

    public String getLocktime() {
        return locktime;
    }

    public void setLocktime(String locktime) {
        this.locktime = locktime;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

}
