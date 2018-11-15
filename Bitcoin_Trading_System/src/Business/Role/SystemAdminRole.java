/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organizaiton.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;

/**
 *
 * @author lijianxi
 */
public class SystemAdminRole extends Role {




    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, DB4OUtil dB4OUtil, UserAccount u, Enterprise e) {
       return new SystemAdminWorkAreaJPanel(userProcessContainer, business, dB4OUtil);//To change body of generated methods, choose Tools | Templates.
    }
    
}
