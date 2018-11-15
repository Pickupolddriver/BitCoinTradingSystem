/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organizaiton;

import Business.Role.CashierRole;
import Business.Role.Role;
import Business.Role.TraderRole;
import java.util.ArrayList;

/**
 *
 * @author lijianxi
 */
public class CashierOrganization extends Organization{

    public CashierOrganization( ) {
        super(Organization.Type.Cashier.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CashierRole());
        return roles;
    }
    
}
