/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organizaiton.Organization;
import Business.Organizaiton.OrganizationDirectory;
import Business.Wallet.Wallet;

/**
 *
 * @author lijianxi
 */
public abstract class Enterprise extends Organization {

    //private int entpID = -1;
    private float balance;
    private int enterpriseId;
    private Wallet wallet;
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;

    public Enterprise(String name, EnterpriseType type,int id) {
        super(name);
        this.enterpriseId = id;
        this.enterpriseType = type;
        organizationDirectory = new OrganizationDirectory();
        this.wallet = new Wallet(enterpriseId);

        //In previous version, the enterpriseID will not change! 
        //So maybe this constructor made the problem.
    }

    public int getenterpriseId() {
        return enterpriseId;
    }

    public void setenterpriseId(int c) {
        this.enterpriseId = c;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public enum EnterpriseType {
        Investor("Investor"), Broker("Broker"), Miner("Miner");

        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

}
