/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Blockchain.Block;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import static Business.Enterprise.Enterprise.EnterpriseType.Broker;
import static Business.Enterprise.Enterprise.EnterpriseType.Investor;
import static Business.Enterprise.Enterprise.EnterpriseType.Miner;
import Business.Network.Network;
import Business.Organizaiton.Organization;
import Business.Organizaiton.OrganizationDirectory;
import Business.Role.MinerRole;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author lijianxi
 */
public class initNetWork {

    public void initaNetWork(EcoSystem system, String nameOfNetwork) {
        //you need to give it a new System, and the name of the network;
        Network ogNetwork = system.createAndAddNetwork();
        ogNetwork.setName(nameOfNetwork);
        //Created 5 Enterprise and they will have their own Enterprise ID
        //From 0 to 4?
        Enterprise sysEnt = ogNetwork.getEnterpriseDirectory().createAndAddEnterprise("sys", Investor);
        Enterprise SantoshiEnterprise = ogNetwork.getEnterpriseDirectory().createAndAddEnterprise("se", Investor);
        Enterprise oe1 = ogNetwork.getEnterpriseDirectory().createAndAddEnterprise("oe1", Investor);
        Enterprise oe2 = ogNetwork.getEnterpriseDirectory().createAndAddEnterprise("oe2", Investor);
        //当加入了新的Investor之后会自动创建adminOrganization 和 TraderOrganization

        Enterprise minerEnterprise = ogNetwork.getEnterpriseDirectory().createAndAddEnterprise("miner1", Miner);
        Enterprise cashier1 = ogNetwork.getEnterpriseDirectory().createAndAddEnterprise("cashier1", Broker);
        cashier1.getWallet().setBuyPrice(43);
        cashier1.getWallet().setSellPrice(50); 

        //加入了3个Trader和一个Miner
        MagicClass mc = new MagicClass();

        this.addminer("miner1emp1", minerEnterprise);
        this.addminer("miner1emp2", minerEnterprise);
        this.addminer("miner1emp3", minerEnterprise);
        //seemp 挖出了第一个块
        Block block = mc.firstBlock(sysEnt, minerEnterprise);
        //sysemp trans 2100 btc to seemp
        mc.initalTrans(sysEnt, SantoshiEnterprise, minerEnterprise, block);
        mc.secondTrans(sysEnt, cashier1, minerEnterprise, block);
        //成功在Santoshi Enterprise里面完成了区块初始化；
        SantoshiEnterprise.getWallet().setBlockChaine(sysEnt.getWallet().getBlockChaine());
        oe1.getWallet().setBlockChaine(SantoshiEnterprise.getWallet().getBlockChaine());
        oe2.getWallet().setBlockChaine(SantoshiEnterprise.getWallet().getBlockChaine());
        WorkRequest wr = new WorkRequest();
        wr.setBc(SantoshiEnterprise.getWallet().getBlockChaine());
        wr.setStatus("Update Needed");
        system.getWorkQueue().getWorkRequestList().add(wr);

        //for (Enterprise entp : ogNetwork.getEnterpriseDirectory().getEnterpriseList()) {
        //  System.out.println(entp.getWallet().refreshCount());
        //}
    }

    public void addminer(String minername, Enterprise minerEnterprise) {
        //Add EnterpriseAdmin and bound to an user account 
        OrganizationDirectory od = minerEnterprise.getOrganizationDirectory();
        Organization minerOrg = od.createOrganization(Organization.Type.Digger);
        Employee minerx = minerOrg.getEmployeeDirectory().createEmployee(minername);
        minerOrg.getUserAccountDirectory().createUserAccount(minerx.getName(), minerx.getName(), minerx, new MinerRole());

    }

    /*public void addbroker(String brokername, Enterprise cashierEnterprise) {
        //Add EnterpriseAdmin and bound to an user account 
        OrganizationDirectory od = cashierEnterprise.getOrganizationDirectory();
        //create a Digger Organization
        Organization brokerorg = od.createOrganization(Organization.Type.Cashier);
        Employee Emp1 = brokerorg.getEmployeeDirectory().createEmployee(brokername);
        cashierEnterprise.getUserAccountDirectory().createUserAccount(brokername, brokername, Emp1, new CashierRole());
        //the code above is to create an admin account and add a MinerOrg and MinerEmployee to the minerEnterprise

    }*/
}
