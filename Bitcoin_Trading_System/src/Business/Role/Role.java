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
import static Business.Organizaiton.Organization.Type.Trader;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author lijianxi
 */
public abstract class Role {

    
    public enum RoleType {
        SystemAdmin(" SystemAdmin"),
        Cashier("Cashier"),
        trader("Trader"),
        Miner("Miner"),
        EnterpriseAdmin("EnterpriseAdmin");

        private String value;

        private RoleType(String value) {
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

    public abstract JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount account,
            Organization organization,
            Enterprise enterprise,
            EcoSystem business,
            DB4OUtil dB4OUtil,UserAccount u,Enterprise e);

    @Override
    public String toString() {
        return this.getClass().getName();
    }

    public void setType() {
    }
}
