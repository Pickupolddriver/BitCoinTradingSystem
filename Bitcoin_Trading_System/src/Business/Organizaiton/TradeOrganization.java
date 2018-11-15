/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organizaiton;

import Business.Role.Role;
import Business.Role.TraderRole;
import java.util.ArrayList;

/**
 *
 * @author lijianxi
 */
public class TradeOrganization extends Organization{

    public TradeOrganization( ) {
        super(Organization.Type.Trader.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ; //To change body of generated methods, choose Tools | Templates.
        ArrayList<Role> roles = new ArrayList();
        roles.add(new TraderRole());
        return roles;
    }
    
    
}
