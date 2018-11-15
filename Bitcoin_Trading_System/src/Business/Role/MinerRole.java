/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.MinerEnterprise;
import Business.Organizaiton.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.MinerRole.MinerWorkAreaJPanel;

/**
 *
 * @author lijianxi
 */
public class MinerRole extends Role {


   
   
//    public MinerWorkAreaJPanel(JPanel processPanel, EcoSystem business, DB4OUtil dB4OUtil,UserAccount u,MinerEnterprise e) {
//        initComponents();
//        this.processPanel = processPanel;
//        this.business = business;
//        this.dB4OUtil= dB4OUtil;
//        this.user=u;
//        this.me=e;
//    }

   


    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, DB4OUtil dB4OUtil, UserAccount u, Enterprise e) {
       return new MinerWorkAreaJPanel(userProcessContainer,business, dB4OUtil,account, (MinerEnterprise) e); //To change body of  / generated methods, choose Tools | Templates.
    }
    

}
